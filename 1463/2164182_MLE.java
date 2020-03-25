import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    static List[] map;
    static int n;
    static int[][] memo;

    public static void main(String[] args) throws IOException
    {
	BufferedReader cin = new BufferedReader(
		new InputStreamReader(System.in));
	StringBuilder sb = new StringBuilder(10000);
	while (true)
	{
	    String s = cin.readLine();
	    if (s == null)
		break;
	    sb.append(s);
	    sb.append(" ");
	}
	Scanner sin = new Scanner(sb.toString().replaceAll("(:)|(\\()|(\\))",
		" "));
	while (sin.hasNextInt())
	{

	    n = sin.nextInt();
	    map = new ArrayList[n];
	    for (int i = 0; i < n; i++)
		map[i] = new ArrayList(11);
	    for (int i = 0; i < n; i++)
	    {

		int src = sin.nextInt();
		int end = sin.nextInt();
		for (int j = 0; j < end; j++)
		{
		    int to = sin.nextInt();
		    map[src].add(to);
		    map[to].add(src);
		}
	    }
	    try
	    {
		removeSomeEndge(0);
	    }
	    catch (Exception e)
	    {
	    }
	    memo = new int[n][2];
	    for (int i = 0; i < n; i++)
		memo[i][0] = memo[i][1] = -1;
	    int res = 0;
	    try
	    {
		int d1 = dp(0, 0);
		int d2 = dp(0, 1);
		res = Math.min(d1, d2);
	    }
	    catch (Exception e)
	    {
	    }
	    System.out.println(res);
	    System.gc();
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

    public static int dp(int cn, int tag)
    {
	if (map[cn].size() == 0)
	{
	    if (tag == 0)
		return 0;
	    return 1;
	}
	if (memo[cn][tag] != -1)
	    return memo[cn][tag];
	int re = 0;
	int cnsize = map[cn].size();
	int end = (1 << cnsize);
	if (tag == 1)
	{
	    re = 1;
	    int tmin = Integer.MAX_VALUE;
	    for (int s = 0; s < end; s++)
	    {
		int d = 0;
		for (int i = 0; i < cnsize; i++)
		{
		    if (((1 << i) & s) != 0)
		    {
			d += dp((Integer) map[cn].get(i), 1);
		    }
		    else
		    {
			d += dp((Integer) map[cn].get(i), 0);
		    }
		}
		tmin = Math.min(tmin, d);
	    }
	    re += tmin;
	}
	else
	{
	    int tmin = Integer.MAX_VALUE;
	    for (int k = 0; k < cnsize; k++)
	    {
		for (int s = 0; s < end; s++)
		{
		    if (((1 << k) & s) == 0)
			continue;
		    int d = 0;
		    for (int i = 0; i < cnsize; i++)
		    {
			if (((1 << i) & s) != 0)
			{
			    d += dp((Integer) map[cn].get(i), 1);
			}
			else
			{
			    d += dp((Integer) map[cn].get(i), 0);
			}
		    }
		    tmin = Math.min(tmin, d);
		}
	    }
	    re = tmin;
	}
	memo[cn][tag] = re;
	return re;
    }

}