
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
	static int n;
	static long c;
	static long[][][][] memo;
	static int[] res;

	public static void main(String[] args) throws Exception
	{
		// BufferedReader cin=new BufferedReader(new
		// InputStreamReader(System.in));
		// PrintWriter out=new PrintWriter(System.out);
		Scanner cin = new Scanner(System.in);
		int testcase = cin.nextInt();
		int MAX = 20;
		memo = new long[2][MAX][MAX][MAX];
		while (testcase-- > 0)
		{
			n = cin.nextInt();
			c = cin.nextLong();
			for (int i = 0; i < n; i++)
				for (int j = 0; j < MAX; j++)
					for (int k = 0; k < 2; k++)
						for (int x = 0; x < MAX; x++)
							memo[k][i][j][x] = -1;
			int state = (1 << n) - 1;
			res = new int[n];
			for (int i = 0; i < n; i++)
			{
				long d1 = dp(0, i, i,n-i-1);
				if (d1 >= c)
				{
					res[0] = i;
					dfs(0, i, state & (~(1 << i)), c, 1);
					break;
				} else
				{
					c -= d1;
				}
				d1 = dp(1, i,i,n-i-1);
				if (d1 >= c)
				{
					res[0] = i;
					dfs(1, i, state & (~(1 << i)), c, 1);
					break;
				} else
				{
					c -= d1;
				}
			}
			for (int i = 0; i < n; i++)
				System.out.print((res[i] + 1) + " ");
			System.out.println();
		}
	}

	public static void dfs(int style, int pi, int state, long cc, int depth)
	{
		if (depth == n)
			return;
		if (style == 0)
		{
			for (int i = 0; i < n; i++)
			{
				if (i < pi && ((1 << i) & state) != 0)
				{
					int scnt=0,lcnt=0;
					for(int j=0;j<i;j++)
						if(((1<<j)&state)!=0)
							scnt++;
					for(int j=i+1;j<n;j++)
						if(((1<<j)&state)!=0)lcnt++;
					long d1 = dp(1, i, scnt,lcnt);
					if (d1 >= cc)
					{
						res[depth] = i;
						dfs(1, i, state & (~(1 << i)), cc, depth + 1);
						break;
					} else
						cc -= d1;
				}
			}
		} else
		{
			for (int i = 0; i < n; i++)
			{
				if (i > pi && ((1 << i) & state) != 0)
				{
					int scnt=0,lcnt=0;
					for(int j=0;j<i;j++)
						if(((1<<j)&state)!=0)
							scnt++;
					for(int j=i+1;j<n;j++)
						if(((1<<j)&state)!=0)lcnt++;
					long d1 = dp(0, i, scnt,lcnt);
					if (d1 >= cc)
					{
						res[depth] = i;
						dfs(0, i, state & (~(1 << i)), cc, depth + 1);
						break;
					} else
						cc -= d1;
				}
			}
		}
	}

	public static long dp(int style, int pi, int scnt, int lcnt)
	{
		if (scnt + lcnt == 0)
			return 1;
		if (memo[style][pi][scnt][lcnt] != -1)
			return memo[style][pi][scnt][lcnt];
		long re = 0;
		if (style == 0)
		{
			// down
			for (int i = 0; i < scnt; i++)
			{
				re += dp(1, i, i, lcnt + scnt - i - 1);
			}
		} else
		{
			// up
			for (int i = 0; i < lcnt; i++)
			{
				re += dp(0, i, scnt + i, lcnt - i - 1);
			}
		}
		memo[style][pi][scnt][lcnt] = re;
		return re;
	}
}
