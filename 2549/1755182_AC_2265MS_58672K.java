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
						ts = ""+i+","+j;
						pool.put(key, ts);
					}
					else
					{
						ts=ts+";"+i+","+j;
						pool.put(key, ts);
					}
				}
			for (int i = n - 1; i >= 0; i--)
			{
				for (int j =n-1; j >= 0; j--)
				{
					if(i==j)continue;
					int key = p[i] - p[j];
					String ts = pool.get(key);
					if (ts != null)
					{
						String [] sa=ts.split(";");
						if (sa.length> 2 )
						{
							System.out.println(p[i]);
							continue out;
						}
						for(int k=0;k<sa.length;k++)
						{
							String [] na=sa[k].split(",");
							int d1=Integer.parseInt(na[0]);
							int d2=Integer.parseInt(na[1]);
							if(i!=d1&&i!=d2&&j!=d1&&j!=d2)
							{
								System.out.println(p[i]);
								continue out;
							}
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
