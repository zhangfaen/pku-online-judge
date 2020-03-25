import java.util.*;
import java.io.*;
import java.math.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt();
		while(n--!=0)
		{
			String s=cin.next();
			String t=cin.next();
			s=(new StringBuffer(s).reverse().toString());
			t=(new StringBuffer(t).reverse().toString());
			Integer a=new Integer(s);
			Integer b=new Integer(t);
			Integer c=new Integer(a.intValue()+b.intValue());
			String r=new StringBuffer(String.valueOf(c.intValue())).reverse().toString();
			System.out.println(new Integer(r));
		}
	}
}