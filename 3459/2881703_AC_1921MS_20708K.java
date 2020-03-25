import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main
{
	static int m, n;
	static int[] reward;
	static int[] punish;
	static int[][] p;
	static int salary;
	static Ret memo[][];
	static boolean vst[][];
	static class Ret
	{
		int best;
		Set<Integer> si = null;

		public Ret(int best, Set<Integer> si)
		{
			this.best = best;
			this.si = si;
		}
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(cin.readLine());
		while (cnt-- > 0)
		{
			m = Integer.parseInt(cin.readLine());
			n = Integer.parseInt(cin.readLine());
			salary = Integer.parseInt(cin.readLine());
			p = new int[m][n + 1];
			reward = new int[m];
			punish = new int[m];
			for (int i = 0; i < m; i++)
			{
				StringTokenizer st = new StringTokenizer(cin.readLine());
				for (int j = 0; j < n; j++)
					p[i][j + 1] = Integer.parseInt(st.nextToken());
				reward[i] = Integer.parseInt(st.nextToken());
				punish[i] = Integer.parseInt(st.nextToken());
			}
			memo = new Ret[m][n + 1];
			vst = new boolean[m][n + 1];
			Ret ret = dp(0, n);
			System.out.println(ret.best);
			int[] os = new int[ret.si.size()];
			int tag = 0;
			for (int d : ret.si)
				os[tag++] = d;
			Arrays.sort(os);
			for (int d : os)
				System.out.print(d + " ");
			System.out.println();
		}
	}

	public static Ret dp(int ci, int cn)
	{
		if (cn == 0)
		{
			Set<Integer> si = new HashSet<Integer>();
			int best = 0;
			for (int i = ci; i < m; i++)
				best += 100 * punish[i];
			si.add(0);
			return new Ret(-best, si);
		}
		if (ci == m)
		{
			Set<Integer> si = new HashSet<Integer>();
			si.add(0);
			return new Ret(0, si);
		}
		if (vst[ci][cn])
			return memo[ci][cn];
		vst[ci][cn] = true;
		int best = Integer.MIN_VALUE / 2;
		Set<Integer> si = new HashSet<Integer>();
		for (int i = 0; i <= cn; i++)
		{
			int t = p[ci][i] * (reward[ci] - salary * i) - (100 - p[ci][i]) * punish[ci];
			Ret tr = dp(ci + 1, cn - i);
			t += tr.best;
			if (t > best)
			{
				best = t;
				si.clear();
				for (int d : tr.si)
					si.add(d + i);
			} else if (t == best)
			{
				for (int d : tr.si)
					si.add(i + d);
			}
		}
		memo[ci][cn] = new Ret(best, si);
		return memo[ci][cn];
	}
}