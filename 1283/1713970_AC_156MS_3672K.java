import java.io.*;
import java.util.*;
import java.math.*;

public class Main
{
	static long[][] memo;
	static int k;
	static int n;

	public static void main(String[] args)
	{
		Scanner cin = new Scanner(System.in);
		while(true)
		{
			n = cin.nextInt();
			k = cin.nextInt();
			
			if(k+n==0)
				break;
			memo = new long[n + 1 ][k + 1];
			for (int i = 0; i < n + 1; i++)
				for (int j = 1; j < k + 1; j++)
				{
					if (i < j)
						memo[i][j] = 0;
					else if (j == 1)
						memo[i][j] = 1;
					else
					{
						memo[i][j] = (memo[i - 1][j - 1] + memo[i - j][j]) ;
					}
				}
			long re = memo[n ][k];
			System.out.println(re);
		}
		
	}

//	public static int dp(int n, int k)
//	{
//		if (memo[n][k] != -1)
//			return memo[n][k];
//		int re = 0;
//		re += dp(n - 1, k - 1) + dp(n - k, k);
//		return memo[n][k] = re % 1000000007;
//	}
}
