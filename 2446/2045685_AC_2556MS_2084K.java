import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
public class Main
{
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	public static void main(String[] args) throws Exception
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String s = cin.readLine();
		String[] sa = s.split(" ");
		int m = Integer.parseInt(sa[0]);
		int n = Integer.parseInt(sa[1]);
		int k = Integer.parseInt(sa[2]);
		int[][] map = new int[m][n];

		int tag1 = 1, tag2 = -1;
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
			{
				if ((i+j)%2==0)
					map[i][j] = tag1++;
				else
					map[i][j] = tag2--;
			}
		for (int i = 0; i < k; i++)
		{
			s = cin.readLine();
			sa = s.split(" ");
			int y = Integer.parseInt(sa[0]);
			int x = Integer.parseInt(sa[1]);
			map[x - 1][y - 1] = 0;
		}
		int wlen = 0, blen = 0;
		if (m * n % 2 == 0)
		{
			wlen = m * n / 2;
			blen = m * n / 2;
		} else
		{
			wlen = m * n / 2 + 1;
			blen = m * n / 2;
		}
		boolean[][] bm = new boolean[wlen][blen];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
			{
				if (map[i][j] != 0)
				{
					for (int d = 0; d < 4; d++)
					{
						int ni = i + dx[d];
						int nj = j + dy[d];
						if (ni < 0 || ni >= m || nj < 0 || nj >= n)
							continue;
						if (map[ni][nj] != 0)
						{
							if (map[i][j] > 0)
								bm[Math.abs(map[i][j]) - 1][Math.abs(map[ni][nj]) - 1] = true;
							else
								bm[Math.abs(map[ni][nj]) - 1][Math.abs(map[i][j]) - 1] = true;
						}
					}
				}
			}
		int maxMatch = BiGraph.get(wlen, blen, bm);
		if (maxMatch * 2 + k == m * n)
		{
			out.println("YES");
		} else
		{
			out.println("NO");
		}
		out.flush();
	}
	static class BiGraph
	{
		static int m, n;
		static boolean[][] map;
		static int[] match1;
		static int[] match2;
		public static int get(int tm, int tn, boolean[][] tmap)
		{
			m = tm;
			n = tn;
			map = tmap;
			match1 = new int[m];
			match2 = new int[n];
			Arrays.fill(match1, -1);
			Arrays.fill(match2, -1);
			int re = 0;
			for (int i = 0; i < m; i++)
				re += find(i);
			return re;
		}
		private static int find(int s)
		{
			int[] back = new int[n];
			Arrays.fill(back, -1);
			List<Integer> q = new LinkedList<Integer>();
			q.add(s);
			while (q.size() > 0)
			{
				int cur = q.remove(0);
				for (int i = 0; i < n; i++)
				{
					if (map[cur][i] && back[i] == -1)
					{
						if (match2[i] >= 0)
						{
							back[i] = cur;
							q.add(match2[i]);
						} else
						{
							while (true)
							{
								int ni = match1[cur];
								match1[cur] = i;
								match2[i] = cur;
								if (ni == -1)
									break;
								cur = back[ni];
								i = ni;
							}
							return 1;
						}
					}
				}
			}
			return 0;
		}
	}
}