import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		while (true)
		{
			String s = cin.readLine();
			if (s.equals("#"))
				break;
			String t = cin.readLine();
			if (t.length() > s.length())
			{
				System.out.println(0);
				continue;
			}
			while (t.length() < s.length())
				t = "0" + t;
			long ret = 0;
			int tag=0;
			for (int i = 0; i < s.length(); i++)
			{
				
				if (s.charAt(i) == '?')
				{
					ret += ('9' - t.charAt(i)) * (long) Math.pow(10, cnt(i + 1, s));
				}
				else
				{
					if(s.charAt(i)>t.charAt(i))
					{
						ret+=(long)Math.pow(10, cnt(i+1,s));
						break;
					}
					if(s.charAt(i)<t.charAt(i))
						break;
				}
			}
			System.out.println(ret);
		}
	}

	public static int cnt(int ci, String t)
	{
		int ret = 0;
		for (int i = ci; i < t.length(); i++)
			if (t.charAt(i) == '?')
				ret++;
		return ret;
	}

	public static boolean match(String s, String t)
	{
		if (s.length() != t.length())
			return false;
		return true;
	}
}