import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main
{

    static BufferedReader cin;
    static int n, m;
    static int[][] cost;
    static int[][] income;
    static int[][] memo;

    public static void main(String[] args) throws IOException
    {

	cin = new BufferedReader(new InputStreamReader(System.in));
	while (true)
	{
	    String s = cin.readLine();
	    int n = Integer.parseInt(s);
	    if (n == 0)
		break;
	    BigInteger bi = new BigInteger("0");
	    s = cin.readLine();
	    for (int i = 0; i < s.length(); i++)
	    {

		out: for (char c = 'A'; c < s.charAt(i); c++)
		{
		    for (int j = 0; j <= i - 1; j++)
			if (c == s.charAt(j))
			    continue out;
		    bi = bi.add(calc(n - i - 1, 26 - i - 1));
		}
	    }
	    System.out.println(bi);
	}
    }

    public static BigInteger calc(int cnt, int ci)
    {
	BigInteger bi = new BigInteger("1");
	for (int i = ci, j = 0; j < cnt; j++, i--)
	    bi = bi.multiply(new BigInteger("" + i));
	return bi;
    }
}
