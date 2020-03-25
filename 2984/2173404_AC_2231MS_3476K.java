import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main
{

    static BufferedReader cin = new BufferedReader(new InputStreamReader(
	    System.in));

    public static void main(String[] args) throws IOException
    {
	String s = cin.readLine();
	BigInteger bi = new BigInteger(s);
	int bbc = bi.bitCount();
	BigInteger re = new BigInteger("2").pow(bbc).subtract(
		new BigInteger("1"));
	System.out.println(re);

    }
}
