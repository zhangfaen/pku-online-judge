import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(cin.readLine());
		out: while (cnt-- > 0)
		{
			String[] sa = cin.readLine().split(" +");
			int[] vs = new int[4];
			for (int i = 0; i < 4; i++)
				vs[i] = Integer.parseInt(sa[i]);
			PriorityQueue<Integer> q = new PriorityQueue<Integer>();
			boolean[] vst = new boolean[1000001];
			q.add(0);
			vst[0] = true;
			while (q.size() > 0)
			{
				int cur = q.poll();
				for (int i = 0; i < 4; i++)
				{
					int n = cur + vs[i];
					if (n>1000000||vst[n])
						continue;
					vst[n] = true;
					q.add(n);
				}
			}
			int left = 0;
			int min = -1;
			for (int i = 0; i <= 1000000; i++)
			{
				if (vst[i] == false)
				{
					left++;
					if (min == -1)
					{
						min = i;
					}
				}
			}
			System.out.println(left);
			System.out.println(min);
		}
	}
}