
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main
{
	static boolean[][] map;

	public static void main(String[] args) throws Exception
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		int n, m;
		String rs = cin.readLine();
		String[] rsa = rs.split(" ");
		n = Integer.parseInt(rsa[0]);
		m = Integer.parseInt(rsa[1]);
		map = new boolean[n][n];
		for (int i = 0; i < m; i++)
		{
			rs = cin.readLine();
			rsa = rs.split(" ");
			map[Integer.parseInt(rsa[0]) - 1][Integer.parseInt(rsa[1]) - 1] = true;
		}
		int re = BiGraphNew.get(map);
		System.out.println(re);
	}
	static class BiGraphNew
	{
		static int m, n;
		static boolean[][] map;
		static int[] match1;
		static int[] match2;
		static boolean[] vst;

		public static int get(boolean[][] map)
		{
			m = map.length;
			n = map[0].length;
			BiGraphNew.map = map;
			match1 = new int[m];
			match2 = new int[n];
			Arrays.fill(match1, -1);
			Arrays.fill(match2, -1);
			vst = new boolean[m];
			int re = 0;
			for (int i = 0; i < m; i++)
			{
				Arrays.fill(vst, false);
				re += find(i);
			}
			return re;
		}

		private static int find(int s)
		{
			for (int i = 0; i < n; i++)
			{
				if (map[s][i] && vst[i] == false)
				{
					vst[i] = true;
					if (match2[i] == -1 || find(match2[i]) == 1)
					{
						match1[s] = i;
						match2[i] = s;
						return 1;
					}
				}
			}
			return 0;
		}
	}
}
