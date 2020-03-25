import java.io.IOException;
import java.util.Scanner;

public class Main
{

    // static BufferedReader cin = new BufferedReader(new InputStreamReader(
    // System.in));

    public static void main(String[] args) throws IOException
    {
	Scanner cin = new Scanner(System.in);
	while (true)
	{
	    long n = cin.nextLong();
	    long m = cin.nextLong();
	    if (m + n == 0)
		break;
	    long s=m+n;
	    long k=Math.min(m, n);
	    long re=1;
	    for(int i=1;i<=k;i++)
	    {
		re*=s--;
		re/=i;
	    }
	    System.out.println(re);
	}
    }
}
