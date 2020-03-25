import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Main
{
    static class BiGraph
    {
	static int m, n;
	static boolean[][] map;
	static int[] match1;
	static int[] match2;

	public static int get(int tm, int tn, boolean[][] tmap)
	{
	    m = tm;
	    n = tn;
	    map = tmap;
	    match1 = new int[m];
	    match2 = new int[n];
	    Arrays.fill(match1, -1);
	    Arrays.fill(match2, -1);
	    int re = 0;
	    for (int i = 0; i < m; i++)
		re += find(i);
	    return re;
	}

	private static int find(int s)
	{
	    int[] back = new int[n];
	    Arrays.fill(back, -1);
	    List<Integer> q = new LinkedList<Integer>();
	    q.add(s);
	    while (q.size() > 0)
	    {
		int cur = q.remove(0);
		for (int i = 0; i < n; i++)
		{
		    if (map[cur][i] && back[i] == -1)
		    {
			if (match2[i] >= 0)
			{
			    back[i] = cur;
			    q.add(match2[i]);
			}
			else
			{
			    while (true)
			    {
				int ni = match1[cur];
				match1[cur] = i;
				match2[i] = cur;
				if (ni == -1)
				    break;
				cur = back[ni];
				i = ni;

			    }
			    return 1;
			}
		    }
		}
	    }
	    return 0;
	}
    }
    static BufferedReader cin;

    public static void main(String[] args) throws IOException
    {
	cin = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);

	while (true)
	{
	    String s = cin.readLine().trim();
	    String[] sa = s.split(" ");
	    int n = Integer.parseInt(sa[0]);
	    if (n == 0)
		break;
	    int m = Integer.parseInt(sa[1]);
	    int k = Integer.parseInt(sa[2]);
	    boolean [][] map=new boolean[n][m];
	    for (int i = 0; i < k; i++)
	    {
		s=cin.readLine().trim();
		sa=s.split(" ");
		int x=Integer.parseInt(sa[1]);
		int y=Integer.parseInt(sa[2]);
		if(x==0||y==0)continue;
		if(x==n)x--;if(y==m)y--;
		map[x][y]=true;
	    }
	    int re=BiGraph.get(n, m, map);
	    System.out.println(re);
	}
	out.close();
    }

}
