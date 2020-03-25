import java.util.*;
import java.io.*;

public class RiverCrossing
{
	int c1s = 0, c2s = 0;
	int[] c1 = new int[201];
	int[] c2 = new int[201];
	int[][][][] memo;
	int units, t;

	public int minimalWait(String[] cargo, int units, int t)
	{
		this.units = units;
		this.t = t;
		for (String s : cargo)
		{
			String[] sa = s.split(" ");
			int u = Integer.parseInt(sa[0]);
			int gt = Integer.parseInt(sa[1]);
			if (sa[2].equals("right"))
			{
				for (int i = 0; i < u; i++)
					c2[c2s++] = gt;
			} else
			{
				for (int i = 0; i < u; i++)
					c1[c1s++] = gt;
			}
		}
		memo = new int[101][2][c1s + 1][c2s + 1];
		for (int i = 0; i < 101; i++)
			for (int j = 0; j < 2; j++)
				for (int k = 0; k < c1s + 1; k++)
					for (int g = 0; g < c2s + 1; g++)
						memo[i][j][k][g] = -1;
		int re = dp(0, 0, 0, 0);
		return re;
	}

	public int dp(int ct, int side, int c1i, int c2i)
	{
		if (c1i == c1s && c2i == c2s)
			return 0;
		if (ct >= 100)
		{
			return greedy(ct, side, c1i, c2i);
		}
		if (memo[ct][side][c1i][c2i] != -1)
			return memo[ct][side][c1i][c2i];
		int re = Integer.MAX_VALUE;
		if (side == 0)
		{
			int tre = dp(ct + t, 1, c1i, c2i);
			re = Math.min(tre, re);
			int tw = 0;
			for (int i = c1i; i < c1i + units && i < c1s; i++)
			{
				int d = ct - c1[i];
				if (d < 0)
					d = 0;
				tw += d;
				tre = tw + dp(Math.max(ct, c1[i]) + t, 1, i + 1, c2i);
				re = Math.min(re, tre);
			}
		} else
		{
			int tre = dp(ct + t, 0, c1i, c2i);
			re = Math.min(tre, re);
			int tw = 0;
			for (int i = c2i; i < c2i + units && i < c2s; i++)
			{
				int d = ct - c2[i];
				if (d < 0)
					d = 0;
				tw += d;
				tre = tw + dp(Math.max(ct, c2[i]) + t, 0, c1i, i + 1);
				re = Math.min(re, tre);
			}
		}
		return memo[ct][side][c1i][c2i] = re;
	}

	public int greedy(int ct, int side, int c1i, int c2i)
	{
		if (c1i == c1s && c2i == c2s)
			return 0;
		if (side == 0)
		{
			int re = 0;
			if (c1i < c1s)
			{
				int end = Math.min(c1i + units, c1s);
				for (int i = c1i; i < end; i++)
					re += ct - c1[i];
				return re += greedy(ct + t, 1, end, c2i);
			} else
				return greedy(ct + t, 1, c1i, c2i);
		} else
		{
			int re = 0;
			if (c2i < c2s)
			{
				int end = Math.min(c2i + units, c2s);
				for (int i = c2i; i < end; i++)
					re += ct - c2[i];
				return re += greedy(ct + t, 0, c1i, end);
			} else
				return greedy(ct + t, 0, c1i, c2i);
		}
	}

	public static void main(String[] args)
	{
	}
}
