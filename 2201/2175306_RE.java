import java.io.*;
import java.util.*;
import java.math.*;

public class Main
{
	static class RMQ
	{
		int[] p;
		int n;
		int[][] M;

		public RMQ(int[] p)
		{
			this.p = p;
			this.n = p.length;
			M = new int[n][(int) (Math.log(n) / Math.log(2)) + 10];
			init();
		}

		private void init()
		{
			for (int i = 0; i < n; i++)
				M[i][0] = i;
			for (int j = 1; 1 << j <= n; j++)
				for (int i = 0; i + (1 << j) - 1 < n; i++)
				{
					if (p[M[i][j - 1]] < p[M[i + (1 << (j - 1))][j - 1]])
					{
						M[i][j] = M[i][j - 1];
					} else
					{
						M[i][j] = M[i + (1 << (j - 1))][j - 1];
					}
				}
		}

		public int query(int i, int j)
		{
			int k = (int) (Math.log(j - i + 1) / Math.log(2));
			if (p[M[i][k]] <= p[M[j - (1 << k) + 1][k]])
				return M[i][k];
			else
				return M[j - (1 << k) + 1][k];
		}
	}
	static BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter out = new PrintWriter(System.out);
	static class Node
	{
		int kx, ax;
		int index;
		int cl = -1, cr = -1, cf = -1;

		public Node(int a, int b, int index)
		{
			kx = a;
			ax = b;
			this.index=index;
		}
	}
	static Node[] korder;
	static Node[] src;
	static int[] ks;
	static int[] as;

	public static void main(String[] args) throws IOException
	{
		String s = cin.readLine();
		int n = Integer.parseInt(s);
		korder = new Node[n];
		src = new Node[n];
		for (int i = 0; i < n; i++)
		{
			s = cin.readLine();
			String[] sa = s.split(" ");
			Node node = new Node(Integer.parseInt(sa[0]), Integer.parseInt(sa[1]), i);
			korder[i] = node;
			src[i] = node;
		}
		Arrays.sort(korder, new Comparator<Node>()
		{
			public int compare(Node o1, Node o2)
			{
				return o1.kx - o2.kx;
			}
		});
		as = new int[n];
		for (int i = 0; i < n; i++)
		{
			as[i] = korder[i].ax;
		}
		rmq = new RMQ(as);
		make(0, n - 1);
		out.println("YES");
		for (int i = 0; i < n; i++)
		{
			int a, b, c;
			if (src[i].cf == -1)
				a = 0;
			else
				a = src[i].cf+1;
			if (src[i].cl == -1)
				b = 0;
			else
				b = src[i].cl+1;
			if (src[i].cr == -1)
				c = 0;
			else
				c = src[i].cr+1;
			out.println(a + " " + b + " " + c);
		}
		out.flush();
	}
	static RMQ rmq;

	static int make(int left, int right)
	{
		if (left == right)
		{
			return left;
		}
		int mi = rmq.query(left, right);
		if (mi > left)
		{
			int lf = make(left, mi - 1);
			korder[mi].cl = korder[lf].index;
			korder[lf].cf = korder[mi].index;
		}
		if (mi < right)
		{
			int rf = make(mi + 1, right);
			korder[mi].cr = korder[rf].index;
			korder[rf].cf = korder[mi].index;
		}
		return mi;
	}
}