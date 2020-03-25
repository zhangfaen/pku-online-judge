import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
public class Main
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		String s = cin.readLine();
		String[] sa = s.split(" ");
		int N = Integer.parseInt(sa[0]);
		int M = Integer.parseInt(sa[1]);
		int[][] map = new int[N][N];
		int[] x = new int[M];
		int[] y = new int[M];
		for (int i = 0; i < M; i++)
		{
			s = cin.readLine();
			sa = s.split(" ");
			int a = Integer.parseInt(sa[0]);
			int b = Integer.parseInt(sa[1]);
			int cap = Integer.parseInt(sa[2]);
			map[a][b] = cap;
			x[i] = a;
			y[i] = b;
		}
		MaxFlow mf = new MaxFlow(N, map);
		mf.get(0, N - 1);
		int re = 0;
		for (int i = 0; i < M; i++)
		{
			int a = x[i];
			int b = y[i];
			int t = map[a][b];
			map[a][b] = Integer.MAX_VALUE / 2;
			boolean ok = mf.augmentable(0, N - 1);
			if (ok)
				re++;
			map[a][b] = t;
		}
		System.out.println(re);
	}
	static class MaxFlow
	{
		private int size;
		private int[][] cap;
		private int[] prev;
		/**
		 * size为网络中的点的个数，cap是其邻接矩阵，应该把其理解为有向图，(u,v)边 的权如果为0，表示不存在此边
		 */
		public MaxFlow(int size, int[][] cap)
		{
			this.size = size;
			this.cap = cap;
			this.prev=new int[size];
		}
		public void init(int size, int[][] cap)
		{
			this.size = size;
			this.cap = cap;
			this.prev=new int[size];
		}
		public boolean augmentable(int s, int t)
		{
			//prev = new int[size];
			Arrays.fill(prev, -1);
			List<Integer> q = new LinkedList<Integer>();
			q.add(s);
			prev[s] = s;
			while (q.size() > 0)
			{
				int cur = q.remove(0);
				for (int i = 0; i < size; i++)
				{
					if (cap[cur][i] > 0 && prev[i] == -1)
					{
						prev[i] = cur;
						if (i == t)
						{
							return true;
						} else
							q.add(i);
					}
				}
			}
			return false;
		}
		public int get(int s, int t)
		{
			int re = 0;
			while (augmentable(s, t))
			{
				int tmin = Integer.MAX_VALUE;
				for (int i = t; i != s; i = prev[i])
				{
					if (cap[prev[i]][i] < tmin)
						tmin = cap[prev[i]][i];
				}
				for (int i = t; i != s; i = prev[i])
				{
					cap[prev[i]][i] -= tmin;
					cap[i][prev[i]] += tmin;
				}
				re += tmin;
			}
			return re;
		}
	}
}