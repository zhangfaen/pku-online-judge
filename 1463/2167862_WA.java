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
		while (true)
		{
			String s = cin.readLine();
			if (s == null || s.equals(""))
				break;
			n = Integer.parseInt(s);
			map = new ArrayList[n];
			for (int i = 0; i < n; i++)
				map[i] = new ArrayList(11);
			for (int i = 0; i < n; i++)
			{
				StringTokenizer st = new StringTokenizer(cin.readLine());
				s = st.nextToken();
				String[] t = s.split(":");
				int end = Integer.parseInt(t[1].substring(1, t[1].length() - 1));
				int src = Integer.parseInt(t[0]);
				for (int j = 0; j < end; j++)
				{
					int to = Integer.parseInt(st.nextToken());
					map[src].add(to);
					map[to].add(src);
				}
			}
			try
			{
				removeSomeEndge(0);
			} catch (Exception e)
			{
			}
			memo = new int[n][2];
			for (int i = 0; i < n; i++)
				memo[i][0] = memo[i][1] = -1;
			for (int i = 0; i < n; i++)
				if (map[i].size() == 0)
				{
					memo[i][1] = 1;
					memo[i][0] = 0;
				}
			int res = 0;
			res = dp(0, 0);
			System.out.println(res);
			// System.gc();
		}
	}

	public static void removeSomeEndge(int cur)
	{
		if (map[cur].size() > 0)
		{
			for (int i = 0; i < map[cur].size(); i++)
			{
				Integer to = (Integer) map[cur].get(i);
				map[to].remove((Object) (Integer.valueOf(cur)));
			}
			for (int i = 0; i < map[cur].size(); i++)
			{
				Integer to = (Integer) map[cur].get(i);
				removeSomeEndge(to);
			}
		}
	}

	public static int dp(int cn, int tag)
	{
		if (memo[cn][tag] != -1)
			return memo[cn][tag];
		int re = 1;
		int cnsize = map[cn].size();
		int tmin = Integer.MAX_VALUE;
		int d = 0;
		for (int i = 0; i < cnsize; i++)
			d += dp((Integer) map[cn].get(i), 0);
		tmin = Math.min(tmin, d);
		re += tmin;
		if (tag == 0)
		{
			tmin = Integer.MAX_VALUE;
			d = 0;
			for (int k = 0; k < cnsize; k++)
			{
				d = dp((Integer) map[cn].get(k), 1);
			}
			tmin = Math.min(tmin, d);
			re = Math.min(re, tmin);
		}
		memo[cn][tag] = re;
		return re;
	}
}