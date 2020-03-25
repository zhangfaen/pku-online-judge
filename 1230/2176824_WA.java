import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main
{
    static class Pass implements Comparable<Pass>
    {
	int x, y;
	int id;

	public Pass(int x, int y, int id)
	{
	    this.x = x;
	    this.y = y;
	    this.id = id;
	}

	public int compareTo(Pass o)
	{
	    if (o.y != this.y)
		return o.y - this.y;
	    return this.id - o.id;
	}

	public boolean equals(Object o)
	{
	    Pass p = (Pass) o;
	    return this.id == p.id;
	}

	public String toString()
	{
	    String re = "";
	    re += "id:" + id + " x:" + x + " y:" + y;
	    return re;
	}
    }
  

    public static int minRejects(String[] travel, int seats)
    {
	for (int i = 0; i < end; i++)
	    all[i] = new TreeSet<Pass>();
	int id = 0;
	for (String s : travel)
	{
	    String[] sa = s.split(" +");
	    for (String t : sa)
	    {
		String[] ta = t.split("-");
		int x = Integer.parseInt(ta[0]);
		int y = Integer.parseInt(ta[1]);
		Pass pass = new Pass(x, y, id++);
		for (int i = x; i < y; i++)
		    all[i].add(pass);
	    }
	}
	int res = 0;
	for (int i = 1; i < end; i++)
	{
	    if (all[i].size() > seats)
	    {
		int d = all[i].size() - seats;
		res += d;
		int cnt = 0;
		for (Pass p : (TreeSet<Pass>) all[i])
		{
		    for (int j = i + 1; j < p.y; j++)
			all[j].remove(p);
		    cnt++;
		    if (cnt == d)
			break;
		}
	    }
	}
	return res;
    }

    static BufferedReader cin = new BufferedReader(new InputStreamReader(
	    System.in));
    static int end = 111;
    static Set[] all = new TreeSet[end];
    public static void main(String[] args) throws IOException
    {
	String s = cin.readLine();
	int ts = Integer.parseInt(s);
	while (ts-- > 0)
	{
	    s = cin.readLine();
	    String[] sa = s.split(" ");
	    int n = Integer.parseInt(sa[0]);
	    int k = Integer.parseInt(sa[1]);
	    String re = "";
	    for (int i = 0; i < n; i++)
	    {
		s = cin.readLine();
		sa = s.split(" ");
		int x = Integer.parseInt(sa[0])+1;
		int y = Integer.parseInt(sa[2]) + 2;
		if (i != n - 1)
		    re += x + "-" + y + " ";
		else
		    re += x + "-" + y;
	    }
	    int res=minRejects(new String[] {re},k);
	    System.out.println(res);
	}
    }
}
