import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		String s = cin.readLine();
		int ts = Integer.parseInt(s);
		while (ts-- > 0)
		{
			s = cin.readLine();
			String[] sa = s.split(" ");
			int pt = Integer.parseInt(sa[0]);
			int wt = Integer.parseInt(sa[1]);
			s = cin.readLine().trim();
			int sum=0;
			for (int i = 0; i < s.length(); i++)
			{
				sum+=pt*pn(s.charAt(i));
				if(i<s.length()-1)
				{
					sum+=needWait(s.charAt(i),s.charAt(i+1))*wt;
				}
			}
			System.out.println(sum);
		}
	}

	public static int pn(char c)
	{
		if (c == ' ')
			return 1;
		if (c >= 'P')
		{
			int re = 0;
			switch (c)
			{
				case 'P':
					re = 1;
					break;
				case 'Q':
					re = 2;
					break;
				case 'R':
					re = 3;
					break;
				case 'S':
					re = 4;
					break;
				case 'T':
					re = 1;
					break;
				case 'U':
					re = 2;
					break;
				case 'V':
					re = 3;
					break;
				case 'W':
					re = 1;
					break;
				case 'X':
					re = 2;
					break;
				case 'Y':
					re = 3;
					break;
				case 'Z':
					re = 4;
					break;
			}
			return re;
		} else
		{
			int fac = c - 'A';
			return fac % 3 + 1;
		}
	}

	public static int needWait(char pc, char nc)
	{
		String s = "";
		s = "ABC";
		if (s.indexOf(pc) >= 0 && s.indexOf(nc) >= 0)
			return 1;
		s = "DEF";
		if (s.indexOf(pc) >= 0 && s.indexOf(nc) >= 0)
			return 1;
		s = "GHI";
		if (s.indexOf(pc) >= 0 && s.indexOf(nc) >= 0)
			return 1;
		s = "JKL";
		if (s.indexOf(pc) >= 0 && s.indexOf(nc) >= 0)
			return 1;
		s = "MNO";
		if (s.indexOf(pc) >= 0 && s.indexOf(nc) >= 0)
			return 1;
		s = "PQRS";
		if (s.indexOf(pc) >= 0 && s.indexOf(nc) >= 0)
			return 1;
		s = "TUV";
		if (s.indexOf(pc) >= 0 && s.indexOf(nc) >= 0)
			return 1;
		s = "WXYZ";
		if (s.indexOf(pc) >= 0 && s.indexOf(nc) >= 0)
			return 1;
		return 0;
	}
}
