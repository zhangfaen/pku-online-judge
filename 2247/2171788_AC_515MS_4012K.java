import java.io.*;
import java.util.*;
import java.math.*;

public class Main
{
	static List[] map;
	static int n;
	static int[][] memo;
	static BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException
	{
		PriorityQueue<Long> q = new PriorityQueue<Long>();
		q.add(1L);
		int[] fs = { 2, 3, 5, 7 };
		Long[] p = new Long[6000];
		int tag = 0;
		Set<Long> si = new HashSet<Long>();
		out: while (tag < 5900)
		{
			long v = q.poll();
			if (si.contains(v))
				continue;
			si.add(v);
			p[tag++] = v;
			for (int d : fs)
			{
				q.add(d * v);
			}
		}
		PrintWriter out = new PrintWriter(System.out);
		while (true)
		{
			String s = cin.readLine();
			int n = Integer.parseInt(s);
			if (n == 0)
				break;
			int fac = n % 10;
			int tt = n / 10 % 10;
			Long v = p[n - 1];
			if (fac == 1 && tt != 1)
			{
				out.println("The " + n + "st humble number is " + v + ".");
			} else if (fac == 2 && tt != 1)
			{
				out.println("The " + n + "nd humble number is " + v + ".");
			} else if (fac == 3 && tt != 1)
			{
				out.println("The " + n + "rd humble number is " + v + ".");
			} else
			{
				out.println("The " + n + "th humble number is " + v + ".");
			}
		}
		out.flush();
	}
}