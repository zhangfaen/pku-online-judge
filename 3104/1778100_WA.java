import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main
{
	static int[] p;
	static int n;
	static int k;

	public static void main(String[] args) throws Exception
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		String s = cin.readLine();
		n = Integer.parseInt(s);
		p = new int[n];
		s = cin.readLine();
		String[] sa = s.split(" ");
		int right = 1;
		for (int i = 0; i < n; i++)
		{
			p[i] = Integer.parseInt(sa[i]);
			right = Math.max(right, p[i]);
		}
		s = cin.readLine();
		k = Integer.parseInt(s);
		int left = 1;
		while (left < right)
		{
			int mid = (left + right) / 2;
			if (check(mid))
			{
				right = mid;
			} else
			{
				left = mid + 1;
			}
		}
		System.out.println(left);
	}

	public static boolean check(int t)
	{
		int count = 0;
		for (int i = 0; i < n; i++)
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
			}
		}
		if (count > t)
			return false;
		return true;
	}
}
