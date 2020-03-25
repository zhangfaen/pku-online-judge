import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
public class Main
{
	public static void main(String[] args)
	{
		Scanner cin = new Scanner(System.in);
		while (true)
		{
			String s = cin.nextLine();
			if (s.equals("#"))
				break;
			char[] map = s.toCharArray();
			int n = s.length();
			double re = 0;
			for (int i = 0; i < n; i++)
			{
				char c = map[i];
				if (c == '.')
					re += 1.0 / n;
				if (c == '|')
				{
					if (left(i - 1, map))
						re += 0.5 / n;
					if (right(i + 1, map))
						re += 0.5 / n;
				}
				if (c == '/' && left(i - 1, map))
					re += 1.0 / n;
				if (c == '\\' && right(i + 1, map))
					re += 1.0 / n;
			}
			System.out.printf("%d\n",(int)( re * 100));
		}
	}
	public static boolean right(int si, char[] map)
	{
		if (si >= map.length)
			return true;
		boolean ok = true;
		while (si < map.length)
		{
			if (map[si] == '.')
			{
				break;
			} else if (map[si] == '_')
				si++;
			else if (map[si] == '|' || map[si] == '/')
			{
				ok = false;
				break;
			}
		}
		return ok;
	}
	public static boolean left(int si, char[] map)
	{
		if (si < 0)
			return true;
		boolean ok = true;
		while (si >= 0)
		{
			if (map[si] == '.')
			{
				break;
			} else if (map[si] == '_')
				si--;
			else if (map[si] == '|' || map[si] == '\\')
			{
				ok = false;
				break;
			}
		}
		return ok;
	}
}
