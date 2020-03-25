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
	int [][] m2=new int[2][2000000];
	while (true)
	{
	   long nn = cin.nextLong();
	    long mm = cin.nextLong();
	    if (mm + nn == 0)
		break;
	    mm++;
	    nn++;
	    if (mm == 1 || nn == 1)
	    {
		System.out.println(Math.max(mm, nn) + 1);
		continue;
	    }
	    m=(int)mm;
	    n=(int)nn;
	    if(m>n)
	    {
		int t=m;m=n;n=t;
	    }
	    if(m==2)
		memo=m2;
	    else
		memo = new int[m][n];
	    for (int i = 0; i < m; i++)
		for (int j = 0; j < n; j++)
		    memo[i][j] = -1;
	    memo[m - 1][n - 1] = 1;
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
