import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public class Main
{
    static class Node
    {
	Set<Integer> cnt = new HashSet<Integer>();
	Map<Character, Node> mcn = new HashMap<Character, Node>();
    }
    static String[] alls;
    static Node root;
    static String res = "";
    static int from = 0;
    static void insert(Node cur, int who, String s, int index, boolean check)
    {
	if (index == s.length())
	{
	    cur.cnt.add(who);
	    if (check)
	    {
		if (cur.cnt.size() == alls.length)
		{
		    if (s.length() - from >= res.length())
		    {
			String t = s.substring(from);
			if (t.length() > res.length())
			    res = t;
			else if (t.length() == res.length()
				&& t.compareTo(res) < 0)
			{
			    res = t;
			}
		    }
		}
	    }
	    return;
	}
	char c = s.charAt(index);
	cur.cnt.add(who);
	Node next = cur.mcn.get(c);
	if (next == null)
	{
	    next = new Node();
	    cur.mcn.put(c, next);
	}
	insert(next, who, s, index + 1, check);
    }
    public static void main(String[] args) throws IOException
    {
	BufferedReader cin = new BufferedReader(
		new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	while (true)
	{
	    String s = cin.readLine();
	    int n = Integer.parseInt(s);
	    if (n == 0)
		break;
	    res = "";
	    alls = new String[n];
	    for (int i = 0; i < n; i++)
	    {
		alls[i] = cin.readLine();
	    }
	    root = new Node();
	    for (int i = 0; i < n - 1; i++)
	    {
		for (int j = 0; j < alls[i].length() - 1; j++)
		{
		    insert(root, i, alls[i], j, false);
		}
	    }
	    for (int j = 0; j < alls[n - 1].length() - 1; j++)
	    {
		from = j;
		insert(root, n - 1, alls[n - 1], j, true);
	    }
	    if (res.length() == 0)
		out.println("IDENTITY LOST");
	    else
		out.println(res);
	}
	out.flush();
    }
}
