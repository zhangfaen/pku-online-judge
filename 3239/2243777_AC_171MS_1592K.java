import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main
{

    static BufferedReader cin = new BufferedReader(new InputStreamReader(
	    System.in));
    static PrintWriter out = new PrintWriter(System.out);

    static int n;
    static class Cor implements Comparable<Cor>
    {
	int x, y;

	public Cor(int i, int j)
	{
	    x = i;
	    y = j;
	}

	public int compareTo(Cor o)
	{
	    return this.x - o.x;
	}
    }

    public static void main(String[] args) throws Exception
    {
	while (true)
	{
	    String s = cin.readLine();
	    n = Integer.parseInt(s);
	    if (n == 0)
		break;
	    List<Cor> lc = new ArrayList<Cor>();
	    if (n % 2 == 0)
	    {
		lc = makeeven(n);
		Collections.sort(lc);
	    }
	    else
	    {
		lc = makeeven(n - 1);
		//for (int i=0;i<lc.size();i++)
		//{
		//    Cor cor=lc.get(i);
		//    if (cor.x > cor.y)
		//	cor.x++;
		//    else
		//	cor.y++;
		//}
		lc.add(new Cor(n - 1, n - 1));
		Collections.sort(lc);
	    }
	    for(int i=0;i<lc.size();i++)
	    {
		out.print((lc.get(i).y+1)+" ");
	    }
	    out.println();
	}
	out.flush();
	out.close();
    }

    public static List<Cor> makeeven(int n)
    {
	List<Cor> lc = new ArrayList<Cor>();
	if ((n - 2) % 6 != 0)
	{
	    for (int i = 0; i < n / 2; i++)
	    {
		lc.add(new Cor(i, 2 * i + 1));
	    }
	    for (int i = n / 2; i < n; i++)
	    {
		lc.add(new Cor(i, (2 * i) % n));
	    }
	    return lc;
	}
	if (n % 6 != 0)
	{
	    for (int i = 0; i < n / 2; i++)
	    {
		lc.add(new Cor(i, (n / 2 + 2 * i - 1) % n));
	    }
	    for (int i = n / 2; i < n; i++)
	    {
		lc.add(new Cor(i, (n / 2 + 2 * i + 2) % n));
	    }
	    return lc;
	}
	return null;
    }

}
