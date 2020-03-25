import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public class Main
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		out: while (true)
		{
			String s = cin.readLine().trim();
			int n = Integer.parseInt(s);
			if (n == 0)
				break;
			int[] p = new int[n];
			for (int i = 0; i < n; i++)
				p[i] = Integer.parseInt(cin.readLine().trim());
			Arrays.sort(p);
			Map<Integer, Set<Integer>> pool = new HashMap<Integer, Set<Integer>>();
			for (int i = 0; i < n; i++)
				for (int j = i + 1; j < n; j++)
				{
					int key = p[i] + p[j];
					Set<Integer> ts = pool.get(key);
					if (ts == null)
					{
						ts = new HashSet<Integer>();
						pool.put(key, ts);
					}
					if (ts.size() <= 2)
					{
						ts.add(i);
						ts.add(j);
					}
				}
			for (int i = n - 1; i >= 0; i--)
			{
				for (int j = i - 1; j >= 0; j--)
				{
					int key = p[i] - p[j];
					Set<Integer> ts = pool.get(key);
					if (ts != null)
					{
						if (ts.size() > 2 || ts.size() == 2 && ts.contains(j) == false)
						{
							System.out.println(p[i]);
							continue out;
						}
					}
				}
			}
			System.out.println("no solution");
			System.gc();
		}
	}
}
