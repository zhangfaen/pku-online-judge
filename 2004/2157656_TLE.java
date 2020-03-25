import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main
{

    public static void main(String[] args) throws IOException
    {
	BufferedReader cin = new BufferedReader(
		new InputStreamReader(System.in));
	PrintWriter out=new PrintWriter(System.out);
	List<String> ls = new ArrayList<String>(10000);
	int n = 0;
	while (true)
	{
	    String s = cin.readLine();
	    if (s == null)
		break;
	    ls.add(s);
	    n++;
	}
	Collections.sort(ls, new Comparator<String>() {

	    public int compare(String o1, String o2)
	    {
		return o1.length() - o2.length();
	    }
	});
	Map<String, Set<String>> msss = new HashMap<String, Set<String>>();
	for (int i = 0; i < n; i++)

	{
	    String s = ls.get(i);
	    for (int j = i + 1; j < n; j++)
	    {
		String t = ls.get(j);
		if (s.length() == t.length())
		    continue;
		if (s.length() > t.length() + 1)
		    break;
		if (check(s, t))
		{
		    Set<String> ss = msss.get(s);
		    if (ss == null)
		    {
			ss = new HashSet<String>();
			msss.put(s, ss);
		    }
		    ss.add(t);
		}
	    }
	}
	int[] memo = new int[n];
	int[] back = new int[n];
	Arrays.fill(back, -1);
	int max=0;
	int ri=0;
	for (int i = n - 1; i >= 0; i--)
	{
	    int re = 1;
	    String s = ls.get(i);
	    for (int j = i + 1; j < n; j++)
	    {
		String t = ls.get(j);
		if (s.length() == t.length())
		    continue;
		if (s.length() > t.length() + 1)
		    break;
		if(msss.get(s)!=null&&msss.get(s).contains(t))
		{
		    if(re<1+memo[j])
		    {
			re=1+memo[j];
			back[i]=j;
		    }
		   
		}
	    }
	    memo[i]=re;
	    if(re>max)
	    {
		max=re;
		ri=i;
	    }
	}
	int cur=ri;
	while(cur!=-1)
	{
	    out.println(ls.get(cur));
	    cur=back[cur];
	}
	out.flush();
    }
    static int[] cnt1 = new int[26];
    static int[] cnt2 = new int[26];

    public static boolean check(String s, String t)
    {
	Arrays.fill(cnt1, 0);
	Arrays.fill(cnt2, 0);
	for (int i = 0; i < s.length(); i++)
	    cnt1[s.charAt(i) - 'a']++;
	for (int j = 0; j < t.length(); j++)
	    cnt2[t.charAt(j) - 'a']++;
	int res = 0;
	for (int i = 0; i < 26; i++)
	    res += Math.abs(cnt1[i] - cnt2[i]);
	if (res != 1)
	    return false;
	return true;
    }
}
