import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main
{
    static BufferedReader cin = new BufferedReader(new InputStreamReader(
	    System.in));
    static PrintWriter out = new PrintWriter(System.out);
    static int INF = Integer.MAX_VALUE / 2;

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
	    for (int j = 0; j < maxt; j++)
		for (int k = 0; k < maxt; k++)
		{
		    memo2[j][k] = INF;
		    // memo2[j][0]=0;
		    memo1[j][k] = INF;
		}
	    memo2[0][0] = 0;
	    int d1, d2, d3;
	    for (int i = n - 1; i > 0; i--)
	    {
		// System.out.println();
		for (int j = 0; j <= maxt - sum[i - 1]; j++)
		{
		    for (int k = 0; k <= maxt - sum[i - 1]; k++)
		    {
			if (j + k > maxt - sum[i - 1])
			    break;
			memo1[j][k] = memo2[j][k];
			if (j >= ts[i])
			{
			    d1 = memo1[j][k];
			    d2 = memo2[j - ts[i]][k];
			    memo1[j][k] = d1 < d2 ? d1 : d2;
			}
			if (k >= ts[i])
			{
			    d1 = memo1[j][k];
			    d2 = memo2[j][k - ts[i]];
			    d3 = hs[i];
			    d2 = d2 > d3 ? d2 : d3;
			    memo1[j][k] = d1 < d2 ? d1 : d2;
			}
			if (j > 0 && k > 0 && memo1[j][k] != INF
				&& memo1[j][k] != 0)
			{
			    d1 = j > k ? j : k;
			    d1 = d1 > maxt - j - k ? d1 : maxt - j - k;
			    d2 = d1 * (hs[i] + memo1[j][k] + hs[0]);
			    res = res > d2 ? d2 : res;
			}
		    }
		}
		int[][] t = memo2;
		memo2 = memo1;
		memo1 = t;
	    }
	    out.println(res);
	}
	out.flush();
	out.close();
    }

    public static int mymax(int a, int b, int c)
    {
	return Math.max(a, Math.max(b, c));
    }
}
