import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Main

{
	public static void main(String [] args)
	{
		Scanner cin=new Scanner(System.in);
		while(cin.hasNextInt())
		{
			int n=cin.nextInt();
			long t=1;
			int sum=1;
			while(true)
			{
				if(t%n==0)
					break;
				t%=n;
				t=t*10+1;
				sum++;
				
			}
			System.out.println(sum);
		}
	}
}