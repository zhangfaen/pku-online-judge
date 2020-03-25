import java.util.*;
import java.math.*;
public class Main
{
	public static void main(String [] args)
	{
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt();
		StringBuffer b1=new StringBuffer(n+1);
		StringBuffer b2=new StringBuffer(n+1);
		for(int i=0;i<n;i++)
		{
			b1.append(cin.next());
			b2.append(cin.next());
		}
		BigInteger bi1=new BigInteger(b1.toString());
		BigInteger bi2=new BigInteger(b2.toString());
		String s=(bi1.add(bi2)).toString();
		for(int i=0;i<n-s.length();i++)
			System.out.print("0");
		System.out.println(s);
	}
}