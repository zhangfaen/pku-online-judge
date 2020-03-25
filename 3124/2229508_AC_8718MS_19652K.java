import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main
{
    static BufferedReader cin = new BufferedReader(new InputStreamReader(
	    System.in));
    static PrintWriter out = new PrintWriter(System.out);
    static char INF = Character.MAX_VALUE / 2;
    static char[][] memo1 = new char[2101][2101];
    static char[][] memo2 = new char[2101][2101];

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
	    int res = Integer.MAX_VALUE;
	    for (int j = 0; j < maxt; j++)
		for (int k = 0; k < maxt; k++)
		{
		    memo2[j][k] = INF;
		    memo1[j][k] = INF;
		}
	    memo2[0][0] = 0;
	    int d1, d2, d3;
	    for (int i = n - 1; i > 0; i--)
	    {
		for (int j = 0; j <= maxt - sum[i - 1]; j++)
		{
		    for (int k = 0; j + k <= maxt - sum[i - 1]; k++)
		    {
			memo1[j][k] = memo2[j][k];
			if (j >= ts[i])
			{
			    d1 = memo1[j][k];
			    d2 = memo2[j - ts[i]][k];
			    memo1[j][k] = (char) (d1 < d2 ? d1 : d2);
			}
			if (k >= ts[i])
			{
			    d1 = memo1[j][k];
			    d2 = memo2[j][k - ts[i]];
			    d3 = hs[i];
			    d2 = d2 > d3 ? d2 : d3;
			    memo1[j][k] = (char) (d1 < d2 ? d1 : d2);
			}
			if (memo1[j][k] != INF && memo1[j][k] != 0)
			{
			    d1 = j > k ? j : k;
			    d1 = d1 > maxt - j - k ? d1 : maxt - j - k;
			    d2 = d1 * (hs[i] + memo1[j][k] + hs[0]);
			    res = res > d2 ? d2 : res;
			}
		    }
		}
		char[][] t = memo2;
		memo2 = memo1;
		memo1 = t;
	    }
	    out.println(res);
	}
	out.flush();
	out.close();
    }
}
