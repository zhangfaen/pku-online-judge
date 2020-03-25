import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main
{
	static class Endge implements Comparable<Endge>
	{
		int i, j;
		double dis;

		public Endge(int a, int b, double c)
		{
			i = a;
			j = b;
			dis = c;
		}

		public int compareTo(Endge o)
		{
			return (int) Math.signum(dis - o.dis);
		}
	}
	static Endge[] es;
	static int n;
	static int[] xs;
	static int[] ys;

	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner cin = new Scanner(System.in);
		int scen = 0;
		while (true)
		{
			n = cin.nextInt();
			if (n == 0)
				break;
			scen++;
			es = new Endge[n * n];
			xs = new int[n];
			ys = new int[n];
			for (int i = 0; i < n; i++)
			{
				xs[i] = cin.nextInt();
				ys[i] = cin.nextInt();
			}
			int tag = 0;
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
				{
					if (i == j)
						continue;
					es[tag++] = new Endge(i, j, Math.hypot(xs[i] - xs[j], ys[i]
						- ys[j]));
				}
			Arrays.sort(es, 0, tag);
			double left = es[0].dis;
			double right = es[tag - 1].dis;
			while (true)
			{
				if (Math.abs(left - right) < 0.0001)
					break;
				double mid = (left + right) / 2;
				DisjointSet ds = new DisjointSet(n);
				for (int i = 0; i < tag; i++)
				{
					if (es[i].dis > mid)
						break;
					ds.union(es[i].i, es[i].j);
				}
				if (ds.find(0) == ds.find(1))
				{
					right = mid - 0.00001;
				} else
				{
					left = mid;
				}
			}
			System.out.println("Scenario #" + scen);
			System.out.printf("Frog Distance = %.3f\n\n", left);
		}
	}
	static class DisjointSet
	{
		private int[] p;
		private int n;
		private int[] rank;

		public DisjointSet(int n)
		{
			this.n = n;
			p = new int[n];
			rank = new int[n];
			for (int i = 0; i < n; i++)
				p[i] = i;
		}

		public void union(int x, int y)
		{
			link(find(x), find(y));
		}

		private void link(int x, int y)
		{
			if (rank[x] > rank[y])
			{
				p[y] = x;
			} else
			{
				p[x] = y;
				if (rank[x] == rank[y])
					rank[y]++;
			}
		}

		public int find(int x)
		{
			if (p[x] != x)
				p[x] = find(p[x]);
			return p[x];
		}
	}
}
