import java.io.IOException;
import java.util.Scanner;

public class Main
{

    // static BufferedReader cin = new BufferedReader(new InputStreamReader(
    // System.in));
    static int[][] memo;

    public static void main(String[] args) throws IOException
    {
	Scanner cin = new Scanner(System.in);
	while (true)
	{
	    n = cin.nextInt();
	    m = cin.nextInt();
	    if (m + n == 0)
		break;
	    m++;
	    n++;
	    if (m == 1 || n == 1)
	    {
		System.out.println(Math.max(m, n) + 1);
		continue;
	    }
	    memo = new int[m][n];
	    for (int i = 0; i < m; i++)
		for (int j = 0; j < n; j++)
		    memo[i][j] = -1;
	    memo[m - 1][n - 1] = 1;
	    int end=Math.max(m, n);
	    for(int i=m-1;i>=0;i--)
		for(int j=n-1;j>=0;j--)
		    dp(i,j);
	    int res = dp(0, 0);
	    System.out.println(res);
	}
    }
    static int m, n;

    public static int dp(int ci, int cj)
    {
	if (memo[ci][cj] != -1)
	    return memo[ci][cj];
	int re = 0;
	if (ci < m - 1)
	    re += dp(ci + 1, cj);
	if (cj < n - 1)
	    re += dp(ci, cj + 1);
	memo[ci][cj] = re;
	return re;
    }
}
