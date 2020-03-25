import java.io.*;
import java.util.*;
import java.math.*;
import java.util.Scanner;
public class Main
{
	public static void main(String[] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		int ts=in.nextInt();
		in.nextLine();
		while(ts-->0)
		{
			String s=in.nextLine().trim();
			int ie=s.indexOf('=');
			String ps=s.substring(0,ie);
			String qs=s.substring(ie+1,s.length());
			ps=ps.replaceAll("-", "+-");
			qs=qs.replaceAll("-","+-");
			String [] sa=ps.split("\\+");
			int a=0,b=0;
			for(String t:sa)
			{
				if(t.trim().equals(""))
					continue;
				t=t.trim();
				if(t.indexOf("x")>=0)
				{
					String num=t.substring(0,t.length()-1);
					if(num.length()==0)
						num="1";
					else if(num.equals("-")) num="-1";
					a+=Integer.parseInt(num);
				}
				else
					b+=Integer.parseInt(t);
			}
			sa=qs.split("\\+");
			for(String t:sa)
			{
				t=t.trim();
				if(t.equals(""))
					continue;
				if(t.indexOf("x")>=0)
				{
					String num=t.substring(0,t.length()-1);
					if(num.length()==0)
						num="1";
					else if(num.equals("-")) num="-1";
					a-=Integer.parseInt(num);
				}
				else
					b-=Integer.parseInt(t);
			}
			if(a==0&&b==0)
				System.out.println("IDENTITY");
			else if(a==0&&b!=0)
				System.out.println("IMPOSSIBLE");
			else
			{
				if((-b)%a==0)
					System.out.println(-b/a);
				else
				{
					int d=-b/a;
					if(d<0)
						System.out.println(d-1);
					else
						System.out.println(d);
				}
			}
		}
	}
}
