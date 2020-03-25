import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Main
{

    static BufferedReader cin = new BufferedReader(new InputStreamReader(
	    System.in));
    static int m, n;
    static List<Integer> mx = new ArrayList<Integer>();
    static List<Integer> my = new ArrayList<Integer>();
    static List<Integer> hx = new ArrayList<Integer>();
    static List<Integer> hy = new ArrayList<Integer>();

    public static void main(String[] args) throws IOException
    {
	while (true)
	{
	    String s = cin.readLine();
	    String[] sa = s.split(" ");
	    m = Integer.parseInt(sa[0]);
	    n = Integer.parseInt(sa[1]);
	    if (m + n == 0)
		break;
	    mx.clear();
	    my.clear();
	    hx.clear();
	    hy.clear();
	    int total = 0;
	    for (int i = 0; i < m; i++)
	    {
		s = cin.readLine();
		for (int j = 0; j < n; j++)
		{
		    char c = s.charAt(j);
		    if (c == 'm')
		    {
			total++;
			mx.add(i);
			my.add(j);
		    }
		    else if (c == 'H')
		    {
			hx.add(i);
			hy.add(j);
		    }
		}
	    }
	    int[][] cap=new int[total*2+2][total*2+2];
	    int[][] cost=new int[total*2+2][total*2+2];
	    for(int i=0;i<total;i++)
		for(int j=0;j<total;j++)
		{
		    cap[i][j+total]=1;
		    cost[i][j+total]=Math.abs(mx.get(i)-hx.get(j))+Math.abs(my.get(i)-hy.get(j));
		}
	    for(int i=0;i<total;i++)
	    {
		cap[2*total][i]=1;
		cap[total+i][2*total+1]=1;
	    }
	    MinimumCostFlow  mcf=new MinimumCostFlow(cap,cost);
	    int re=mcf.get(2*total, 2*total+1);
	    System.out.println(re);
	}
    }
    static class MinimumCostFlow
{

    private int[][] cap;
    private int[][] cost;
    private int n;
    private int[] back;
    private int []best;
    public MinimumCostFlow(int[][] cap, int[][] cost)
    {
	this.cap = cap;
	this.cost = cost;
	this.n = cap.length;
	init();
	back = new int[n];
	best=new int[n];
    }

    private void init()
    {
	for (int i = 0; i < n; i++)
	    for (int j = 0; j < n; j++)
		if (cap[i][j] > 0)
		    cost[j][i] = -cost[i][j];
    }

    public int get(int src, int dest)
    {
	int re = 0;
	while (true)
	{
	    AugRe ar = aug(src, dest);
	    if (ar == null)
		break;
	    re += ar.minCost;
	}
	return re;
    }

    private AugRe aug(int src, int dest)
    {
	Arrays.fill(back, -1);
	back[src] = src;
	Arrays.fill(best, Integer.MAX_VALUE);
	best[src] = 0;
	LinkedList<Integer> q = new LinkedList<Integer>();
	q.add(src);
	while (!q.isEmpty())
	{
	    int cur = q.remove(0);
	    int cb = best[cur];
	    for (int i = 0; i < n; i++)
		if (cap[cur][i] > 0)
		{
		    if (cb + cost[cur][i] < best[i])
		    {
			best[i] = cb + cost[cur][i];
			back[i] = cur;
			q.add(i);
		    }
		}
	}
	if (best[dest] == Integer.MAX_VALUE)
	    return null;
	int minCap = Integer.MAX_VALUE;
	int cur = dest;
	while (back[cur] != cur)
	{
	    minCap = Math.min(cap[back[cur]][cur], minCap);
	    cur = back[cur];
	}
	cur = dest;
	while (back[cur] != cur)
	{
	    cap[back[cur]][cur] -= minCap;
	    cap[cur][back[cur]] += minCap;
	    cur = back[cur];
	}
	AugRe augre = new AugRe(best[dest] * minCap, minCap);
	return augre;
    }
    private static class AugRe
    {
	int minCost, minCap;

	public AugRe(int minCost, int minCap)
	{
	    this.minCost = minCost;
	    this.minCap = minCap;
	}
    }

}

}
