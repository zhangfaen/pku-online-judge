import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Main
{
	static int n;
	static int[][] map;
	static int[] color;

	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = null;
		String[] sa = null;
		while (true)
		{
			s = in.readLine();
			n = Integer.parseInt(s);
			if (n == 0)
				break;
			map = new int[n][n];
			color = new int[n];
			temp = new int[n];
			for (int i = 0; i < n; i++)
			{
				s = in.readLine();
				sa = s.split(":");
				char c1 = sa[0].charAt(0);
				if (sa.length >= 2)
				{
					String t = sa[1];
					for (int j = 0; j < t.length(); j++)
					{
						char c2 = t.charAt(j);
						map[c1 - 'A'][c2 - 'A'] = map[c2 - 'A'][c1 - 'A'] = 1;
					}
				}
			}
			for (int i = 1; i <= n; i++)
			{
				try
				{
					dfs(0, i);
				} catch (Exception e)
				{
					if(i==1)
						System.out.println("1 channel needed.");
					else
						System.out.println(i+" channels needed.");
					break;
				}
			}
		}
	}
	static int[] temp;

	public static void dfs(int cur, int total) throws Exception
	{
		if (cur == n)
		{
			throw new Exception();
		}
		out: for (int i = 1; i <= total; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (map[cur][j] == 1 && color[j] == i)
					continue out;
			}
			color[cur] = i;
			dfs(cur + 1, total);
			color[cur] = 0;
		}
	}
}
