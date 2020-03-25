import java.io.*;
import java.util.*;
import java.math.*;
public class Main
{
	public static void main(String [] args)
	{
		Scanner cin=new Scanner(System.in);
		BigInteger b1=new BigInteger("1");
		BigInteger b2=new BigInteger("2");
		BigInteger [] p=new BigInteger[1001];
		p[2]=p[3]=b1;
		while(cin.hasNextInt())
			System.out.println(f(cin.nextInt(),p,b2));
		
	}
	private static BigInteger f(int n,BigInteger [] p,BigInteger b2)
	{
		if(p[n]!=null)
			return p[n];
		return p[n]=f(n-2,p,b2).add(b2.pow(n-3));
	}
}