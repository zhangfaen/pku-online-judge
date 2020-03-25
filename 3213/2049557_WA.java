import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Main
{

	public static void main(String[] args) throws Exception
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String s=cin.readLine();
		String [] sa=s.split(" ");
		int n,p,m;
		n=Integer.parseInt(sa[0]);
		p=Integer.parseInt(sa[1]);
		m=Integer.parseInt(sa[2]);
		int [][] A=new int[n][p];
		int [][] B=new int[p][m];
		int [][] C=new int[n][m];
		for(int i=0;i<n;i++)
		{
			s=cin.readLine();
			sa=s.split(" ");
			for(int j=0;j<p;j++)
				A[i][j]=Integer.parseInt(sa[j]);
		}
		for(int i=0;i<p;i++)
		{
			s=cin.readLine();
			sa=s.split(" ");
			for(int j=0;j<m;j++)
				B[i][j]=Integer.parseInt(sa[j]);
		}
		for(int i=0;i<n;i++)
		{
			s=cin.readLine();
			sa=s.split(" ");
			for(int j=0;j<m;j++)
				C[i][j]=Integer.parseInt(sa[j]);
		}
		int [] sum_c_row=new int[n];
		int [] sum_c_col=new int[m];
		int [] total_a_row=new int[p];
		int [] total_b_col=new int[p];
		for(int i=0;i<n;i++)
			for(int j=0;j<p;j++)
			{
				total_a_row[j]+=A[i][j];
			}
		for(int i=0;i<p;i++)
			for(int j=0;j<m;j++)
			{
				total_b_col[i]+=B[i][j];
			}
		int ri=-1,rc=-1,ri_sum=0,rc_sum=0;
		for(int i=0;i<n;i++)
		{
			int tsum=0;
			for(int j=0;j<m;j++)
				tsum+=C[i][j];
			sum_c_row[i]=tsum;
			int real_sum=v_m_v(A[i],total_b_col);
			if(tsum!=real_sum)
			{
				ri=i;
				ri_sum=real_sum;
				break;
			}
		}
		for(int j=0;j<m;j++)
		{
			int tsum=0;
			for(int i=0;i<n;i++)
				tsum+=C[i][j];
			sum_c_col[j]=tsum;
			int [] bj=new int[p];
			for(int i=0;i<p;i++)
				bj[i]=B[i][j];
			int real_sum=v_m_v(total_a_row,bj);
			if(tsum!=real_sum)
			{
				rc=j;
				rc_sum=real_sum;
				break;
			}
		}
		if(ri!=-1&&rc!=-1)
		{
			out.println("NO");
			out.println((ri+1)+" "+(rc+1));
			out.println(C[ri][rc]+ri_sum-sum_c_row[ri]);
		}
		else
		{
			out.println("YES");
		}
		out.flush();
	}
	public static int v_m_v(int [] p,int [] q)
	{
		int re=0;
		for(int i=0;i<p.length;i++)
			re+=p[i]*q[i];
		return re;
	}
}