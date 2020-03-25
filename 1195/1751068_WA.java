import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader cin = new BufferedReader(
			new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String s = cin.readLine();
		String[] sa = s.split(" ");
		int n = Integer.parseInt(sa[1]);
		AreaTree at = new AreaTree(0, 0, n - 1, n - 1);
		while (true)
		{
			s = cin.readLine();
			if (s.equals("3"))
				break;
			sa = s.split(" ");
			if (sa.length == 4)
			{
				int x = Integer.parseInt(sa[1]);
				int y = Integer.parseInt(sa[2]);
				int d = Integer.parseInt(sa[3]);
				at.add(x, y, d);
			} else
			{
				int lx = Integer.parseInt(sa[1]);
				int ly = Integer.parseInt(sa[2]);
				int ux = Integer.parseInt(sa[3]);
				int uy = Integer.parseInt(sa[4]);
				int sum = at.get(lx, ly, ux, uy);
				out.println(sum);
			}
		}
		out.flush();
	}
}

class AreaTree
{
	static class Node
	{
		int lx, ly, ux, uy;
		int sum = 0;
		Node clu, clb, cru, crb;

		public Node(int lx, int ly, int ux, int uy)
		{
			this.lx = lx;
			this.ly = ly;
			this.ux = ux;
			this.uy = uy;
		}

		public String toString()
		{
			return "lx="+lx+",ly="+ly+",ux="+ux+",uy="+uy+"  sum="+sum;
		}
	}
	Node root = null;

	public AreaTree(int lx, int ly, int ux, int uy)
	{
		root = new Node(lx, ly, ux, uy);
	}

	public void add(int x, int y, int d)
	{
		add(root, x, y, d);
	}

	private void add(Node cn, int x, int y, int d)
	{
		cn.sum += d;
		if (cn.lx == cn.ux && cn.ly == cn.uy)
		{
			return;
		}
		int mx = (cn.lx + cn.ux) / 2;
		int my = (cn.ly + cn.uy) / 2;
		if (x <= mx && y <= my)
		{
			if (cn.clu == null)
			{
				cn.clu = new Node(cn.lx, cn.ly, mx, my);
			}
			add(cn.clu, x, y, d);
			return;
		}
		if (x >= mx + 1 && x <= cn.ux && y >= cn.ly && y <= my)
		{
			if (cn.cru == null)
				cn.cru = new Node(mx + 1, cn.ly, cn.ux, my);
			add(cn.cru, x, y, d);
			return;
		}
		if (x >= cn.lx && x <= mx && y >= my + 1 && y <= cn.uy)
		{
			if (cn.clb == null)
				cn.clb = new Node(cn.lx, my + 1, mx, cn.uy);
			add(cn.clb, x, y, d);
			return;
		}
		if (x >= mx + 1 && x <= cn.ux && y >= my + 1 && y <= cn.uy)
		{
			if (cn.crb == null)
				cn.crb = new Node(mx + 1, my + 1, cn.ux, cn.uy);
			add(cn.crb, x, y, d);
		}
	}

	public int get(int lx, int ly, int ux, int uy)
	{
		return get(root, lx, ly, ux, uy);
	}

	private int get(Node cn, int lx, int ly, int ux, int uy)
	{
		if (cn.lx == lx && cn.ly == ly && cn.ux == ux && cn.uy == uy)
			return cn.sum;
		int mx = (cn.lx + cn.ux) / 2;
		int my = (cn.ly + cn.uy) / 2;
		int re = 0;
		if (lx <= mx && ly <= my)
		{
			if (cn.clu != null)
				re += get(cn.clu, lx, ly, mx, my);
		}
		if (ux >= mx + 1 && ux <= cn.ux && ly >= cn.ly && ly <= my)
		{
			if (cn.cru != null)
				re += get(cn.cru, mx + 1, ly, ux, my);
		}
		if (lx >= cn.lx && lx <= mx && uy >= my + 1 && uy <= cn.uy)
		{
			if (cn.clb != null)
				re += get(cn.clb, lx, my + 1, mx, uy);
		}
		if (ux >= mx + 1 && uy >= my + 1 && ux <= cn.ux && uy <= cn.uy)
		{
			if (cn.crb != null)
				re += get(cn.crb, mx + 1, my + 1, ux, uy);
		}
		return re;
	}
}