import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main
{

    static BufferedReader cin;
    static int[][] go = { { 2, 4, 6 }, { 2, 6 }, { 0, 1, 3 }, { 2, 4 },
	    { 0, 3, 5 }, { 4, 6 }, { 0, 1, 5 } };

    public static void main(String[] args) throws IOException
    {
	cin = new BufferedReader(new InputStreamReader(System.in));
	String s = cin.readLine();
	int n = Integer.parseInt(s);
	String start = "0123456";
	Map<String, Integer> memo = new HashMap<String, Integer>();
	memo.put(start, 0);
	List<String> q = new LinkedList<String>();
	q.add(start);
	while (!q.isEmpty())
	{
	    String cur = q.remove(0);
	    int step = memo.get(cur);
	    StringBuilder sb = new StringBuilder(cur);
	    int ei = sb.indexOf("0");
	    for (int i = 0; i < go[ei].length; i++)
	    {
		int gi = go[ei][i];
		swap(sb, ei, gi);
		String ns = new String(sb);
		if (memo.containsKey(ns) == false)
		{
		    memo.put(ns, step + 1);
		    q.add(ns);
		}
		swap(sb, ei, gi);
	    }
	}
	while (n-- > 0)
	{
	    s = cin.readLine();
	    if (memo.containsKey(s))
		System.out.println(memo.get(s));
	    else
		System.out.println(-1);
	}
    }

    public static void swap(StringBuilder sb, int i, int j)
    {
	char c = sb.charAt(i);
	sb.setCharAt(i, sb.charAt(j));
	sb.setCharAt(j, c);
    }

}
