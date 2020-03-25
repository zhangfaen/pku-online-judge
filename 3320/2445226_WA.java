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
	Map<Integer, Integer> mii = new HashMap<Integer, Integer>();
	PriorityQueue<Integer> q = new PriorityQueue<Integer>();
	int[] p = null;
	Set<Integer> all = new HashSet<Integer>();
	try
	{
	    String s = cin.readLine();
	    n = Integer.parseInt(s);
	    p = new int[n];
	    int tag=0;
	    while (true)
	    {
		s = cin.readLine();
		if (s == null)
		    break;
		StringTokenizer st = new StringTokenizer(s);
		while(st.hasMoreTokens())
		{
		    p[tag]=Integer.parseInt(st.nextToken());
		    all.add(p[tag++]);
		}
	    }
	    res = n;
	}
	catch (Exception e)
	{
	}
	for (int i = 0; i < n; i++)
	{
	    Integer pre = mii.get(p[i]);
	    if (pre == null)
	    {
		mii.put(p[i], i);
		q.add(i);
	    }
	    else
	    {
		q.add(i);
		mii.put(p[i], i);
		q.remove(pre);
	    }
	    if (mii.size() == all.size())
	    {
		res = Math.min(res, i - q.peek() + 1);
	    }
	}
	System.out.println(res);
    }
}
