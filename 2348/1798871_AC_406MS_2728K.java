import java.util.Scanner;

public class Main
{
	static int len = 100;
	static int[][] memo = new int[1000][50];

	public static void main(String[] args)
	{
//		for (int i = 2; i < 50; i++)
//		{
//			int tfind=i+1;
//			for (int j = i+1; j < 1000; j++)
//			{
//				int tr = dp(i, j);
//				if (tr == -1)
//					tfind=Math.max(tfind, j);
//			}
//			System.out.println(i + "," + tfind + "  first lose" + " " + (tfind - i));
//		}
		Scanner cin = new Scanner(System.in);
		while (true)
		{
			long m = cin.nextLong();
			long n = cin.nextLong();
			if (m + n == 0)
				break;
			int re = solve(m, n);
			if (re == 1)
				System.out.println("Stan wins");
			else
				System.out.println("Ollie wins");
		}
	}
	public static int solve(long m,long n)
	{
		if(m<n)
		{
			long t=m;m=n;n=t;
		}
		if(n==0)
			return -1;
		if(n*2<=m)return 1;
		return -1*solve(m-n,n);
	}
	public static int dp(int m, int n)
	{
		if (m < n)
		{
			int t = m;
			m = n;
			n = t;
		}
		if (n == 0)
			return -1;
		if (memo[m][n] != 0)
			return memo[m][n];
		int fac = 1;
		while (true)
		{
			int d = (fac++) * n;
			if (m < d)
				break;
			int tr = dp(m - d, n);
			if (tr == -1)
				return memo[m][n] = 1;
		}
		return memo[m][n] = -1;
	}
}
