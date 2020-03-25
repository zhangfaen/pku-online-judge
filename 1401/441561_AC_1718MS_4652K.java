import java.util.*;
public class Main
{
	public static void main(String [] args)
	{
		Scanner cin=new Scanner(System.in);
		int T=cin.nextInt();
		while(T--!=0)
		{
			long n=cin.nextLong();
			System.out.println(f(n));
			
		}
	}
	static long f(long n)
	{
	    long k = 5;
	    long r = 0;
	    while( n >= k)
	    {
	        r += n/k;
	        k *= 5;
	    }
	    return r;
	}
	
}
