import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{

    static BufferedReader cin;
    static int n, m;
    static int[][] cost;
    static int[][] income;
    static int[][] memo;

    public static void main(String[] args) throws IOException
    {

	cin = new BufferedReader(new InputStreamReader(System.in));
	while (true)
	{
	    String s = cin.readLine();
	    String[] sa = s.split(" ");
	    n = Integer.parseInt(sa[0]);
	    m = Integer.parseInt(sa[1]);
	    if(n+m==0)break;
	    cost = new int[n][n];
	    for (int i = 0; i < n; i++)
	    {
		s = cin.readLine();
		sa = s.split(" ");
		for (int j = 0; j < n; j++)
		    cost[i][j] = Integer.parseInt(sa[j]);
	    }
	    cin.readLine();
	    income = new int[m][n];
	    for (int i = 0; i < m; i++)
	    {
		s = cin.readLine();
		sa = s.split(" ");
		for (int j = 0; j < n; j++)
		    income[i][j] = Integer.parseInt(sa[j]);
	    }
	    cin.readLine();
	    memo = new int[n][m];
	    for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
		    memo[i][j] = Integer.MIN_VALUE;
	    int res=dp(0,0);
	    System.out.println(res);
	}
    }
    static int INF = Integer.MIN_VALUE / 2;

    public static int dp(int cn, int cm)
    {
	if (cm == m)
	    return 0;
	if (memo[cn][cm] != Integer.MIN_VALUE)
	    return memo[cn][cm];
	int re = INF;
	for(int i=0;i<n;i++)
	{
	    int d=0;
	    d+=income[cm][i]+dp(i,cm+1)-cost[cn][i];
	    re=Math.max(re, d);
	}
	memo[cn][cm]=re;
	return re;
    }

}
