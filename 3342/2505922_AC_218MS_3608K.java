import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main
{
	static class Pair
	{
		boolean two;
		int max;

		public Pair(boolean two, int max)
		{
			this.two = two;
			this.max = max;
		}
	}
	static int n;
	static List<Integer>[] map;
	static Pair[][] memo;

	public static void main(String[] args) throws IOException
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		while (true)
		{
			String s = cin.readLine();
			if (s.equals("0"))
				break;
			int id = 0;
			Map<String, Integer> ids = new HashMap<String, Integer>();
			n = Integer.parseInt(s);
			map = new ArrayList[n];
			for (int i = 0; i < n; i++)
				map[i] = new ArrayList<Integer>();
			s = cin.readLine();
			ids.put(s, id++);
			for (int i = 0; i < n - 1; i++)
			{
				s = cin.readLine();
				String[] sa = s.split(" ");
				int cid = -1, fid = -1;
				if (ids.containsKey(sa[0]))
					cid = ids.get(sa[0]);
				else
					ids.put(sa[0], cid = id++);
				if (ids.containsKey(sa[1]))
					fid = ids.get(sa[1]);
				else
					ids.put(sa[1], fid = id++);
				map[fid].add(cid);
			}
			memo = new Pair[n][2];
			Pair p = dp(0, 0);
			System.out.print(p.max+" ");
			if (p.two==false)
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}

	public static Pair dp(int ci, int tag)
	{
		if (memo[ci][tag] != null)
			return memo[ci][tag];
		if (map[ci].size() == 0)
		{
			if (tag == 1)
				return new Pair(false, 0);
			else
				return new Pair(false, 1);
		}
		int re = 0;
		boolean two = false;
		int d = 0;
		boolean temp = false;
		for (int next : map[ci])
		{
			Pair p = dp(next, 0);
			re += p.max;
			two |= p.two;
		}
		if (tag == 0)
		{
			d = 1;
			for (int next : map[ci])
			{
				Pair p = dp(next, 1);
				d += p.max;
				temp |= p.two;
			}
			if (d == re)
			{
				two = true;
			}
			if (d > re)
			{
				re = d;
				two = temp;
			}
		}
		memo[ci][tag] = new Pair(two, re);
		return memo[ci][tag];
	}
}