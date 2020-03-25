import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main
{
	static BufferedReader cin = null;
	static PrintWriter out = new PrintWriter(System.out);
	static int n, m;
	static List<Integer>[] map;
	static int[] memo;
	static int[] vs;
	static int[] incoming;

	public static void main(String[] args) throws Exception
	{
		cin = new BufferedReader(new InputStreamReader(System.in));
		int [] q=new int[5000000];
		while (true)
		{
			String s = cin.readLine();
			if (s == null)
				break;
			String[] sa = s.split(" ");
			n = Integer.parseInt(sa[0]);
			m = Integer.parseInt(sa[1]);
			map = new ArrayList[n];
			memo = new int[n];
			incoming = new int[n];
			vs = new int[n];
			for (int i = 0; i < n; i++)
				map[i] = new ArrayList<Integer>(10);
			for (int i = 0; i < n; i++)
			{
				s = cin.readLine();
				vs[i] = Integer.parseInt(s);
			}
			for (int i = 0; i < m; i++)
			{
				s = cin.readLine();
				sa = s.split(" ");
				int x = Integer.parseInt(sa[0]);
				int y = Integer.parseInt(sa[1]);
				map[x - 1].add(y - 1);
				incoming[y - 1]++;
			}
			Arrays.fill(memo, Integer.MIN_VALUE);
			int res = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++)
			{
				if (incoming[i] == 0)
				{
					int head=0,tail=0;
					memo[i]=vs[i];
					q[tail++]=i;
					while(head<tail)
					{
						int cn=q[head++];
						int cs=memo[cn];
						for(int next:map[cn])
						{
							if(cs+vs[next]>memo[next])
							{
								memo[next]=cs+vs[next];
								q[tail++]=next;
							}
						}
					}
				}
			}
			for(int d:memo)
				res=Math.max(res, d);
			out.println(res);
		}
		out.flush();
	}
}
