import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
public class Main
{
	
	public static void main(String[] args) throws Exception
	{
		BufferedReader cin=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		String s=cin.readLine();
		int testcase=Integer.parseInt(s);
		
		while(testcase-->0)
		{
			s=cin.readLine();
			String [] sa=s.split(" ");
			int m=Integer.parseInt(sa[0]);
			int n=Integer.parseInt(sa[1]);
			int [] p=new int[n];
			int [] q=new int[n];
			int [] temp=new int[n*n];
			s=cin.readLine();
			sa=s.split(" ");
			for(int i=0;i<n;i++)
			{
				p[i]=Integer.parseInt(sa[i]);
			}
			for(int j=0;j<m-1;j++)
			{
				s=cin.readLine();
				sa=s.split(" ");
				for(int k=0;k<n;k++)
					q[k]=Integer.parseInt(sa[k]);
				int tag=0;
				for(int x=0;x<n;x++)
					for(int y=0;y<n;y++)
						temp[tag++]=p[x]+q[y];
				Arrays.sort(temp);
				for(int i=0;i<n;i++)
					p[i]=temp[i];
			}
			for(int i=0;i<n;i++)
			{
				out.print(p[i]);
				out.print(" ");
			}
			out.println();
		}
		out.flush();
	}
	
}