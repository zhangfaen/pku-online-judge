import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main
{
	static int target = 0;
	static char[] ds;
	static int best;
	static List<String> temp = new ArrayList<String>(20);
	static List<String> bestList = new ArrayList<String>(20);
	static boolean isRejected;
	static boolean find;

	public static void main(String[] args) throws IOException
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while (true)
		{
			String s = cin.readLine();
			String[] sa = s.split(" ");
			target = Integer.parseInt(sa[0]);
			int digits = Integer.parseInt(sa[1]);
			if (target + digits == 0)
				break;
			if (target == digits)
			{
				out.println(target + " " + digits);
				continue;
			}
			if (target > digits)
			{
				out.println("error");
				continue;
			}
			best = 0;
			temp.clear();
			bestList.clear();
			ds = ("" + digits).toCharArray();
			isRejected = false;
			find = false;
			dfs(0, 0);
			if (isRejected)
			{
				out.println("rejected");
			} else if (find == false)
			{
				out.println("error");
			} else
			{
				out.print(best);
				for (String t : bestList)
					out.print(" " + t);
				out.println();
			}
		}
		out.flush();
		out.close();
	}

	public static void dfs(int ci, int cmax)
	{
		if (ci == ds.length)
		{
			if (cmax > best)
			{
				find = true;
				best = cmax;
				copy(temp, bestList);
				isRejected = false;
			} else if (best == cmax)
			{
				isRejected = true;
			}
			return;
		}
		StringBuilder sb = new StringBuilder(10);
		for (int i = ci; i < ds.length; i++)
		{
			sb.append(ds[i]);
			int d = Integer.parseInt(sb.toString());
			if (cmax + d <= target)
			{
				temp.add(sb.toString());
				dfs(i + 1, cmax + d);
				temp.remove(temp.size() - 1);
			}
		}
	}

	public static void copy(List<String> ls1, List<String> ls2)
	{
		ls2.clear();
		for (String s : ls1)
			ls2.add(s);
	}
}