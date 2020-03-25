import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main
{

    static BufferedReader cin;

    public static void main(String[] args) throws IOException
    {
	cin = new BufferedReader(new InputStreamReader(System.in));
	while (true)
	{
	    String s = cin.readLine();
	    String[] sa = s.split(" ");
	    int n = Integer.parseInt(sa[0]);
	    int k = Integer.parseInt(sa[1]);
	    k = Math.min(k, n - k);
	    long re1 = get(n);
	    long re2 = get(n - k) + get(k);
	    if (re1 > re2)
		System.out.println("0");
	    else
		System.out.println("1");
	}

    }

    public static long get(int n)
    {
	long seed = 2;
	long res = 0;
	while (seed <= n)
	{
	    res += n / seed;
	    seed *= 2;
	}
	return res;
    }

}
