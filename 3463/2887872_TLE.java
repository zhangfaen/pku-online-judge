import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(cin.readLine());
		while (cnt-- > 0)
		{
			StringTokenizer st = new StringTokenizer(cin.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			List<Integer>[] map = new ArrayList[n];
			for (int i = 0; i < n; i++)
				map[i] = new ArrayList<Integer>();
			for (int i = 0; i < m; i++)
			{
				st = new StringTokenizer(cin.readLine());
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				int len = Integer.parseInt(st.nextToken());
				map[a].add(b);
				map[a].add(len);
			}
			st = new StringTokenizer(cin.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int t = Integer.parseInt(st.nextToken()) - 1;
			int[] best = new int[n];
			Arrays.fill(best, Integer.MAX_VALUE);
			best[s] = 0;
			List<Integer> q = new LinkedList<Integer>();
			q.add(s);
			while (!q.isEmpty())
			{
				int cur = q.remove(0);
				for (int i = 0; i < map[cur].size(); i += 2)
				{
					int next = map[cur].get(i);
					int len = map[cur].get(i + 1);
					if (best[cur] + len < best[next])
					{
						best[next] = best[cur] + len;
						q.add(next);
					}
				}
			}
			int[][] memo = new int[n][2];
			memo[s][0] = 1;
			q.add(s);
			while (!q.isEmpty())
			{
				int cur = q.remove(0);
				Set<Integer> insert = new HashSet<Integer>();
				for (int i = 0; i < map[cur].size(); i += 2)
				{
					int next = map[cur].get(i);
					int len = map[cur].get(i + 1);
					boolean need = false;
					if (best[cur] + len == best[next])
					{
						memo[next][0] += memo[cur][0];
						memo[next][1] += memo[cur][1];
						need = true;
					}
					if (best[cur] + len == best[next] + 1)
					{
						memo[next][1] += memo[cur][0];
						need = true;
					}
					if (need)
						insert.add(next);
				}
				for (int d : insert)
					if (q.contains(d) == false)
						q.add(d);
			}
			int res = memo[t][0] + memo[t][1];
			System.out.println(res);
		}
	}
}
