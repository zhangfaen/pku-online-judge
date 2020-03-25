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
    static HashSet inter(HashSet a, HashSet b)
    {
	HashSet c=new HashSet();
	for(Object o:a)
	    if(b.contains(o))
		c.add(o);
	return c;
    }
    public static void main(String[] args) throws Exception
    {
	String s = cin.readLine();
	int ts = Integer.parseInt(s);
	HashSet zero=new HashSet();
	while (ts-- > 0)
	{
	    s = cin.readLine();
	    int n = Integer.parseInt(s);
	    LinkedList<HashSet> stack = new LinkedList<HashSet>();
	    while (n-- > 0)
	    {
		s = cin.readLine().trim();
		if (s.charAt(0)=='P')
		{
		    stack.addFirst(zero);
		}
		else if (s.charAt(0)=='D')
		{
		    HashSet hs=stack.removeFirst();
		    stack.addFirst(hs);
		    stack.addFirst(hs);
		}
		else if (s.charAt(0)=='A')
		{
		    HashSet hsa=stack.removeFirst();
		    HashSet hsb=stack.removeFirst();
		    HashSet hsc=new HashSet();
		    hsc.addAll((Collection)hsb);
		    hsc.add(hsa);
		    stack.addFirst(hsc);
		}
		else if (s.charAt(0)=='U')
		{
		    HashSet hsa=stack.removeFirst();
		    HashSet hsb=stack.removeFirst();
		    HashSet hsc=new HashSet();
		    hsc.addAll((Collection)hsa);
		    hsc.addAll((Collection)hsb);
		    stack.addFirst(hsc);
		}
		else if (s.charAt(0)=='I')
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
	out.close();
    }
   

}
