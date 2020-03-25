import java.io.*;
import java.util.*;
import java.math.BigInteger;
public class Main
{

	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		while(true)
		{
			String big=cin.next();
			BigInteger n=new BigInteger(big);
			if(n.compareTo(new BigInteger("0"))==0)break;
			while(n.compareTo(new BigInteger("10"))>=0)
			{
				String s=n.toString();
				BigInteger t=new BigInteger("0");
				for(int i=0;i<s.length();i++)
				{
					t=t.add(new BigInteger(""+(s.charAt(i)-'0')));
				}
				n=t;
			}
			System.out.println(n);
		}
		
	}
}