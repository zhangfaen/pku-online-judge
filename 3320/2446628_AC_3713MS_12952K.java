import java.io.*;
import java.util.*;
import java.math.*;
public class Main
{
    public static void main(String[] args) throws Exception
    {
	BufferedReader cin = new BufferedReader(
		new InputStreamReader(System.in));
	int res = 0;
	int n = 0;
	String s = cin.readLine();
	StringTokenizer st = new StringTokenizer(s);
	n = Integer.parseInt(st.nextToken());
	PriorityQueue<Integer> q = new PriorityQueue<Integer>(n);
	int[] p = null;
	Set<Integer> all = new HashSet<Integer>();
	Map<Integer, Integer> ids = new HashMap<Integer, Integer>(n);
	p = new int[n];
	int tag = 0;
	int id = 0;
	while (st.hasMoreTokens())
	{
	    p[tag] = Integer.parseInt(st.nextToken());
	    all.add(p[tag]);
	    if (ids.containsKey(p[tag]) == false)
	    {
		ids.put(p[tag], id++);
	    }
	    tag++;
	}
	while (true)
	{
	    s = cin.readLine();
	    if (s == null)
		break;
	    st = new StringTokenizer(s);
	    while (st.hasMoreTokens())
	    {
		p[tag] = Integer.parseInt(st.nextToken());
		all.add(p[tag]);
		if (ids.containsKey(p[tag]) == false)
		{
		    ids.put(p[tag], id++);
		}
		tag++;
	    }
	}
	for (int i = 0; i < n; i++)
	    p[i] = ids.get(p[i]);
	res = n;
	int total = all.size();
	if (total == n)
	{
	    System.out.println(n);
	    return;
	}
	int[] mii = new int[n];
	int left = 0;
	int cc = 0;
	for (int i = 0; i < n; i++)
	{
	    mii[p[i]]++;
	    if (mii[p[i]] == 1)
	    {
		cc++;
	    }
	    while (mii[p[left]] > 1)
	    {
		mii[p[left]]--;
		left++;
	    }
	    if (cc == total)
		res = Math.min(res, i - left + 1);
	    if (res == total)
		break;
	}
	System.out.println(res);
    }
}
