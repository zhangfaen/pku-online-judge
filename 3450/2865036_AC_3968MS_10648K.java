

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main
{
	static char alls[][];
	static class Ae implements Comparable<Ae>
	{
		int i, j;

		public Ae(int i, int j)
		{
			this.i = i;
			this.j = j;
		}

		public int compareTo(Ae o)
		{
			char[] ca1 = alls[i];
			char[] ca2 = alls[o.i];
			int x = j, y = o.j;
			while (x < ca1.length && y < ca2.length)
			{
				if (ca1[x] != ca2[y])
					return ca1[x] - ca2[y];
				x++;
				y++;
			}
			if (x == ca1.length && y == ca2.length)
				return 0;
			if (x < ca1.length)
				return 1;
			return -1;
		}

		public String toString()
		{
			String re = "";
			for (int x = j; x < alls[i].length; x++)
				re += alls[i][x];
			re += ":" + i;
			return re;
		}
	}
	static Ae[] aes;

	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while (true)
		{
			String s = cin.readLine();
			int n = Integer.parseInt(s);
			if (n == 0)
				break;
			alls = new char[n][];
			int total = 0;
			for (int i = 0; i < n; i++)
			{
				alls[i] = cin.readLine().toCharArray();
				total += alls[i].length;
			}
			aes = new Ae[total];
			int tag = 0;
			for (int i = 0; i < n; i++)
			{
				for (int j = 0; j < alls[i].length; j++)
					aes[tag++] = new Ae(i, j);
			}
			Arrays.sort(aes);
			Map<Integer, Integer> mii = new HashMap<Integer, Integer>();
			PriorityQueue<Integer> q = new PriorityQueue<Integer>();
			String res = "";
			for (int i = 0; i < total; i++)
			{
				if (mii.containsKey(aes[i].i))
				{
					q.remove(mii.get(aes[i].i));
				}
				mii.put(aes[i].i, i);
				q.add(i);
				if (mii.size() == n)
				{
					String tmp = get(alls[aes[q.peek()].i], alls[aes[i].i], aes[q.peek()].j,
						aes[i].j);
					if (tmp.length() > res.length())
						res = tmp;
					else if (tmp.length() == res.length() && tmp.compareTo(res) < 0)
					{
						res = tmp;
					}
				}
			}
			if (res.length() == 0)
				System.out.println("IDENTITY LOST");
			else
				System.out.println(res);
		}
	}

	public static String get(char[] ca1, char[] ca2, int i, int j)
	{
		StringBuffer sb = new StringBuffer();
		while (i < ca1.length && j < ca2.length)
		{
			if (ca1[i] == ca2[j])
				sb.append(ca1[i]);
			else
				break;
			i++;
			j++;
		}
		return sb.toString();
	}
}
