import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		//BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		Scanner cin=new Scanner(System.in);
		int testcase = 1;
		while (cin.hasNextInt())
		{
			int n = cin.nextInt(), lucky = cin.nextInt();
			int[] deck = {};
			try
			{

				deck = new int[20];
				for (int i = 0; i < 20; i++)
					deck[i]=cin.nextInt();
			} catch (Exception e)
			{
				continue;
			}
			List<Integer> li = new ArrayList<Integer>();
			for (int i = 1; i <= n; i++)
				li.add(i);
			int cur = 0;
			while (li.size() > lucky)
			{
				int cnt = deck[cur];
				cur = (cur + 1) % 20;
				int ri = cnt - 1;
				while (ri < li.size())
				{
					li.remove(ri);
					ri += cnt - 1;
				}
			}
			System.out.println("Selection #" + testcase);
			for (int d : li)
				System.out.print(d + " ");
			System.out.println();
			testcase++;
		}
	}
}