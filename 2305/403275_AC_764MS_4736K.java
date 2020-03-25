import java.io.*;
import java.util.*;
import java.math.*;
public class Main
{
	public static void main(String args[]) throws Exception
	{
		Scanner cin=new Scanner(System.in);
		while(true)
		{
			int b=cin.nextInt();
			if(b==0)break;
			String p=cin.next();
			String m=cin.next();
			BigInteger P=new BigInteger(p,b);
			BigInteger M=new BigInteger(m,b);
			BigInteger R=P.mod(M);
			System.out.println(R.toString(b));
		}
		
	}
}
