import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main
{
	static class Comp
	{
		int stx, len, cost, fun;

		public Comp(int stx, int len, int cost, int fun)
		{
			this.stx = stx;
			this.len = len;
			this.cost = cost;
			this.fun = fun;
		}

		public String toString()
		{
			String re = "";
			re += "start x:" + stx + " len:" + len + " cost:" + cost + " fun:" + fun;
			return re;
		}
	}
	static BufferedReader cin = null;
	static PrintWriter out = new PrintWriter(System.out);
	static int len, n, buget;
	static long[][] memo;
	static boolean[][] vst;
	static long INF = Long.MIN_VALUE / 2;
	static List<Comp>[] lcs;

	public static void main(String[] args) throws Exception
	{
		cin = new BufferedReader(new InputStreamReader(System.in));
		String s = cin.readLine();
		StringTokenizer st = new StringTokenizer(s);
		len = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		buget = Integer.parseInt(st.nextToken());
		memo = new long[len][buget + 1];
		vst = new boolean[len][buget + 1];
		lcs = new ArrayList[len];
		for (int i = 0; i < len; i++)
			lcs[i] = new ArrayList<Comp>();
		for (int i = 0; i < n; i++)
		{
			s = cin.readLine();
			st = new StringTokenizer(s);
			int stx = Integer.parseInt(st.nextToken());
			int slen = Integer.parseInt(st.nextToken());
			int fun = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			lcs[stx].add(new Comp(stx, slen, cost, fun));
		}
		long res = dp(0, buget);
		if (res < 0)
			res = -1;
		System.out.println(res);
	}

	public static long dp(int clen, int cb)
	{
		if (clen == len)
			return 0;
		if (vst[clen][cb])
			return memo[clen][cb];
		vst[clen][cb] = true;
		long re = INF;
		for (int i = 0; i < lcs[clen].size(); i++)
		{
			Comp comp = lcs[clen].get(i);
			if (cb >= comp.cost && clen + comp.len <= len)
			{
				long t = comp.fun;
				t += dp(clen + comp.len, cb - comp.cost);
				re = Math.max(re, t);
			}
		}
		memo[clen][cb] = re;
		return re;
	}
}
