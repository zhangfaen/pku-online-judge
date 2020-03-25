import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main
{

    static BufferedReader cin = null;
    static PrintWriter out = new PrintWriter(System.out);

    static int n, m;
    static int[][] memo;
    static boolean[][] vst;

    public static void main(String[] args) throws Exception
    {
	cin = new BufferedReader(new InputStreamReader(System.in));
	String s = cin.readLine();
	String[] sa = s.split(" ");
	n = Integer.parseInt(sa[0]);
	m = Integer.parseInt(sa[1]);
	memo = new int[n + 1][m + 1];
	vst = new boolean[n + 1][m + 1];
	for(int i=1;i<=m;i++)
	    memo[0][i]=0;
	for(int i=0;i<=n;i++)
	    memo[i][0]=1;
	for(int i=1;i<=n;i++)
	    for(int j=1;j<=m;j++)
	    {
		memo[i][j]+=memo[i-1][j];
		if(j>=i)
		    memo[i][j]+=memo[i][j-i];
		if(memo[i][j]>=1000000007)
		    memo[i][j]-=1000000007;
	    }

	int res = memo[n][m];
	System.out.println(res);
    }

    public static int dp(int cn, int cm)
    {
	if (vst[cn][cm])
	    return memo[cn][cm];
	vst[cn][cm] = true;
	if (cn == 0)
	{
	    if (cm > 0)
		return memo[cn][cm] = 0;
	    return memo[cn][cm] = 1;
	}
	if (cm == 0)
	    return memo[cn][cm] = 1;

	long re = 0;
	re += dp(cn - 1, cm);
	if (cm >= cn)
	{
	    re += dp(cn, cm - cn);
	}
	re %= 1000000007;
	memo[cn][cm] = (int) re;
	return (int) re;
    }
}
