import java.util.*;
import java.io.*;

public class Main
{
	static int n=400;
	static int[][] memo = new int[n][n];
	public static void main(String[] args) throws Exception
	{
		//Scanner cin = new Scanner(System.in);
		BufferedReader cin=new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String s=cin.readLine();
			if(s==null)
				return ;
			String [] sa=s.split(" ");
			long a=Long.parseLong(sa[0]);
			long b=Long.parseLong(sa[1]);
			if(a>b)
			{
				long t=a;a=b;b=t;
			}
			if(a==0&&b==0)
			{
				System.out.println(0);
				continue;
			}
			if(a==b||a==0||b==0)
			{
				System.out.println(1);
				continue;
			}
			long n=b-a;
			long c=(long)(n*(Math.sqrt(5)+1)/2);
			long d=(long)(n*(Math.sqrt(5)+3)/2);
			if(a==c&&b==d)
			{
				System.out.println(0);
			}
			else
				System.out.println(1);
		}
	}
	// 条件：x<y
	//函数作用：判断(x,y)是必胜还是必败
	public static int dp(int x, int y)
	{
		if (memo[x][y] != 0)
			return memo[x][y];
		if (x == 0 && y == 0)
			return -1;
		if (x == 0 || y == 0)
			return 1;
		int re = 0;
		for (int i = 1; i <= x; i++)
		{
			int d = dp(x - i, y - i);
			if (d == -1)
				return memo[x][y] = 1;
		}
		for (int i = 1; i <= x; i++)
		{
			int d = dp(x - i, y);
			if (d == -1)
				return memo[x][y] = 1;
		}
		for (int i = 1; i <= y; i++)
		{
			int d = dp(Math.min(x, y - i), Math.max(x, y - i));
			if (d == -1)
				return memo[x][y] = 1;
		}
		return memo[x][y] = -1;
	}
}