import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		int testcase = 1;
		while (true)
		{
			int n = 0, lucky = 0;
			int[] deck = {};
			try
			{
				String s = cin.readLine();
				if (s == null)
					break;
				s = s.trim();
				String[] sa = s.split(" +");
				n = Integer.parseInt(sa[0]);
				lucky = Integer.parseInt(sa[1]);
				deck = new int[sa.length-2];
				for (int i = 2; i <sa.length; i++)
					deck[i - 2] = Integer.parseInt(sa[i]);
			} catch (Exception e)
			{
				continue;
			}
			List<Integer> li = new ArrayList<Integer>();
			for (int i = 1; i <= n; i++)
				li.add(i);
			int cur = 0;
			out:while (li.size() > lucky)
			{
				int cnt = deck[cur];
				cur = (cur + 1) % 20;
				int ri = cnt - 1;
				while (ri < li.size())
				{
					li.remove(ri);
if(li.size()<=lucky) break out;
					ri += cnt - 1;
				}
			}
			System.out.println("Selection #" + testcase);
			for (int d : li)
				System.out.print(d + " ");
			System.out.println();
System.out.println();
			testcase++;
		}
	}
}