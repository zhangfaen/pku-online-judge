import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main
{

    public static void main(String[] args) throws IOException
    {
	BufferedReader cin = new BufferedReader(
		new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	List[] map = new ArrayList[21];
	List[] src = new ArrayList[21];
	for (int i = 0; i < 21; i++)
	{
	    map[i] = new ArrayList(10000);
	    src[i] = new ArrayList(10000);
	}

	int maxLen = 0;
	while (true)
	{
	    String s = cin.readLine();
	    if (s == null)
		break;
	    src[s.length()].add(s);
	    map[s.length()].add(sortS(s));
	    maxLen = Math.max(maxLen, s.length());
	}
	Set[] pool = new HashSet[maxLen + 1];
	for (int i = 1; i < maxLen + 1; i++)
	    pool[i] = new HashSet();
	for (int i = 1; i < maxLen; i++)
	{
	    for (int j = 0; j < map[i].size(); j++)
		for (int k = 0; k < map[i + 1].size(); k++)
		    if (check((String) map[i].get(j), (String) map[i + 1]
			    .get(k)))
			pool[i].add(j * 10000 + k);
	}

	int[][] memo = new int[maxLen + 1][];
	int[][] back = new int[maxLen + 1][];
	for (int i = 1; i <= maxLen; i++)
	{
	    memo[i] = new int[map[i].size()];
	    back[i] = new int[map[i].size()];
	    Arrays.fill(back[i], -1);
	}
	int max = 1;
	int ri = maxLen, rj = 0;
	Arrays.fill(memo[maxLen], 1);
	for (int i = maxLen - 1; i >= 1; i--)
	{
	    for (int j = 0; j < map[i].size(); j++)
	    {
		int best = 1;
		for (int k = 0; k < map[i + 1].size(); k++)
		{
		    if (pool[i].contains(j * 10000 + k))
		    {
			if (best < 1 + memo[i + 1][k])
			{
			    best = 1 + memo[i + 1][k];
			    back[i][j] = k;
			}
		    }
		}
		memo[i][j] = best;
		if (best > max)
		{
		    max = best;
		    ri = i;
		    rj = j;
		}
	    }
	}
	int ci = ri, cj = rj;
	while (true)
	{
	    out.println(src[ci].get(cj));
	    if (back[ci][cj] == -1)
		break;
	    cj = back[ci][cj];
	    ci++;
	}
	// out.println(max);
	out.flush();
    }
    static int[] cnt1 = new int[26];
    static int[] cnt2 = new int[26];

    public static boolean check(String s, String t)
    {
	boolean find = false;
	int i, j;
	for (i = 0, j = 0; j < t.length() && i < s.length(); i++, j++)
	    if (s.charAt(i) == t.charAt(j))
		continue;
	    else
	    {
		if (find)
		    return false;
		find = true;
		i--;
	    }
	if (find == false || i == s.length() && j == t.length())
	    return true;
	return false;
	// Arrays.fill(cnt1, 0);
	// Arrays.fill(cnt2, 0);
	// for (int i = 0; i < s.length(); i++)
	// cnt1[s.charAt(i) - 'a']++;
	// for (int j = 0; j < t.length(); j++)
	// cnt2[t.charAt(j) - 'a']++;
	// int res = 0;
	// for (int i = 0; i < 26; i++)
	// res += Math.abs(cnt1[i] - cnt2[i]);
	// if (res != 1)
	// return false;
	// return true;
    }

    public static String sortS(String s)
    {
	char[] a = s.toCharArray();
	Arrays.sort(a);
	return new String(a);
    }
}