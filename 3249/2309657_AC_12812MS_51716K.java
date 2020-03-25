
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main
{
	static BufferedReader cin = null;
	static PrintWriter out = new PrintWriter(System.out);
	static int n, m;
	static List<Integer>[] map;
	static int[] memo;
	static boolean[] vst;
	static int[] vs;
	static int[] incoming;

	public static void main(String[] args) throws Exception
	{
		cin = new BufferedReader(new InputStreamReader(System.in));
		while (true)
		{
			String s = cin.readLine();
			if (s == null)
				break;
			StringTokenizer st=new StringTokenizer(s);
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map = new ArrayList[n];
			memo = new int[n];
			vst = new boolean[n];
			incoming = new int[n];
			vs = new int[n];
			for (int i = 0; i < n; i++)
				map[i] = new ArrayList<Integer>(10);
			for (int i = 0; i < n; i++)
			{
				s = cin.readLine();
				vs[i] = Integer.parseInt(s);
			}
			for (int i = 0; i < m; i++)
			{
				s = cin.readLine();
				st=new StringTokenizer(s);
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x - 1].add(y - 1);
				incoming[y - 1]++;
			}
			int res = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++)
			{
				if (incoming[i] == 0)
				{
					res = Math.max(res, dp(i));
				}
			}
			out.println(res);
		}
		out.flush();
	}

	public static int dp(int cn)
	{
		if (vst[cn])
			return memo[cn];
		vst[cn]=true;
		int fac = vs[cn];
		int re = Integer.MIN_VALUE;
		if (map[cn].size() == 0)
			re = fac;
		else
			for (int next : map[cn])
			{
				int d = dp(next);
				re = Math.max(re, fac + d);
			}
		memo[cn] = re;
		return re;
	}
}