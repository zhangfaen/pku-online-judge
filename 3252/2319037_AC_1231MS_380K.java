import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main
{
	static BufferedReader cin = null;
	static PrintWriter out = new PrintWriter(System.out);
	static char[] lc;
	static char[] hc;
	static int high;
	static int low;

	public static void main(String[] args) throws Exception
	{
		cin = new BufferedReader(new InputStreamReader(System.in));
		String s = cin.readLine();
		String[] sa = s.split(" ");
		high = Integer.parseInt(sa[1]);
		low = Integer.parseInt(sa[0]) - 1;
		lc = Integer.toBinaryString(low).toCharArray();
		hc = Integer.toBinaryString(high).toCharArray();
		int re = calc(hc);
		re -= calc(lc);
		System.out.println(re);
	}

	public static int calc(char[] c)
	{
		int res = 0;
		for (int i = 2; i < c.length; i++)
		{
			res += get(i - 1, i % 2 == 0 ? i / 2 : i / 2 + 1);
		}
		int zeros = 0;
		int half = c.length % 2 == 0 ? c.length / 2 : c.length / 2 + 1;
		for (int i = 1; i <c.length; i++)
		{
			if (c[i] == '0')
			{
				zeros++;
				continue;
			}
			int need = half - zeros - 1;
			if (need < 0)
				need = 0;
			res += get(c.length-i-1, need);
		}
		if (zeros >= half)
			res++;
		return res;
	}

	public static int get(int s, int zeros)
	{
		if (zeros > s)
			return 0;
		if (zeros == s)
			return 1;
		long res=0;
		for (int k = zeros; k <= s; k++)
		{
			long re = 1;
			for (int i = s, j = 1; j <= k; i--, j++)
			{
				re *= i;
				re /= j;
			}
			res+=re;
		}
		return (int) res;
	}
}
