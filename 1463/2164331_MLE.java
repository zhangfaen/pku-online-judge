import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main
{
    static List[] map;
    static int n;
    static List<Integer> q = new LinkedList<Integer>();

    static int nextInt() throws IOException
    {
	int re = 0;
	if (q.isEmpty() == false)
	{
	    re = q.remove(0);
	}
	else
	{
	    while (q.isEmpty())
	    {
		String s = null;
		s = cin.readLine();
		if (s == null)
		{
		    return -1;
		}
		s = s.trim();
		s = s.replaceAll("[^\\d]", " ").trim();
		String[] sa = s.split(" +");
		for (int i = 0; i < sa.length; i++)
		    if (sa[i].length() > 0)
			q.add(Integer.parseInt(sa[i]));
	    }
	    re = q.remove(0);
	}
	return re;
    }
    static BufferedReader cin = new BufferedReader(new InputStreamReader(
	    System.in));
    static int[] cover = new int[1501];
    static int[] parent = new int[1501];
    static int tag = 0;
    public static void main(String[] args) throws IOException
    {
	while (true)
	{
	    n = nextInt();
	    if (n == -1)
		break;
	    Arrays.fill(cover,0);
	    Arrays.fill(parent,0);
	    map = new ArrayList[n];
	    for (int i = 0; i < n; i++)
		map[i] = new ArrayList();
	    for (int i = 0; i < n; i++)
	    {
		int src = nextInt();
		int end = nextInt();
		for (int j = 0; j < end; j++)
		{
		    int to = nextInt();
		    map[src].add(to);
		    map[to].add(src);
		}
	    }
	    removeSomeEndge(0);
	    tag = 0;
	    dfs(0,0);
	    int res = 0;
	    for (int i = n - 1; i >= 1; i--)
	    {
		if (cover[i] == 0 && cover[parent[i]] == 0)
		{
		    res++;
		    cover[parent[i]] = 1;
		}
	    }

	    System.out.println(res);
	    // System.gc();
	}
    }

    public static void dfs(int cn,int cf)
    {
	parent[tag]=cf;
	int nnf=tag++;
	for (int i = 0; i < map[cn].size(); i++)
	{
	    int to = (Integer) map[cn].get(i);
	    dfs(to,nnf);
	}
    }

    public static void removeSomeEndge(int cur)
    {
	if (map[cur].size() > 0)
	{
	    for (int i = 0; i < map[cur].size(); i++)
	    {
		Integer to = (Integer) map[cur].get(i);
		map[to].remove((Object) (Integer.valueOf(cur)));
	    }
	    for (int i = 0; i < map[cur].size(); i++)
	    {
		Integer to = (Integer) map[cur].get(i);
		removeSomeEndge(to);
	    }
	}
    }

}
