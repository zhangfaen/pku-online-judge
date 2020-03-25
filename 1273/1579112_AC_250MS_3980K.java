import java.io.*;
import java.util.*;
import java.math.*;
public class Main
{
	public static void main(String[] args) throws Exception
	{
		Scanner cin = new Scanner(new BufferedInputStream(System.in));
		while (cin.hasNextInt())
		{
			int n, m;
			n = cin.nextInt();
			m = cin.nextInt();
			int[][] p = new int[m][m];
			for (int i = 0; i < n; i++)
			{
				int x = cin.nextInt() - 1;
				int y = cin.nextInt() - 1;
				p[x][y] += cin.nextInt();
			}
			MaxFlowFast mf = new MaxFlowFast(m, p);
			System.out.println(mf.get(0, m - 1));
		}
	}
}
class MaxFlowFast
{
	private int size;
	private int[][] cap;
	private int[] prev;
	private int BIG=Integer.MAX_VALUE/2;
	/**
	 * size为网络中的点的个数，cap是其邻接矩阵，应该把其理解为有向图，(u,v)边 的权如果为0，表示不存在此边
	 */
	public MaxFlowFast(int size, int[][] cap)
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
		final int [] maxtag=new int[size];
		maxtag[s]=BIG;
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(size+10,new Comparator<Integer>()
			{

				public int compare(Integer d1, Integer d2)
				{
					if(maxtag[d1]<maxtag[d2])
						return 1;
					if(maxtag[d1]>maxtag[d1])
						return -1;
					return d1-d2;
				}});
		
		q.add(s);
		prev[s] = s;
		while (q.size() > 0)
		{
			int cur = q.remove();
			for (int i = 0; i < size; i++)
			{
				if (cap[cur][i] > 0)
				{
					if(i==t)
					{
						prev[i]=cur;
						return true;
					}
					int oldtag=maxtag[i];
					int newtag=Math.min(maxtag[cur], cap[cur][i]);
					if(newtag>oldtag)
					{
						prev[i]=cur;
						boolean ok=q.remove(new Integer(i));
						
						maxtag[i]=newtag;
						q.add(i);
					}
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
