import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Main
{

    static BufferedReader cin = new BufferedReader(new InputStreamReader(
	    System.in));
    static List<Integer> q = new LinkedList<Integer>();

    static int nextInt() throws IOException
    {
	int re = 0;
	if (q.isEmpty() == false)
	{
	    re = q.remove(0);
	}
	else
	{
	    while (q.isEmpty())
	    {
		String s = null;
		s = cin.readLine();
		if (s == null)
		{
		    return -1;
		}
		s = s.trim();
		String[] sa = s.split(" +");
		for (int i = 0; i < sa.length; i++)
		    if (sa[i].length() > 0)
			q.add(Integer.parseInt(sa[i]));
	    }
	    re = q.remove(0);
	}
	return re;
    }
    public static void main(String[] args) throws IOException
    {
	//String s = cin.readLine();
	int ts = nextInt();
	while (ts-- > 0)
	{
	   // s = cin.readLine();
	    int n = nextInt();
	    int[] p = new int[n + 1];
	    for (int i = 0; i < n - 1; i++)
	    {
		//s = cin.readLine().trim();
		//String[] sa = s.split(" +");
		int f = nextInt();
		int c = nextInt();
		p[c] = f;
	    }
	   // s = cin.readLine().trim();
	   // String[] sa = s.split(" +");
	    int x = nextInt();
	    int y = nextInt();
	    Set<Integer> xfs = new HashSet<Integer>();
	    int cur = x;
	    while (cur != 0)
	    {
		xfs.add(cur);
		cur = p[cur];
	    }
	    cur=y;
	    while(cur!=0)
	    {
		if(xfs.contains(cur))
		{
		    System.out.println(cur);
		    break;
		}
		cur=p[cur];
	    }
	    
	}
    }
}
