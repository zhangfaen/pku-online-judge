import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main
{

    static BufferedReader cin = new BufferedReader(new InputStreamReader(
	    System.in));

    public static void main(String[] args) throws IOException
    {
	String s = cin.readLine();
	int ts = Integer.parseInt(s);
	while (ts-- > 0)
	{
	    s = cin.readLine();
	    int n = Integer.parseInt(s);
	    int[] p = new int[n + 1];
	    for (int i = 0; i < n - 1; i++)
	    {
		s = cin.readLine().trim();
		String[] sa = s.split(" +");
		int f = Integer.parseInt(sa[0]);
		int c = Integer.parseInt(sa[1]);
		p[c] = f;
	    }
	    s = cin.readLine().trim();
	    String[] sa = s.split(" +");
	    int x = Integer.parseInt(sa[0]);
	    int y = Integer.parseInt(sa[1]);
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
