import java.io.*;
import java.util.*;
public class Main
{

	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		while(true)
		{
			String s=cin.next();
			if(s.equals("-1"))break;
			String t=cin.next();
			System.out.print("appx("+s+","+t+") = ");
			int a=f(s,t)*2;
			int b=(s.length()+t.length());
			int yue=yue(a,b);
			a/=yue;
			b/=yue;
			if(a==0)
			{
				System.out.println(0);
			}
			else
				if(a==b)
					System.out.println(1);
				else System.out.println(a+"/"+b);
		}
	
	}
	private static int yue(int a,int b)
	{
		if(a<b)
		{
			int t=a;a=b;b=t;
		}
		while(b!=0)
		{
			int t=a%b;
			a=b;
			b=t;
		}
		return a;
	}
	private static int f(String s,String t)
	{
		int max=-1;
		String b="";
		for(int i=0;i<s.length();i++)
		{
			int tmax=g(s,b+t);
			if(tmax>max)
				max=tmax;
			b+=(char)1000;
		}
		b="";
		for(int i=1;i<t.length();i++)
		{
			int tmax=g(b+s,t);
			if(tmax>max)
				max=tmax;
			b+=(char)1000;
		}
		return max;	
	}
	private static int g(String s,String t)
	{
		int sum=0;
		for(int i=0;i<s.length()&&i<t.length();i++)
		{
			if(s.charAt(i)==t.charAt(i))
				sum++;
		}
		return sum;
	}
}