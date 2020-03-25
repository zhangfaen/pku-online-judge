import java.io.*;
import java.util.*;
import java.math.*;
public class Main
{
	public static void main(String[] args) throws Exception
	{
		Scanner cin = new Scanner(new BufferedInputStream(System.in));
		int n, m;
		n = cin.nextInt();
		m = cin.nextInt();
		int[][] p = new int[m][m];
		for (int i = 0; i < n; i++)
		{
			int x = cin.nextInt() - 1;
			int y = cin.nextInt() - 1;
			p[x][y] = cin.nextInt();
		}
		MaxFlow mf=new MaxFlow(m,p);
		System.out.println(mf.get(0,m-1));
		
	}
}

class MaxFlow
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
	}
	public void init(int size, int[][] cap)
	{
		this.size = size;
		this.cap = cap;
	}
	private boolean augmentable(int s, int t)
	{
		prev = new int[size];
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
	public static void main(String[] args)
	{
		int size = 4;
		int[][] p = new int[4][4];
		p[0][1] = 4;
		p[1][3] = 4;
		p[0][2] = 3;
		p[2][3] = 2;
		p[1][2] = 2;
		MaxFlow mf = new MaxFlow(size, p);
		System.out.println(mf.get(0, 3));
	}
}