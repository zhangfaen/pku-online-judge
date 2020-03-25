import java.util.*;
public class Main
{
	static int[][] map;
	public static void main(String[] args)
	{
		int i, j, k, d, ans;
		Scanner cin = new Scanner(System.in);
		while (true)
		{
			if (setMap(cin) == false)
				break;
			int res = BiGraphPerfectMatch.get(map,false);
			System.out.println(res);
		}
	}
	public static boolean setMap(Scanner cin)
	{
		int N = cin.nextInt(), M = cin.nextInt();
		if (N + M == 0)
			return false;
		
		int n = 0;
		int maxn=110;
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
		map = new int[n][n];
		for (int i = 0; i < ssize; i++)
			for (int j = 0; j < hsize; j++)
			{
				map[i][j] = Math.abs(sx[i] - hx[j]) + Math.abs(sy[i] - hy[j]);
			}
		return true;
	}
}

class BiGraphPerfectMatch
{
	static int BIG = Integer.MAX_VALUE;
	static int[][] map;
	static int[] link;
	static int[] lx;
	static int[] ly;
	static boolean[] x;
	static boolean[] y;
	static int n;
	public static int get(int[][] wmap,boolean wantToGetBig)
	{
		int i, j, k, d, ans;
		n = wmap.length;
		map = new int[n][n];
		link = new int[n];
		Arrays.fill(link, -1);
		lx = new int[n];
		ly = new int[n];
		int fac=1;
		if(wantToGetBig==false)
			fac=-1;
		for (i = 0; i < n; i++)
			for (j = 0; j < n; j++)
				map[i][j] =fac*wmap[i][j];
		// 这是最大匹配 最佳匹配就转为负值 map[i][j]=-k;当然输出也是是-ans啦
		for (i = 0; i < n; i++)
			for (j = 0; j < n; j++)
				if (map[i][j] > lx[i])
					lx[i] = map[i][j];
		for (k = 0; k < n; k++)
			do
			{
				x = new boolean[n];
				y = new boolean[n];
				if (find(k))
					break;
				d = Integer.MAX_VALUE;
				for (i = 0; i < n; i++)
					if (x[i])
						for (j = 0; j < n; j++)
							if (!y[j] && lx[i] + ly[j] - map[i][j] < d)
								d = lx[i] + ly[j] - map[i][j];
				for (i = 0; i < n; i++)
				{
					if (x[i])
						lx[i] -= d;
					if (y[i])
						ly[i] += d;
				}
			} while (true);
		for (ans = 0, i = 0; i < n; i++)
			ans += map[link[i]][i];
		return fac*ans;
	}
	static boolean find(int v)
	{
		int j, k;
		x[v] = true;
		for (j = 0; j < n; j++)
			if (y[j] == false && lx[v] + ly[j] == map[v][j])
			{
				y[j] = true;
				k = link[j];
				link[j] = v;
				if (k == -1 || find(k))
					return true;
				link[j] = k;
			}
		return false;
	}
}