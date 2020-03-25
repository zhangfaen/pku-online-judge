import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
public class Main
{
	static char[] sc;
	static char[] tc;
	static HashMap<String, Byte> hsb = new HashMap<String, Byte>(50000);
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner cin = new Scanner(System.in);
		String s = cin.nextLine();
		String t = cin.nextLine();
		sc = s.toCharArray();
		tc = t.toCharArray();
		int[] p = new int[s.length() + t.length()];
		int tag = 0;
		for (int i = 0; i < s.length(); i++)
		{
			int tnum = i;
			tnum = (1 << 20 | tnum);
			p[tag++] = tnum;
		}
		for (int j = 0; j < t.length(); j++)
		{
			int tnum = j;
			p[tag++] = tnum;
		}
		qsort(p, 0, p.length - 1);
		// System.out.println(Arrays.toString(p));
		/*
		 * for(int i=0;i<p.length;i++) System.out.println(gets(p[i]));
		 */
		int max = 0;
		tag = 1;
		for (int i = 0; i < p.length - 1; i++)
		{
			int tag1 = 1 << 20 & p[i];
			int tag2 = 1 << 20 & p[i + 1];
			if (tag1 != tag2)
			{
				int tre = pref(p[i], p[i + 1]);
				if (tre > max)
					max = tre;
			}
		}
		System.out.println(max);
	}
	public static void qsort(int[] p, int l, int r)
	{
		if (l < r)
		{
			int mid = partion(p, l, r);
			qsort(p, l, mid - 1);
			qsort(p, mid + 1, r);
		}
	}
	private static int partion(int[] a, int p, int r)
	{
		int x = a[r];
		int i = p - 1;
		for (int j = p; j <= r - 1; j++)
		{
			if (compare(a[j], x) <= 0)
			{
				i++;
				int t = a[j];
				a[j] = a[i];
				a[i] = t;
			}
		}
		int t = a[i + 1];
		a[i + 1] = a[r];
		a[r] = t;
		return i + 1;
	}
	public static int compare(int a, int b)
	{
		int tag1 = 1 << 20 & a;
		char[] ac = tag1 != 0 ? sc : tc;
		int tag2 = 1 << 20 & b;
		char[] bc = tag2 != 0 ? sc : tc;
		int index1 = ((1 << 20) - 1) & a;
		int index2 = ((1 << 20) - 1) & b;
		int index1s = index1;
		int index2s = index2;
		int flag1 = tag1 != 0 ? 1 : 0;
		int flag2 = tag2 != 0 ? 1 : 0;
		while (index1 < ac.length && index2 < bc.length)
		{
			String key = "" + flag1 + flag2 + index1 + index2;
			Byte bkey = hsb.get(key);
			if (bkey != null)
			{
				//System.out.println("adf");
				return bkey;
			}
			if (ac[index1] < bc[index2])
			{
				hsb.put("" + flag1 + flag2 + index1s + index2s, (byte) (-1));
				return -1;
			} else if (ac[index1] > bc[index2])
			{
				hsb.put("" + flag1 + flag2 + index1s + index2s, (byte) (1));
				return 1;
			}
			++index1;
			++index2;
		}
		if (index1 == ac.length && index2 == bc.length)
		{
			hsb.put("" + flag1 + flag2 + index1s + index2s, (byte) (0));
			return 0;
		}
		if (index1 == ac.length)
		{
			hsb.put("" + flag1 + flag2 + index1s + index2s, (byte) (-1));
			return -1;
		}
		hsb.put("" + flag1 + flag2 + index1s + index2s, (byte) (1));
		return 1;
	}

	public static String gets(int a)
	{
		int tag = 1 << 20 & a;
		char[] ac = tag != 0 ? sc : tc;
		int index1 = ((1 << 20) - 1) & a;
		String re = "";
		for (; index1 < ac.length; index1++)
			re += ac[index1];
		return re;
	}
	public static int pref(int a, int b)
	{
		int tag = 1 << 20 & a;
		char[] ac = tag != 0 ? sc : tc;
		tag = 1 << 20 & b;
		char[] bc = tag != 0 ? sc : tc;
		int index1 = ((1 << 20) - 1) & a;
		int index2 = ((1 << 20) - 1) & b;
		int re = 0;
		while (index1 < ac.length && index2 < bc.length)
		{
			if (ac[index1] == bc[index2])
				re++;
			else
				return re;
			++index1;
			++index2;
		}
		return re;
	}
}
