import java.util.LinkedList;
import java.util.Scanner;

public class Main
{
	static boolean[][] map;
	static int[] match1;
	static int[] match2;
	static int n;

	public static void main(String[] args) throws Exception
	{
		// BufferedReader cin = new BufferedReader(new
		// InputStreamReader(System.in));
		// String s = cin.readLine();
		Scanner cin = new Scanner(System.in);
		int testcase = cin.nextInt();
		while (testcase-- > 0)
		{
			n = cin.nextInt();
			int s = cin.nextInt();
			map = new boolean[n + 1][n + 1];
			match1=new int[n+1];
			match2=new int[n+2];
			for (int i = 0; i < s; i++)
			{
				int x = cin.nextInt();
				int y = cin.nextInt();
				map[x][y] = true;
			}
			int res=0;
			for(int i=1;i<=n;i++)
			{
				res+=find(i);
			}
			System.out.println(n-res);
		}
	}

	public static int find(int k)
	{
		int[] par = new int[n + 1];
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(k);
		while (!q.isEmpty())
		{
			int cur = q.removeFirst();
			for (int i = 1; i <= n; i++)
			{
				if (map[cur][i] && par[i] == 0)
				{
					if (match2[i] > 0)
					{
						par[i] = cur;
						q.add(match2[i]);
					} else
					{
						int j = cur;
						while (true)
						{
							int t = match1[j];
							match1[j] = i;
							match2[i] = j;
							if (t == 0)
								break;
							i = t;
							j = par[t];
						}
						return 1;
					}
				}
			}
		}
		return 0;
	}
}