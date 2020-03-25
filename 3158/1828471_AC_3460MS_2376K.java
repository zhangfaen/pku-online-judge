import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Main
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		String s = cin.readLine();
		String t = cin.readLine();
		int re = 100000;
		for (int i = t.length() - 1; i >= 0; i--)
		{
			String ns = get1s(i) + s;
			boolean ok = isok(ns, t);
			if (ok)
			{
				re = Math.min(re, Math.max(ns.length(), t.length()));
			}
		}
		for (int i = s.length() - 1; i >= 0; i--)
		{
			String nt = get1s(i) + t;
			boolean ok = isok(s, nt);
			if (ok)
			{
				re = Math.min(re, Math.max(s.length(), nt.length()));
			}
		}
		if (re == 100000)
			System.out.println(s.length() + t.length());
		else
			System.out.println(re);
	}
	public static boolean isok(String s, String t)
	{
		for (int i = 0; i < Math.min(s.length(), t.length()); i++)
		{
			char c1 = s.charAt(i);
			char c2 = t.charAt(i);
			if (c1 == '2' && c2 == '2')
				return false;
		}
		return true;
	}
	public static String get1s(int cnt)
	{
		String re = "";
		while (re.length() < cnt)
			re += "1";
		return re;
	}
}