import java.io.*;
import java.util.*;
import java.math.*;
public class Main
{
	public static void main(String args[]) throws Exception
	{
	//	InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		int num;
		String s="";
		int max=11,min=0;
		boolean tag=false;
		while(true)
		{	
			num=cin.nextInt();
			if(num!=0)
			{
				s="";
				s+=cin.next();
				s+=" ";
				s+=cin.next();
			}
			else
				break;
			if(s.equals("too high"))
				max=num;
			if(s.equals("too low"))
				min=num;
			if(max<=min+1)
			{
				tag=true;
			}
			if(s.equals("right on"))
			{
				if(num<max&&num>min&&tag==false)
					System.out.println("Stan may be honest");
				else
					System.out.println("Stan is dishonest");
				tag=false;
				max=11;min=0;
			}
		}
	}
}
