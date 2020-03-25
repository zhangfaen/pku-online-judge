import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
public class Main
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String s = cin.readLine();
		int testcase = Integer.parseInt(s);
		while (testcase-- > 0)
		{
			s = cin.readLine();
			String[] sa = s.split(" ");
			int m = Integer.parseInt(sa[0]);
			int n = Integer.parseInt(sa[1]);
			int[] p = new int[n];
			int[] q = new int[n];
			s = cin.readLine();
			sa = s.split(" ");
			for (int i = 0; i < n; i++)
			{
				p[i] = Integer.parseInt(sa[i]);
			}
			Arrays.sort(p);
			PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(2001,
				new Comparator<Integer>()
				{
					public int compare(Integer o1, Integer o2)
					{
						return o2 - o1;
					}
				});
			for (int j = 0; j < m - 1; j++)
			{
				s = cin.readLine();
				sa = s.split(" ");
				for (int k = 0; k < n; k++)
					q[k] = Integer.parseInt(sa[k]);
				Arrays.sort(q);
				maxHeap.clear();
				for (int x = 0; x < n; x++)
				{
					maxHeap.add(p[x]+q[0]);
				}
				for(int y=1;y<n;y++)
				{
					for(int x=0;x<n;x++)
					{
						int t=p[x]+q[y];
						if(t>=maxHeap.peek())
						{
							break;
						}
						else
						{
							maxHeap.remove();
							maxHeap.add(t);
						}
					}
				}
				for(int i=0;i<n;i++)
					p[n-i-1]=maxHeap.poll();
				
			}
			for (int i = 0; i < n; i++)
			{
				out.print(p[i]);
				out.print(" ");
			}
			out.println();
		}
		out.flush();
	}
}