import java.io.*;
import java.util.*;
import java.math.*;

public class Main
{
	boolean[][] memo;
	int tar;

	public static void main(String[] args) throws Exception
	{
		BufferedReader cin = new BufferedReader(
			new InputStreamReader(System.in));
		while (true)
		{
			String ts = cin.readLine();
			if (ts == null)
				return;
			int n = Integer.parseInt(ts);
			int minx, miny, maxx, maxy;
			ts = cin.readLine();
			String[] tsa = ts.split(" ");
			minx = Integer.parseInt(tsa[0]);
			miny = Integer.parseInt(tsa[1]);
			maxx = Integer.parseInt(tsa[2]);
			maxy = Integer.parseInt(tsa[3]);
			int lx, ly, lh;
			ts = cin.readLine();
			tsa = ts.split(" ");
			lx = Integer.parseInt(tsa[0]);
			ly = Integer.parseInt(tsa[1]);
			lh = Integer.parseInt(tsa[2]);
			int dx = lx, dy = ly;
			lx = ly = 0;
			minx -= dx;
			maxx -= dx;
			miny -= dy;
			maxy -= dy;
			double[] lxs = new double[n];
			double[] lys = new double[n];
			double[] rxs = new double[n];
			double[] rys = new double[n];
			for (int i = 0; i < n; i++)
			{
				ts = cin.readLine();
				tsa = ts.split(" ");
				int h = Integer.parseInt(tsa[4]);
				lxs[i] = (Integer.parseInt(tsa[0]) - dx) * lh * 1.0 / (lh - h);
				lys[i] = (Integer.parseInt(tsa[1]) - dy) * lh * 1.0 / (lh - h);
				rxs[i] = (Integer.parseInt(tsa[2]) - dx) * lh * 1.0 / (lh - h);
				rys[i] = (Integer.parseInt(tsa[3]) - dy) * lh * 1.0 / (lh - h);
				lxs[i] = Math.max(minx, lxs[i]);
				lys[i] = Math.max(lys[i], miny);
				rxs[i] = Math.min(rxs[i], maxx);
				rys[i] = Math.min(rys[i], maxy);
			}
			double area=get(lxs,lys,rxs,rys);
			System.out.println(area);
		}
	}

	public static double get(double[] lxs, double[] lys, double[] rxs,
		double[] rys)
	{
		int n = lxs.length;
		double[] xs = new double[2 * n];
		double[] ys = new double[2 * n];
		for (int i = 0; i < n; i++)
		{
			xs[i] = lxs[i];
			xs[n + i] = rxs[i];
			ys[i] = lys[i];
			ys[n + i] = rys[i];
		}
		Arrays.sort(xs);
		Arrays.sort(ys);
		Main.ys=ys;
		double area=0;
		for (int i = 0; i < 2 * n; i++)
		{
			for(int j=0;j<n;j++)
			{
				if(xs[i]==lxs[j])
				{
					int low=Arrays.binarySearch(ys, lys[j]);
					int up=Arrays.binarySearch(ys, rys[j]);
					add(1,2*n-1,1,low,up);
				}
				if(xs[i]==rxs[j])
				{
					int low=Arrays.binarySearch(ys, lys[j]);
					int up=Arrays.binarySearch(ys, rys[j]);
					double hight=totalLen(1,2*n-1,1);
					area+=hight*(xs[i]-xs[i-1]);
					del(1,2*n-1,1,low,up);
				}
			}
		}
		return area;
	}
	static int[] tree = new int[10000];
	static double [] ys;
	public static void add(int left, int right, int node, int x, int y)
	{
		if (left == x && right == y || right - left == 1)
		{
			tree[node]++;
			return;
		}
		int mid = (right + left) / 2;
		if (y <= mid)
			add(left, mid, node * 2, x, y);
		else if (x >= mid)
			add(mid, right, node * 2 + 1, x, y);
		else
		{
			add(left,mid,node*2,x,mid);
			add(mid,right,node*2+1,mid,y);
		}
	}
	public static void del(int left,int right,int node,int x,int y)
	{
		if (left == x && right == y || right - left == 1)
		{
			tree[node]--;
			return;
		}
		int mid = (right + left) / 2;
		if (y <= mid)
			del(left, mid, node * 2, x, y);
		else if (x >= mid)
			del(mid, right, node * 2 + 1, x, y);
		else
		{
			del(left,mid,node*2,x,mid);
			del(mid,right,node*2+1,mid,y);
		}
	}
	public static double totalLen(int left,int right,int node)
	{
		if(tree[node]>0)
			return ys[right]-ys[left];
		if(right-left==1)
			return 0;
		int mid=(right+left)/2;
		double re=0;
		re+=totalLen(left,mid,node*2)+totalLen(mid,right,node*2+1);
		return re;
	}
}
