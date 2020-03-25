

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while (true)
		{
			String s = cin.readLine();
			if (s.equals("0"))
				break;
			StringTokenizer st = new StringTokenizer(s);
			List<Integer> li = new ArrayList<Integer>();
			while (st.hasMoreTokens())
			{
				li.add(Integer.parseInt(st.nextToken()));
			}
			calc(li, 0);
			for (int d : li)
				System.out.print(d + " ");
			System.out.println();
		}
	}

	public static void calc(List<Integer> li, int end)
	{
		if (end == li.size() - 1)
			return;
		int newEnd = 2 * end + 1;
		List<Integer> tmp = new ArrayList<Integer>();
		for (int i = 0; i < end; i++)
		{
			int sum = li.get(i);
			int diff = li.get(i + end + 1);
			tmp.add((sum + diff) / 2);
			tmp.add((sum - diff) / 2);
		}
		for (int i = 0; i < tmp.size(); i++)
			li.set(i, tmp.get(i));
	}
}
