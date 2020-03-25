import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
public class Main
{
    static int c;
    static int ra = -1, rb = -1;
    public static void main(String[] args) throws Exception
    {
	BufferedReader cin = new BufferedReader(
		new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	while (true)
	{
	    String s = cin.readLine();
	    if (s == null)
		break;
	    int n = Integer.parseInt(s);
	    int total = 0;
	    Map<Integer, Integer> mii = new HashMap<Integer, Integer>();
	    int end = (int) Math.sqrt(n);
	    for (int i = 2; i < end + 2; i++)
	    {
		if (n % i == 0)
		{
		    int cnt = 0;
		    while (n % i == 0)
		    {
			cnt++;
			n /= i;
		    }
		    mii.put(i, cnt);
		    total += cnt;
		}
	    }
	    if (n > 1)
	    {
		mii.put(n, 1);
		total++;
	    }
	    BigInteger bi = fab(total);
	    for (int key : mii.keySet())
	    {
		bi = bi.divide(fab(mii.get(key)));
	    }
	    System.out.println(total+" "+bi);
	}
    }
    public static BigInteger fab(int cnt)
    {
	BigInteger re = new BigInteger("1");
	for (int i = 2; i <= cnt; i++)
	    re = re.multiply(new BigInteger("" + i));
	return re;
    }
}
