import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main
{
	static char p[];
	static char s[];

	static int[] getNext()
	{
		int[] re = new int[p.length];
		re[0] = -1;
		int q = -1;
		for (int i = 1; i < p.length; i++)
		{
			while (q >= 0 && p[q + 1] != p[i])
				q = re[q];
			if (p[q + 1] == p[i])
				q++;
			re[i] = q;
		}
		return re;
	}

	static int kmp()
	{
		int re = 0;
		int[] next = getNext();
		int j = -1;
		for (int i = 0; i < s.length; i++)
		{
			while (j >= 0 && p[j + 1] != s[i])
				j = next[j];
			if (p[j + 1] == s[i])
				j++;
			if (j == p.length - 1)
			{
				re++;
				j = next[j];
			}
		}
		return re;
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(cin.readLine());
		while (cnt-- > 0)
		{
			p = cin.readLine().toCharArray();
			s = cin.readLine().toCharArray();
			int res = kmp();
			System.out.println(res);
		}
	}
}