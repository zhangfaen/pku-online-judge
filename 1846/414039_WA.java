import java.io.*;
import java.util.*;
import java.math.*;
public class Main
{
	public static void main(String args[]) throws Exception
	{
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt();
		BigInteger t=new BigInteger("1");
		for(int i=n-1;i>=3;i--)
		{
			t=t.multiply(new BigInteger(String.valueOf(i)));
		}
		System.out.println(t);
		
	
		
	}
}
