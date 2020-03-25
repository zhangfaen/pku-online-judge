import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String s = cin.readLine();
		int n = Integer.parseInt(s);
		DisjointSet ds = new DisjointSet(30001);
		while (n-- > 0)
		{
			s = cin.readLine();
			String[] sa = s.split(" ");
			if (sa[0].equals("M"))
			{
				int a = Integer.parseInt(sa[1]);
				int b = Integer.parseInt(sa[2]);
				ds.union(a, b);
			} else
			{
				int c = Integer.parseInt(sa[1]);
				ds.find(c);
				out.println(ds.count(c));
			}
		}
		out.flush();
	}
	static class DisjointSet
	{
		int[] p;
		int n;
		int[] rank;
		int[] num;
		int[] up;
		public DisjointSet(int n)
		{
			this.n = n;
			p = new int[n];
			rank = new int[n];
			for (int i = 0; i < n; i++)
				p[i] = i;
			num = new int[n];
			up = new int[n];
			Arrays.fill(num, 1);
		}
		public void union(int x, int y)
		{
			int fx = find(x);
			int fy = find(y);
			up[fy] = num[fx];
			link(fx, fy);
		}
		private void link(int x, int y)
		{
			num[x] += num[y];
			p[y] = x;
		}
		public int find(int x)
		{
			if (p[x] != x)
			{
				up[x] = getup(x);
				p[x] = find(p[x]);
			}
			return p[x];
		}
		public int getup(int x)
		{
			int re = 0;
			re+=up[x];
			while (x != p[x])
			{
				re += up[p[x]];
				x = p[x];
			}
			return re;
		}
		public int count(int x)
		{
			int fx = find(x);
			return num[fx] - up[x] - 1;
		}
	}
}
