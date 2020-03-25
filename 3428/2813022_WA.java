

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		String format = cin.readLine();
		List<String> ls = new ArrayList<String>();
		while (true)
		{
			String s = cin.readLine();
			if (s == null)
				break;
			ls.add(s);
		}
		int argc = check(format);
		if (argc == -1 || argc != ls.size())
		{
			System.out.println("ERROR");
			return;
		}
		StringBuilder sb = new StringBuilder();
		int j = 0;
		for (int i = 0; i < format.length(); i++)
		{
			char c = format.charAt(i);
			if (c == '%')
			{
				i++;
				char d = format.charAt(i);
				if (d == 'd')
				{
					try
					{
						int v = Integer.parseInt(ls.get(j));
						sb.append("" + v);
					} catch (Exception e)
					{
						System.out.println("ERROR");
						return;
					}
				}
				if (d == 's')
					sb.append(ls.get(j));
				if (d == '%')
					sb.append(d);
				if (d != '%')
					j++;
			} else
				sb.append(c);
		}
		System.out.println(sb);
	}

	public static int check(String format)
	{
		int cnt = 0;
		for (int i = 0; i < format.length(); i++)
		{
			char c = format.charAt(i);
			if (c == '%')
			{
				if (i + 1 >= format.length())
					return -1;
				i++;
				char n = format.charAt(i);
				if (n == '%' || n == 's' || n == 'd')
					;
				else
					return -1;
				if (n != '%')
					cnt++;
			}
		}
		return cnt;
	}
}
