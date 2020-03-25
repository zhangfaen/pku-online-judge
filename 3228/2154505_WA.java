import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main
{

    static BufferedReader cin;
    static class E implements Comparable<E>
    {
	int x, y, len;

	public int compareTo(E o)
	{
	    return len - o.len;
	}

	public E(int x, int y, int len)
	{
	    this.x = x;
	    this.y = y;
	    this.len = len;
	}
    }

    public static void main(String[] args) throws IOException
    {
	cin = new BufferedReader(new InputStreamReader(System.in));
	while (true)
	{
	    String s = cin.readLine();
	    int n = Integer.parseInt(s);
	    if (n == 0)
		break;
	    int[] supply = new int[n];
	    int[] demand = new int[n];
	    s = cin.readLine();
	    String[] sa = s.split(" ");
	    for (int i = 0; i < n; i++)
		supply[i] = Integer.parseInt(sa[i]);
	    s = cin.readLine();
	    sa = s.split(" ");
	    for (int i = 0; i < n; i++)
		demand[i] = Integer.parseInt(sa[i]);
	    for (int i = 0; i < n; i++)
		if (demand[i] >= supply[i])
		{
		    demand[i] -= supply[i];
		    supply[i] = 0;
		}
		else
		{
		    supply[i] -= demand[i];
		    demand[i] = 0;
		}
	    int totalSupply = 0;
	    for (int d : supply)
		totalSupply += d;
	    int totalDemand=0;
	    for(int d:demand)
		totalDemand+=d;
	    s = cin.readLine();
	    
	    if(totalDemand<totalSupply)
	    {
		System.out.println("No Solution");
		continue;
	    }
	    int m = Integer.parseInt(s);
	    E[] es = new E[m];
	    
	    for (int i = 0; i < m; i++)
	    {
		sa = cin.readLine().split(" ");
		int len = Integer.parseInt(sa[2]);
		es[i] = new E(Integer.parseInt(sa[0]) - 1, Integer
			.parseInt(sa[1]) - 1, len);
	    }
	    Arrays.sort(es);
	    if(check(supply,demand,n,es,n-1,totalSupply)==false)
	    {
		System.out.println("No Solution");
		continue;
	    }
	    int left = 0, right = es.length - 1;
	    int res=Integer.MAX_VALUE;
	    while(left<right)
	    {
		int mid=(left+right)/2;
		if(check(supply,demand,n,es,mid,totalSupply))
		{
		    right=mid;
		}
		else
		{
		    left=mid+1;
		}
	    }
	    res=es[right].len;
	    System.out.println(res);
	}
    }

    public static boolean check(int[] supply, int[] demand, int n, E[] es,
	    int end, int sum)
    {
	int size = n + 2;
	int[][] cap = new int[size][size];
	for (int i = 0; i <= end; i++)
	{
	    int x = es[i].x, y = es[i].y;
	    cap[x][y] = cap[y][x] = Integer.MAX_VALUE / 10;
	}
	for (int i = 0; i < n; i++)
	{
	    cap[n][i] = supply[i];
	    cap[i][n + 1] = demand[i];
	}
	MaxFlow mf = new MaxFlow(size, cap);
	int re = mf.get(n, n + 1);
	if (re == sum)
	    return true;
	return false;
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
	    this.prev = new int[size];
	}

	public void init(int size, int[][] cap)
	{
	    this.size = size;
	    this.cap = cap;
	    this.prev = new int[size];
	}

	private boolean augmentable(int s, int t)
	{
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
			}
			else
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
