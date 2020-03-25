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
			Map<Integer, String> pool = new HashMap<Integer, String>();
			for (int i = 0; i < n; i++)
				for (int j = i + 1; j < n; j++)
				{
					int key = p[i] + p[j];
					String ts = pool.get(key);
					if (ts == null)
					{
						ts = ""+i+";"+j;
						pool.put(key, ts);
					}
					else
					{
						ts=ts+";"+i+";"+j;
						pool.put(key, ts);
					}
				}
			for (int i = n - 1; i >= 3; i--)
			{
				for (int j =i-1; j >= 2; j--)
				{
					int key = p[i] - p[j];
					String ts = pool.get(key);
					if (ts != null)
					{
						String [] sa=ts.split(";");
						if (sa.length> 2 || sa.length == 2 &&sa[0].equals(""+j) == false&&sa[1].equals(""+j)==false)
						{
							System.out.println(p[i]);
							continue out;
						}
					}
				}
			}
			System.out.println("no solution");
			pool.clear();
			System.gc();
		}
	}
}
