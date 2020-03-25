import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main
{
	static BufferedReader cin = null;
	static PrintWriter out = new PrintWriter(System.out);
	static int m, n;
	static int[][] map;
	static long[][] memo;
	static boolean[][] vst;

	public static void main(String[] args) throws Exception
	{
		cin = new BufferedReader(new InputStreamReader(System.in));
		String s = cin.readLine();
		String[] sa = s.split(" ");
		m = Integer.parseInt(sa[0]);
		n = Integer.parseInt(sa[1]);
		map = new int[m][n];
		for (int i = 0; i < m; i++)
		{
			StringTokenizer st = new StringTokenizer(cin.readLine());
			for (int j = 0; j < n; j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		memo = new long[m][1 << n];
		vst = new boolean[m][1 << n];
		long res=dp(0,0)% 100000000;
		System.out.println(res);
	}

	public static long dp(int ci, int state)
	{
		if (ci == m)
			return 1;
		if (vst[ci][state])
			return memo[ci][state];
		vst[ci][state] = true;
		long res = 0;
		for (int i = 0; i < (1 << n); i++)
		{
			if (check(ci,state, i))
			{
				res += dp(ci + 1, i);
				res %= 100000000;
			}
		}
		memo[ci][state] = res;
		return res;
	}

	public static boolean check(int x,int ps, int cs)
	{
		for(int i=0;i<n;i++)
		{
			if(((1<<i)&cs)!=0&&map[x][i]==0)return false;
		}
		for (int i = 0; i < n - 1; i++)
		{
			int fac1 = (1 << i) & cs;
			int fac2 = (1 << (i + 1)) & cs;
			if (fac1 != 0 && fac2 != 0)
				return false;
		}
		for (int i = 0; i < n; i++)
		{
			int fac1 = (1 << i) & ps;
			int fac2 = (1 << i) & cs;
			if (fac1 != 0 && fac2 != 0)
				return false;
		}
		return true;
	}
}
