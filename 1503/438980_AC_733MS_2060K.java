import java.io.*;
import java.util.*;
import java.math.BigInteger;
public class Main
{

	public static void main(String [] args)throws Exception
	{

		Scanner cin=new Scanner(System.in);
		BigInteger sum=new BigInteger("0");
		while(true)
		{
			String s=cin.next();
			if(s.equals("0"))
				break;
			sum=sum.add(new BigInteger(s));
		}
		System.out.println(sum);
	}
}