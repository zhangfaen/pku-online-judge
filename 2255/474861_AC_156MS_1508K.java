import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream inf=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext())
		{
			String pre=cin.next();
			String in=cin.next();
			f(pre,in);
			System.out.println();
		}	
		
	}
	private static void f(String pre,String in)
	{
		if(pre.length()==0)
			return;
		if(pre.length()==1)
		{
			System.out.print(pre);
			return;
		}
		char c=pre.charAt(0);
		pre=pre.substring(1);
		
		String leftin=in.substring(0,in.indexOf(c+""));
		String rightin=in.substring(in.indexOf(c+"")+1);
		String leftpre=pre.substring(0,leftin.length());
		String rightpre=pre.substring(leftin.length());
		f(leftpre,leftin);
		f(rightpre,rightin);
		System.out.print(c);
	}
}