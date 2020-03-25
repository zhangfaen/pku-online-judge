import java.util.*;
import java.io.*;
public class Main
{
	private static int n;
	private static Scanner cin;
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		cin=new Scanner(System.in);
		int tag=0;
		while(true)
		{
			n=cin.nextInt();
			if(n==0)break;
			tag++;
			System.out.println("SET "+tag);
			f(0);
		}
	}
	private static void f(int d)
	{
		if(d==n)
			return;
		if(n-d>=2)
		{
			String s=cin.next();
			String t=cin.next();
			System.out.println(s);
			f(d+2);
			System.out.println(t);
		}
		else
		{
			System.out.println(cin.next());
		}
			
	}
}

