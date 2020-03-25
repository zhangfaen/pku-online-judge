import java.util.*;
public class Main
{
	static int maxn = 110;
	static int maxint = 100000000;
	static int[][] map;
	static int[] link;
	static int[] lx;
	static int[] ly;
	static boolean[] x;
	static boolean[] y;
	static int n, m;
	static boolean find(int v)
	{
		int j, k;
		x[v] = true;
		for (j = 1; j <= n; j++)
			if (y[j] == false && lx[v] + ly[j] == map[v][j])
			{
				y[j] = true;
				k = link[j];
				link[j] = v;
				if (k == 0 || find(k))
					return true;
				link[j] = k;
			}
		return false;
	}
	public static void main(String[] args)
	{
		int i, j, k, d, ans;
		Scanner cin = new Scanner(System.in);
		while (true)
		{
			if (setMap(cin) == false)
				break;
			link = new int[maxn];
			lx = new int[maxn];
			ly = new int[maxn];
			// 这是最大匹配 最佳匹配就转为负值 map[i][j]=-k;当然输出也是是-ans啦
			for (i = 1; i <= n; i++)
				for (j = 1; j <= n; j++)
					if (map[i][j] > lx[i])
						lx[i] = map[i][j];
			for (k = 1; k <= n; k++)
				do
				{
					x = new boolean[maxn];
					y = new boolean[maxn];
					if (find(k))
						break;
					d = maxint;
					for (i = 1; i <= n; i++)
						if (x[i])
							for (j = 1; j <= n; j++)
								if (!y[j] && lx[i] + ly[j] - map[i][j] < d)
									d = lx[i] + ly[j] - map[i][j];
					for (i = 1; i <= n; i++)
					{
						if (x[i])
							lx[i] -= d;
						if (y[i])
							ly[i] += d;
					}
				} while (true);
			for (ans = 0, i = 1; i <= n; i++)
				ans += map[link[i]][i];
			System.out.printf("%d\n", -ans);
		}
	}
	public static boolean setMap(Scanner cin)
	{
	
		int N = cin.nextInt(), M = cin.nextInt();
		if (N + M == 0)
			return false;
		map = new int[maxn][maxn];
		n=0;
		int[] hx = new int[maxn];
		int[] hy = new int[maxn];
		int[] sx = new int[maxn];
		int[] sy = new int[maxn];
		int hsize = 0, ssize = 0;
		for (int i = 0; i < N; i++)
		{
			String s = cin.next();
			for (int j = 0; j < M; j++)
			{
				if (s.charAt(j) == 'm')
				{
					n++;
					sx[ssize] = i;
					sy[ssize++] = j;
				}
				if (s.charAt(j) == 'H')
				{
					hx[hsize] = i;
					hy[hsize++] = j;
				}
			}
		}
		for (int i = 0; i < ssize; i++)
			for (int j = 0; j < hsize; j++)
			{
				map[j+1][i+1]=map[i + 1][j + 1] = -Math.abs(sx[i] - hx[j]) - Math.abs(sy[i] - hy[j]);
			}
		return true;
	}
}