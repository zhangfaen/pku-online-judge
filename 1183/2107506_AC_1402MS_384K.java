import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Main
{

    static BufferedReader cin;

    public static void main(String[] args) throws IOException
    {
	cin = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	String s=cin.readLine();
	long t=Long.parseLong(s);
	long a=t*t+1;
	long start=(long)Math.sqrt(a);
	long re=Long.MAX_VALUE;
	for(long i=start;i>=1;i--)
	{
	    if(a%i==0)
	    {
		long d=i+t+a/i+t;
		re=Math.min(re, d);
	    }
	}
	out.println(re);
	out.close();
    }
    

}
