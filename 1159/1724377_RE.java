import java.io.*;
import java.util.*;
import java.math.*;

public class Main
{
	static String s;
	static char[][] memo;
	static int n;
	static char[] p;

	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String ts = in.readLine();
		n = Integer.parseInt(ts);
		s = in.readLine();
		p = s.toCharArray();
		//memo = new char[n][n];
		memo=new char[n][];
		for(int i=0;i<n;i++)
		{
			memo[i]=new char[n-i];
			for(int j=0;j<n-i;j++)
				memo[i][j]=Character.MAX_VALUE;
		}
//		for (int i = 0; i < n; i++)
//			for (int j = 0; j < n; j++)
//				memo[i][j] = Character.MAX_VALUE;
		int re = dp(0, n - 1);
		System.out.println(re);
	}

	public static int dp(int i, int j)
	{
		if (i >= j)
			return 0;
		if (memo[i][j-i] != Character.MAX_VALUE)
			return memo[i][j];
		int re = Integer.MAX_VALUE;
		if (p[i] == p[j])
		{
			re = dp(i + 1, j - 1);
		} else
		{
			re = Math.min(re, 1 + dp(i + 1, j));
			re = Math.min(re, 1 + dp(i, j - 1));
		}
		return memo[i][j-i] = (char)re;
	}
}