import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

public class Main
{

    static BufferedReader cin = new BufferedReader(new InputStreamReader(
	    System.in));
    static PrintWriter out=new PrintWriter(System.out);
    static void copy(HashSet src, HashSet dest)
    {
	for(Object o:src)
	{
	    HashSet nhs=new HashSet();
	    dest.add(nhs);
	    copy((HashSet)o,nhs);
	}
    }
    static HashSet inter(HashSet a, HashSet b)
    {
	HashSet c=new HashSet();
	for(Object o:a)
	    if(b.contains(o))
		c.add(o);
	return c;
    }
    public static void main(String[] args) throws IOException
    {
	String s = cin.readLine();
	int ts = Integer.parseInt(s);
	while (ts-- > 0)
	{
	    s = cin.readLine();
	    int n = Integer.parseInt(s);
	    LinkedList<HashSet> stack = new LinkedList<HashSet>();
	    while (n-- > 0)
	    {
		s = cin.readLine().trim();
		if (s.equals("PUSH"))
		{
		    stack.addFirst(new HashSet());
		}
		else if (s.equals("DUP"))
		{
		    HashSet hs=stack.removeFirst();
		    HashSet nhs=new HashSet();
		    copy(hs,nhs);
		    stack.addFirst(hs);
		    stack.addFirst(nhs);
		}
		else if (s.equals("ADD"))
		{
		    HashSet hsa=stack.removeFirst();
		    HashSet hsb=stack.removeFirst();
		    hsb.add(hsa);
		    stack.addFirst(hsb);
		}
		else if (s.equals("UNION"))
		{
		    HashSet hsa=stack.removeFirst();
		    HashSet hsb=stack.removeFirst();
		    hsb.addAll((Collection)hsa);
		    stack.addFirst(hsb);
		}
		else if (s.equals("INTERSECT"))
		{
		    HashSet hsa=stack.removeFirst();
		    HashSet hsb=stack.removeFirst();
		    HashSet hsc=inter(hsa,hsb);
		    stack.addFirst(hsc);
		}
		else {
		    n++;
		    continue;
		}
		out.println(stack.getFirst().size());
	    }
	    out.println("***");
	}
	out.flush();
    }
   

}
