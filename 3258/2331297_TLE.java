import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main
{
	static BufferedReader cin = null;
	static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) throws Exception
	{
		cin = new BufferedReader(new InputStreamReader(System.in));
		String s = cin.readLine();
		StringTokenizer st = new StringTokenizer(s);
		int len = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] p = new int[n];
		for (int i = 0; i < n; i++)
		{
			p[i] = Integer.parseInt(cin.readLine());
		}
		Arrays.sort(p);
		int left = 1, right = 1000000001;
		while (left < right)
		{
			int mid = (left + right) / 2;
			if (check(p, mid, m, len))
				left = mid;
			else
				right = mid-1;
		}
		System.out.println(left);
	}

	public static boolean check(int[] p, int slen, int m, int end)
	{
		int pre = 0;
		for (int i = 0; i < p.length; i++)
		{
			if (p[i] - pre < slen)
			{
				m--;
				if (m < 0)
					return false;
			} else
				pre = p[i];
		}
		if (end - pre < slen)
			m--;
		if (m < 0)
			return false;
		return true;
	}
}
