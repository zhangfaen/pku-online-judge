import java.util.*;
import java.io.*;

public class Main
{
	static int m, n;
	static long tsum = 0;
	static int pn;
	public static void main(String[] args) throws Exception
	{
		Scanner cin = new Scanner(System.in);
		while (true)
		{
			m = cin.nextInt();
			n = cin.nextInt();
			if (m + n == 0)
				break;
			if (m * n % 2 == 1)
			{
				System.out.println(0);
				continue;
			}
			if (n > m)
			{
				int t = n;
				n = m;
				m = t;
			}
			pn = (int) Math.pow(2, n);
			long[][] p = new long[pn][pn];
			for (int i = 0; i < pn; i++)
				for (int j = 0; j < pn; j++)
				{
					tsum = 0;
					get(gs(i), gs(j));
					p[i][j] = tsum;
				}
			long[][] q = new long[m][pn];
			for (int i = 0; i < pn; i++)
				q[0][i] = p[pn - 1][i];
			for (int i = 1; i < m; i++)
				for (int j = 0; j < pn; j++)
					for (int k = 0; k < pn; k++)
						q[i][j] += q[i - 1][k] * p[k][j];
			System.out.println(q[m - 1][pn - 1]);
		}
	}

	public static String gs(int a)
	{
		String re = Integer.toBinaryString(a);
		while (re.length() < n)
			re = "0" + re;
		return re;
	}

	public static void get(String s, String t)
	{
		if (s.length() == 0 && t.length() == 0)
		{
			tsum++;
			return;
		}
		if (s.charAt(0) == '1')
		{
			if (t.charAt(0) == '0')
				get(s.substring(1), t.substring(1));
			else
				if (t.length() > 1 && t.charAt(1) == '1')
					get(s.substring(1), "0" + t.substring(2));
		} 
		else
		if (t.charAt(0) == '1')
			get(s.substring(1), t.substring(1));
	}
}
