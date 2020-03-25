import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Main
{
	static int[] p = new int[100001];
	static int n;
	static int k;

	public static void main(String[] args) throws Exception
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String s = cin.readLine();
		n = Integer.parseInt(s);
		s = cin.readLine();
		String[] sa = s.split(" ");
		int right = 1;
		for (int i = 0; i < n; i++)
		{
			p[i] = Integer.parseInt(sa[i]);
			right = Math.max(right, p[i]);
		}
		Arrays.sort(p, 0, n);
		s = cin.readLine();
		k = Integer.parseInt(s);
		int left = 1;
		while (left < right)
		{
			int mid = (int) ((1L + left + right-1L) / 2);
			if (check(mid))
				right = mid;
			else
				left = mid + 1;
		}
		out.println(right);
		out.flush();
	}

	public static boolean check(int t)
	{
		int count = 0;
		for (int i = n - 1; i >= 0; i--)
		{
			if (count > t)
				return false;
			if (p[i] > t)
			{
				int d = p[i] - t;
				if (d % k == 0)
					count += d / k;
				else
					count += (d / k + 1);
			} else
				break;
		}
		if (count > t)
			return false;
		return true;
	}
}
