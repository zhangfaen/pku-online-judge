import java.io.*;
import java.util.*;
import java.math.*;
public class Main
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();
		String[] sa = s.split(" ");
		int n = Integer.parseInt(sa[0]);
		int m = Integer.parseInt(sa[1]);
		int[] x = new int[m];
		int[] y = new int[m];
		for (int i = 0; i < m; i++)
		{
			s = in.readLine();
			sa = s.split(" ");
			int a = Integer.parseInt(sa[0]);
			int b = Integer.parseInt(sa[1]);
			x[i] = Math.min(a, b);
			y[i] = Math.max(a, b);
		}
		boolean re = true;
		DisjointSet ds = new DisjointSet(m);
		out: for (int i = 0; i < m; i++)
			for (int j = i + 1; j < m; j++)
			{
				if (inter(x[i], y[i], x[j], y[j]))
				{
					int fi = ds.find(i);
					int fj = ds.find(j);
					if (fi == fj && ds.relate[i] == ds.relate[j])
					{
						re = false;
						break out;
					} else
						ds.union(i, j);
				}
			}
		if (re)
			System.out.println("panda is telling the truth...");
		else
			System.out.println("the evil panda is lying again");
	}
	public static boolean inter(int x0, int y0, int x1, int y1)
	{
		if (x1 > x0 && x1 < y0 && y1 > y0 || y1 > x0 && y1 < y0 && x1 < x0)
			return true;
		return false;
	}
	static class DisjointSet
	{
		int[] p;
		int n;
		int[] rank;
		int[] relate;
		public DisjointSet(int n)
		{
			this.n = n;
			p = new int[n];
			rank = new int[n];
			for (int i = 0; i < n; i++)
				p[i] = i;
			relate = new int[n];
			Arrays.fill(relate, 0);
		}
		public void union(int x, int y)
		{
			int fx = find(x);
			int fy = find(y);
			if (relate[x] == relate[y])
				relate[fy] = 1;
			else
				relate[fy] = 0;
			link(fx, fy);
		}
		private void link(int x, int y)
		{
			p[y] = x;
		}
		public int find(int x)
		{
			int of = p[x];
			if (p[x] != x)
			{
				p[x] = find(p[x]);
				relate[x] = (relate[x] + relate[of]) % 2;
			}
			return p[x];
		}
	}
}