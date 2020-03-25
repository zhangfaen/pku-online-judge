import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main
{
	static char[] map;
	static int n;
	static int[][] memo;
	static int[][] best;

	public static void main(String[] args) throws Exception
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		String s = cin.readLine().trim();
		map=s.toCharArray();
		n=map.length;
		memo=new int[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				memo[i][j]=-1;
		best=new int[n][n];
		int res=dp(0,n-1);
		print(0,n-1);
		System.out.println();
	}
	public static void print(int i,int j)
	{
		if(j<i)
			return;
		if(i==j)
		{
			if(map[i]=='('||map[i]==')')
				System.out.print("()");
			if(map[i]=='['||map[i]==']')
				System.out.print("[]");
			return;
		}
		if(match(i,j))
		{
			System.out.print(map[i]);
			print(i+1,j-1);
			System.out.print(map[j]);
			return;
		}
		int d=best[i][j];
		print(i,d);
		print(d+1,j);
	}
	public static int dp(int i,int j)
	{
		if(j<i)
			return 0;
		if(i==j)
			return 1;
		if(memo[i][j]!=-1)
			return memo[i][j];
		if(match(i,j))
		{
			return memo[i][j]=dp(i+1,j-1);
		}
		int re=Integer.MAX_VALUE;
		for(int k=i;k<j;k++)
		{
			int d=dp(i,k)+dp(k+1,j);
			if(d<re)
			{
				re=d;
				best[i][j]=k;
			}
		}
		return memo[i][j]=re;
	}
	public static boolean match(int i,int j)
	{
		if(map[i]=='['&&map[j]==']'||map[i]=='('&&map[j]==')')
			return true;
		return false;
	}
}
