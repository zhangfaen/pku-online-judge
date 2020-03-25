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
			BigInteger N=new BigInteger(Integer.toString(n));
			String s="1";
			while(true)
			{
				BigInteger bs=new BigInteger(s);
				if(bs.mod(N).equals(new BigInteger("0")))
				{
					System.out.println(s);
					break;
				}
				s+='1';
				
			}
		}
	}
}