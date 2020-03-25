
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
	static int n;
	static long c;
	static long [][][] memo;
	static int []res;
	public static void main(String[] args) throws Exception
	{
		// BufferedReader cin=new BufferedReader(new
		// InputStreamReader(System.in));
		// PrintWriter out=new PrintWriter(System.out);
		Scanner cin = new Scanner(System.in);
		int testcase=cin.nextInt();
		n=20;
		memo=new long[2][n][1<<14];
		while(testcase-->0)
		{
			n=cin.nextInt();
			c=cin.nextLong();
			for(int i=0;i<n;i++)
				for(int j=0;j<(1<<14);j++)
					for(int k=0;k<2;k++)
						memo[k][i][j]=-1;
			int state=(1<<n)-1;
			res=new int[n];
			for(int i=0;i<n;i++)
			{
				long d1=dp(0,i,state&(~(1<<i)));
				if(d1>=c)
				{
					res[0]=i;
					dfs(0,i,state&(~(1<<i)),c,1);
					break;
				}
				else
				{
					c-=d1;
				}
				
				d1=dp(1,i,state&(~(1<<i)));
				if(d1>=c)
				{
					res[0]=i;
					dfs(1,i,state&(~(1<<i)),c,1);
					break;
				}
				else
				{
					c-=d1;
				}
			}
			for(int i=0;i<n;i++)
				System.out.print((res[i]+1)+" ");
			System.out.println();
		}
	}
	public static void dfs(int style,int pi,int state,long cc,int depth)
	{
		if(depth==n)return;
		if(style==0)
		{
			for(int i=0;i<n;i++)
			{
				if(i<pi&&((1<<i)&state)!=0)
				{
					long d1=dp(1,i,state&(~(1<<i)));
					if(d1>=cc)
					{
						res[depth]=i;
						dfs(1,i,state&(~(1<<i)),cc-d1,depth+1);
						break;
					}
				}
			}
		}
		else
		{
			for(int i=0;i<n;i++)
			{
				if(i>pi&&((1<<i)&state)!=0)
				{
					long d1=dp(0,i,state&(~(1<<i)));
					if(d1>=cc)
					{
						res[depth]=i;
						dfs(0,i,state&(~(1<<i)),cc-d1,depth+1);
						break;
					}
				}
			}
		}
		
	}
	public static long dp(int style,int pi,int state)
	{
		if(state==0)return 1;
		if(state<(1<<14)&&memo[style][pi][state]!=-1)
			return memo[style][pi][state];
		long re=0;
		if(style==0)
		{
			// down
			for(int i=0;i<n;i++)
			{
				if(((1<<i)&state)!=0&&i<pi)
				{
					int ns=state&(~(1<<i));
					re+=dp(1,i,ns);
				}
			}
		}
		else
		{
			//up
			for(int i=0;i<n;i++)
			{
				if(((1<<i)&state)!=0&&i>pi)
				{
					int ns=state&(~(1<<i));
					re+=dp(0,i,ns);
				}
			}
		}
		if(state<(1<<14))
			memo[style][pi][state]=re;
		return re;
	}
}
