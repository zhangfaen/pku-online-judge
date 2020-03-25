import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main
{

    static BufferedReader cin = new BufferedReader(new InputStreamReader(
	    System.in));
    static class Mt
    {
	int x, y;

	public Mt(int x, int y)
	{
	    this.x = x;
	    this.y = y;
	}
    }

    public static boolean kill(Mt mt1, Mt mt2)
    {
	if (mt2.x > mt1.y || mt1.x > mt2.y)
	    return false;
	return true;
    }

    public static void main(String[] args) throws IOException
    {
	String s = cin.readLine().trim();
	int ts = Integer.parseInt(s);
	while (ts-- > 0)
	{
	    s = cin.readLine().trim();
	    int n = Integer.parseInt(s);
	    Mt[] mts = new Mt[n];
	    for (int i = 0; i < n; i++)
	    {
		s = cin.readLine().trim();
		String[] sa = s.split(" ");
		int a = Integer.parseInt(sa[0]);
		int b = Integer.parseInt(sa[1]);
		int x = Math.min(a, b);
		int y = Math.max(a, b);
		mts[i] = new Mt(x, y);
	    }
	    List[] map=new ArrayList[n];
	    for(int i=0;i<n;i++)
		map[i]=new ArrayList<Integer>();
	    for(int i=0;i<n;i++)
		for(int j=0;j<n;j++)
		{
		    if(kill(mts[i],mts[j]))
		    {
			map[i].add(j);
			map[j].add(i);
		    }
		}
	    StrongConnectedComponent scc=new StrongConnectedComponent(map);
	    int [] ids=scc.getIdOfAllPoints();
	    int [] cnt=new int[n];
	    for(int d:ids)
		cnt[d]++;
	    int res=0;
	    for(int d:cnt)
		res=Math.max(res, d);
	    System.out.println(res*10);
	}

    }
    static class StrongConnectedComponent
    {
	List[] mapa;
	List[] mapt;
	int[] order;
	int tag;
	boolean[] vst;
	int[] id;
	int n;
	int numberOfSCC;

	/**
         * 
         * @param mapa
         *                原图
         * 
         */
	public StrongConnectedComponent(List[] mapa)
	{
	    this.mapa = mapa;
	    n = mapa.length;
	    this.mapt = new ArrayList[n];
	    for (int i = 0; i < n; i++)
	    {
		mapt[i] = new ArrayList();
	    }
	    /**
                 * 构建原图的逆图
                 */
	    for (int i = 0; i < n; i++)
	    {
		List ll = mapa[i];
		for (int j = 0; j < ll.size(); j++)
		{
		    mapt[(Integer) ll.get(j)].add(i);
		}
	    }
	    calc();
	}

	/**
         * 得到强连通分支数
         * 
         * @return
         */
	public int getNumberOfSCC()
	{
	    return numberOfSCC;
	}

	/**
         * 得到原图当中每个点所属的强联通分支id
         * 
         * @return
         */
	public int[] getIdOfAllPoints()
	{
	    return id;
	}

	private void calc()
	{
	    order = new int[n];
	    tag = 0;
	    vst = new boolean[n];
	    for (int i = 0; i < n; i++)
		if (vst[i] == false)
		{
		    vst[i] = true;
		    dfsa(i);
		}
	    id = new int[n];
	    tag = 0;
	    Arrays.fill(vst, false);
	    for (int i = n - 1; i >= 0; i--)
	    {
		if (vst[order[i]] == false)
		{
		    vst[order[i]] = true;
		    dfst(order[i]);
		    tag++;
		}
	    }
	    numberOfSCC = tag;
	}

	private void dfsa(int ci)
	{
	    for (int i = 0; i < mapa[ci].size(); i++)
	    {
		int next = (Integer) mapa[ci].get(i);
		if (vst[next] == false)
		{
		    vst[next] = true;
		    dfsa(next);
		}
	    }
	    order[tag++] = ci;
	}

	private void dfst(int ci)
	{
	    id[ci] = tag;
	    for (int i = 0; i < mapt[ci].size(); i++)
	    {
		int next = (Integer) mapt[ci].get(i);
		if (vst[next] == false)
		{
		    vst[next] = true;
		    dfst(next);
		}
	    }
	}
    }
}
