import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.text.NumberFormat;
public class Main
{

	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		while(true)
		{
			String s=cin.next();
			if(s.equals("0"))break;
			int n=0;
			int t=2;
			for(int i=s.length()-1;i>=0;i--)
			{
				n+=(t-1)*(s.charAt(i)-'0');
				t*=2;
			}
			System.out.println(n);
		}
		
	}
}