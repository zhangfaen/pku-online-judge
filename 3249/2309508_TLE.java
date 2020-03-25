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
	static List<Integer>[] map = new ArrayList[100001];
	static int[] memo;
	static int[] vs;
	static int[] incoming;
	static int[] outing;

	public static void main(String[] args) throws Exception
	{
		cin = new BufferedReader(new InputStreamReader(System.in));
		int[] q = new int[5000000];
		for (int i = 0; i < 100001; i++)
			map[i] = new ArrayList<Integer>();
		memo = new int[100001];
		vs = new int[100001];
		incoming = new int[100001];
		outing = new int[100001];
		while (true)
		{
			String s = cin.readLine();
			if (s == null)
				break;
			StringTokenizer st = new StringTokenizer(s);
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			for (int i = 0; i < n; i++)
			{
				incoming[i] = 0;
				outing[i] = 0;
				map[i].clear();
			}
			for (int i = 0; i < n; i++)
			{
				s = cin.readLine();
				vs[i] = Integer.parseInt(s);
			}
			for (int i = 0; i < m; i++)
			{
				s = cin.readLine();
				st = new StringTokenizer(s);
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x - 1].add(y - 1);
				incoming[y - 1]++;
				outing[x - 1]++;
			}
			for (int i = 0; i < n; i++)
				memo[i] = Integer.MIN_VALUE;
			int res = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++)
			{
				if (incoming[i] == 0)
				{
					int head = 0, tail = 0;
					memo[i] = vs[i];
					q[tail++] = i;
					while (head < tail)
					{
						int cn = q[head++];
						int cs = memo[cn];
						for (int j = 0; j < map[cn].size(); j++)
						{
							int next = map[cn].get(j);
							if (cs + vs[next] > memo[next])
							{
								memo[next] = cs + vs[next];
								q[tail++] = next;
							}
						}
					}
				}
			}
			for (int i = 0; i < n; i++)
				if (outing[i] == 0)
					res = Math.max(res, memo[i]);
			out.println(res);
		}
		out.flush();
	}
}
