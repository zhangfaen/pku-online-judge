import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main
{
	static int n;
	static int [] p;
	static char [] step;
	static int res=Integer.MAX_VALUE;
	static String os="";
	static int [] sum;
	static int [][] memo;
	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String s=in.readLine();
		int ts=Integer.parseInt(s);
		while (ts-->0)
		{
			s=in.readLine();
			n=Integer.parseInt(s);
			p=new int[n];
			s=in.readLine();
			String [] sa=s.split(" ");
			int tot=0;
			sum=new int[n];
			for(int i=0;i<n;i++)
			{
				p[i]=Integer.parseInt(sa[i]);
				tot+=p[i];
				if(i==0)
					sum[i]=p[i];
				else
					sum[i]=sum[i-1]+p[i];
			}
			step=new char[n];
			if(tot%2==1)
			{
				out.println("IMPOSSIBLE");
			}
			else
			{
				res=Integer.MAX_VALUE;
				os="";
				memo=new int[tot+1][n];
				for(int i=0;i<n;i++)
					for(int j=0;j<tot+1;j++)
						memo[j][i]=-1;
				dfs(0,0,0);
				if(os.equals(""))
					out.println("IMPOSSIBLE");
				else
					out.println(os);
			}
			out.flush();
		}
		
	}
	public static void dfs(int cur,int d,int mc)
	{
		if(d==n)
		{
			if(cur==0&&mc<res)
			{
				os=new String(step);
				res=mc;
			}
			return;
		}
		if(memo[cur][d]!=-1&&memo[cur][d]<=mc)
			return;
		memo[cur][d]=mc;
		int t=0;
		if(d>0)t=sum[d-1];
		if(cur>sum[n-1]-t)
			return;
		step[d]='U';
		dfs(cur+p[d],d+1,Math.max(mc, cur+p[d]));
		if(cur>=p[d])
		{
			step[d]='D';
			dfs(cur-p[d],d+1,mc);
		}
	}
}

