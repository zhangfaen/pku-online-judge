import java.io.*;
import java.util.*;
import java.math.*;
public class Main
{
    public static void main(String[] args) throws Exception
    {
	BufferedReader cin = new BufferedReader(
		new InputStreamReader(System.in));
	String s = cin.readLine();
	int n = Integer.parseInt(s);
	s = cin.readLine();
	StringTokenizer st = new StringTokenizer(s);
	int[] p = new int[n];
	Set<Integer> all = new HashSet<Integer>();
	for (int i = 0; i < n; i++)
	{
	    p[i] = Integer.parseInt(st.nextToken());
	    all.add(p[i]);
	}
	int res = n;
	Map<Integer,Integer> mii = new HashMap<Integer,Integer>();
	PriorityQueue<Integer> q = new PriorityQueue<Integer>();
	for(int i=0;i<n;i++)
	{
	    Integer pre=mii.get(p[i]);
	    if(pre==null)
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
	    if(mii.size()==all.size())
	    {
		res=Math.min(res, i-q.peek()+1);
	    }
	}
	System.out.println(res);
    }
}
