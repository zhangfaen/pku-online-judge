import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    
   // static BufferedReader cin;

    public static void main(String[] args) throws IOException
    {
	//cin = new BufferedReader(new InputStreamReader(System.in));
	
	Scanner cin=new Scanner(System.in);
	while (true)
	{
//	    String s = cin.readLine().trim();
//	    if(s.equals("0"))break;
//	    String[] sa = s.split(" ");
//	    int n = Integer.parseInt(sa[0]);
//	    int m = Integer.parseInt(sa[1]);
//	    int k = Integer.parseInt(sa[2]);
	    int n=cin.nextInt();
	    if(n==0)break;
	    int m=cin.nextInt();
	    int k=cin.nextInt();
	    boolean [][] map=new boolean[n][m];
	    for (int i = 0; i < k; i++)
	    {
//		s=cin.readLine().trim();
//		sa=s.split(" ");
//		int x=Integer.parseInt(sa[1]);
//		int y=Integer.parseInt(sa[2]);
		cin.nextInt();
		int x=cin.nextInt();
		int y=cin.nextInt();
		if(x==0||y==0)continue;
		map[x][y]=true;
	    }
	    int re=BiGraph.get(n, m, map);
	    System.out.println(re);
	}
	
    }
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

}
