import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main
{

    static BufferedReader cin;

    public static void main(String[] args) throws IOException
    {
	cin = new BufferedReader(new InputStreamReader(System.in));
	String s = cin.readLine();
	String[] sa = s.split(" ");
	int p = Integer.parseInt(sa[0]);
	int t = Integer.parseInt(sa[1]);
	Map<Integer, Set> mis = new HashMap<Integer, Set>();
	for(int i=1;i<=p;i++)
	    mis.put(i, new HashSet());
	while (true)
	{
	    s = cin.readLine();
	    if(s==null)break;
	    sa = s.split(" ");
	    int i = Integer.parseInt(sa[0]);
	    int j = Integer.parseInt(sa[1]);
	    if (mis.containsKey(i) == false)
	    {
		Set<Integer> si = new HashSet<Integer>();
		si.add(j);
		mis.put(i, si);
	    }
	    else
	    {
		mis.get(i).add(j);
	    }
	}
	Set<Set> ss=new HashSet<Set>();
	for(int key:mis.keySet())
	    ss.add(mis.get(key));
	System.out.println(ss.size());
    }

}
