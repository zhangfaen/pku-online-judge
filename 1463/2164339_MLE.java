import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main
{
    static List[] map;
    static int n;
//    static List<Integer> q = new LinkedList<Integer>();
//
//    static int nextInt() throws IOException
//    {
//	int re = 0;
//	if (q.isEmpty() == false)
//	{
//	    re = q.remove(0);
//	}
//	else
//	{
//	    while (q.isEmpty())
//	    {
//		String s = null;
//		s = cin.readLine();
//		if (s == null)
//		{
//		    return -1;
//		}
//		s = s.trim();
//		s = s.replaceAll("[^\\d]", " ").trim();
//		String[] sa = s.split(" +");
//		for (int i = 0; i < sa.length; i++)
//		    if (sa[i].length() > 0)
//			q.add(Integer.parseInt(sa[i]));
//	    }
//	    re = q.remove(0);
//	}
//	return re;
//    }
//    static BufferedReader cin = new BufferedReader(new InputStreamReader(
//	    System.in));
    static int[] cover = new int[1501];
    static int[] parent = new int[1501];
    static int tag = 0;

    public static void main(String[] args) throws IOException
    {
	Scanner sin = new Scanner(System.in);
	while (sin.hasNextInt())
	{
	    Arrays.fill(cover,0);
	    Arrays.fill(parent, 0);
	    n = sin.nextInt();
	    map = new ArrayList[n];
	    for (int i = 0; i < n; i++)
		map[i] = new ArrayList();
	    for (int i = 0; i < n; i++)
	    {
		String s = sin.next();
		s = s.replaceAll("[^\\d]", " ").trim();
		String[] sa = s.split(" +");
		int src = Integer.parseInt(sa[0]);
		int end = Integer.parseInt(sa[1]);
		for (int j = 0; j < end; j++)
		{
		    int to = sin.nextInt();
		    map[src].add(to);
		    map[to].add(src);
		}
	    }
	    tag = 0;
	    dfs(-1, 0, 0);
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
	}
    }

    public static void dfs(int pre, int cn, int cf)
    {
	parent[tag] = cf;
	int nnf = tag++;
	for (int i = 0; i < map[cn].size(); i++)
	{
	    int to = (Integer) map[cn].get(i);
	    if (to == pre)
		continue;
	    dfs(cn, to, nnf);
	}
    }
}
