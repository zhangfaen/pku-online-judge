import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Main
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner cin = new Scanner(System.in);
		Map<String, Integer> msi = new HashMap<String, Integer>();
		Map<Integer, String> mis = new HashMap<Integer, String>();
		String[] s = "pop, no, zip, zotz, tzec, xul, yoxkin, mol, chen, yax, zac, ceh, mac, kankin, muan, pax, koyab, cumhu, Haab"
			.split(",");
		for (int i = 0; i < s.length; i++)
			msi.put(s[i].trim(), i);
		s = "imix, ik, akbal, kan, chicchan, cimi, manik, lamat, muluk, ok, chuen, eb, ben, ix, mem, cib, caban, eznab, canac, ahau"
			.split(",");
		for (int i = 0; i < s.length; i++)
			mis.put(i, s[i].trim());
		int count = cin.nextInt();
		System.out.println(count);
		for (int num = 0; num < count; num++)
		{
			String cs = cin.next();
			int day = Integer.parseInt(cs.replaceAll("\\.",""));
			int month = msi.get(cin.next());
			int year = cin.nextInt();
			int total = year * 365 + month * 20 + day;
			year = total / 260;
			int t = total % 260;
			int first = t % 13 + 1;
			int second = t % 20;
			System.out.println(first + " " + mis.get(second) + " " + year);
		}
	}
}
