import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.math.*;
public class Main
{
	static long[] p = new long[65];
	static boolean first;
	static String res="";
	public static void main(String[] args) throws Exception
	{
		p[0] = 1L;
		for (int i = 1; i < 65; i++)
			p[i] = 2 * p[i - 1];
		Scanner cin = new Scanner(System.in);
		while(true)
		{
			first=true;
			long n=cin.nextLong();
			if(n==0)
				break;
			if(n==1)
			{
				System.out.println("{ }");
				continue;
			}
			res="";
			get(n,62);
			System.out.println("{ "+res.substring(0,res.length()-2)+" }");
		}
		
	}
	public static void get(long n, int d)
	{
		if(d==0)
		{
			if(n==2)
			{
					res+=1+", ";
			}
			return;
		}
	
		if (n <= p[d])
		{
			get(n, d - 1);
			return;
		}
		if(n>p[d])
		{
			
			get(n-p[d],d-1);
			res+=new BigInteger("3").pow(d)+", ";
			
			
		}
	}
}
