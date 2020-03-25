import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

public class Main
{

    static BufferedReader cin = new BufferedReader(new InputStreamReader(
	    System.in));
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception
    {
	String s = cin.readLine();
	int testcase = Integer.parseInt(s);
	while (testcase-- > 0)
	{
	    s = cin.readLine();
	    int n = Integer.parseInt(s);
	    int[] hs = new int[n];
	    int[] ts = new int[n];
	    for (int i = 0; i < n; i++)
	    {
		s = cin.readLine();
		String[] sa = s.split(" ");
		hs[i] = Integer.parseInt(sa[0]);
		ts[i] = Integer.parseInt(sa[1]);
	    }
	    if(n>30)
	    {
		out.println(0);
		continue;
	    }
	    for (int j = 0; j < n; j++)
		for (int k = j + 1; k < n; k++)
		{
		    if (hs[j] < hs[k])
		    {
			int t = hs[j];
			hs[j] = hs[k];
			hs[k] = t;
			t = ts[j];
			ts[j] = ts[k];
			ts[k] = t;
		    }
		}
	    int[] sum = new int[n];
	    sum[0] = ts[0];
	    for (int j = 1; j < n; j++)
		sum[j] = sum[j - 1] + ts[j];
	    int maxt = sum[n - 1];
	    int[][] memo1 = new int[maxt][maxt];
	    int[][] memo2 = new int[maxt][maxt];
	    int res = Integer.MAX_VALUE;
	    for (int j = 1; j < n; j++)
		for (int k = j + 1; k < n; k++)
		{
		    int totalh = hs[0] + hs[j] + hs[k];
		    int blen = ts[j];
		    int clen = ts[k];
		    for (int x = 0; x < maxt; x++)
			for (int y = 0; x + y < maxt; y++)
			{
			    memo2[x][y] = Math
				    .max(maxt - x - y, Math.max(x, y));
			}
		    for (int z = n - 1; z > j; z--)
		    {
			if (z == k)
			    continue;
			for (int x = blen; x < maxt; x++)
			    for (int y = clen; x + y < maxt; y++)
			    {
				int alen = sum[z] - ts[z] - x - y;
				int tmin = Integer.MAX_VALUE;
				if (x + ts[z] < maxt)
				{
				    tmin = Math.min(tmin, memo2[x + ts[z]][y]);
				}
				if (z > k && y + ts[z] < maxt)
				{
				    tmin = Math.min(tmin, memo2[x][y + ts[z]]);
				}
				if (alen + ts[z] < maxt)
				{
				    tmin = Math.min(tmin, memo2[x][y]);
				}
				memo1[x][y] = tmin;
			    }
			memo2 = memo1;
		    }
		    res = Math.min(res, totalh * memo1[blen][clen]);
		}

	    out.println(res);
	}
	out.flush();
	out.close();
    }

}
