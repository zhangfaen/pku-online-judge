import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main
{
    static class Adapter
    {
	String left, right;

	public Adapter(String left, String right)
	{
	    this.left = left;
	    this.right = right;
	}
	public String toString()
	{
	    return left+" "+right;
	}
    }

    public static void main(String[] args) throws IOException
    {
	BufferedReader cin = new BufferedReader(
		new InputStreamReader(System.in));
	String s = cin.readLine().trim();
	int n = Integer.parseInt(s);
	int size = 0;
	size += n;
	Map<Integer, String> misLeft = new HashMap<Integer, String>();
	for (int i = 0; i < n; i++)
	{
	    s = cin.readLine().trim();
	    misLeft.put(i, s);
	}
	s = cin.readLine().trim();
	int m = Integer.parseInt(s);
	size += m;
	Map<Integer, String> misRight = new HashMap<Integer, String>();
	for (int i = 0; i < m; i++)
	{
	    s = cin.readLine().trim();
	    String[] sa = s.split(" ");
	    misRight.put(i + n, sa[1]);
	}
	s = cin.readLine().trim();
	int k = Integer.parseInt(s);
	Map<Integer, Adapter> misAdapter = new HashMap<Integer, Adapter>();
	size += k;
	for (int i = 0; i < k; i++)
	{
	    s = cin.readLine().trim();
	    String[] sa = s.split(" ");
	    misAdapter.put(i + m + n, new Adapter(sa[1], sa[0]));
	}
	size += 2;
	int[][] map = new int[size][size];
	int INF = Integer.MAX_VALUE / 10;
	for (int i = 0; i < n; i++)
	    for (int j = 0; j < m; j++)
	    {
		if (misLeft.get(i).equals(misRight.get(n + j)))
		    map[i][n + j] = INF;
	    }
	for (int i = 0; i < n; i++)
	    for (int j = 0; j < k; j++)
	    {
		if (misLeft.get(i).equals(misAdapter.get(n + m + j).left))
		    map[i][n + m + j] = INF;
	    }
	for (int i = 0; i < m; i++)
	    for (int j = 0; j < k; j++)
	    {
		if (misRight.get(i + n).equals(misAdapter.get(n + m + j).right))
		    map[n + m + j][i + n] = INF;
	    }
	for (int i = 0; i < k; i++)
	    for (int j = 0; j < k; j++)
		if (misAdapter.get(n + m + i).left.equals(misAdapter.get(n + m
			+ j).right))
		    map[n + m + j][n + m + i] = INF;
	for (Integer key : misLeft.keySet())
	    map[size - 2][key] = 1;
	for (Integer key : misRight.keySet())
	    map[key][size - 1] = 1;
	MaxFlow mf=new MaxFlow(size,map);
	int res=mf.get(size-2, size-1);
	System.out.println(m-res);
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
