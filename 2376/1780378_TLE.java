import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main
{
	static class Interv implements Comparable<Interv>
	{
		int x, y;

		public Interv(int a, int b)
		{
			x = a;
			y = b;
		}

		public int compareTo(Interv o)
		{
			if (x != o.x)
				return x - o.x;
			return y - o.y;
		}

		public String toString()
		{
			return x + " " + y;
		}
	}

	public static void main(String[] args) throws Exception
	{
		// int [] p={2 ,4,6};
		// System.out.println(Arrays.binarySearch(p, 3));
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		String s = cin.readLine();
		String[] sa = s.split(" ");
		int n = Integer.parseInt(sa[0]);
		int t = Integer.parseInt(sa[1]);
		Interv[] itvs = new Interv[n];
		for (int i = 0; i < n; i++)
		{
			s = cin.readLine();
			sa = s.split(" ");
			int x = Integer.parseInt(sa[0]);
			int y = Integer.parseInt(sa[1]);
			Interv itv1 = new Interv(x, y);
			itvs[i] = itv1;
		}
		Arrays.sort(itvs);
		int[] px = new int[n];
		int[] py = new int[n];
		for (int i = 0; i < n; i++)
		{
			px[i] = itvs[i].x;
			py[i] = itvs[i].y;
		}
		int a = 1, b = 1;
		int re = 0;
		for (int i = 0; i < n; i++)
		{
			if (px[i] <= a)
			{
				b = Math.max(b, py[i]);
			} else
			{
				i--;
				a = b + 1;
				re++;
			}
		}
		if (b < t)
			System.out.println(-1);
		else if (a <= t)
		{
			re++;
			System.out.println(re);
		}
	}
}
