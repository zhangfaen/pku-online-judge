import java.util.*;
import java.io.*;
import java.util.regex.*;
public class Main
{
	public static void main(String [] args) throws Exception
	{
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt();
		cin.nextLine();
		while(n--!=0)
		{
			String a=cin.nextLine();
			String b=cin.nextLine();
			String c=cin.nextLine();
			String d=cin.nextLine();
			
			Pattern p=Pattern.compile(" *[^ ]+$");
			Matcher m=p.matcher(a);
			m.find();
			a=m.group().toLowerCase();
			
			m=p.matcher(b);
			m.find();
			b=m.group().toLowerCase();
			
			m=p.matcher(c);
			m.find();
			c=m.group().toLowerCase();
			
			m=p.matcher(d);
			m.find();
			d=m.group().toLowerCase();
			
			String ar,br,cr,dr;
			
			p=Pattern.compile("[aeiou][^aeiou]*$");
			
			m=p.matcher(a);
			if(m.find())
				ar=m.group();
			else
				ar=a;
			
			m=p.matcher(b);
			if(m.find())
				br=m.group();
			else
				br=b;
			
			m=p.matcher(c);
			if(m.find())
				cr=m.group();
			else
				cr=c;
			
			m=p.matcher(d);
			if(m.find())
				dr=m.group();
			else
				dr=d;
			
			
			if(ar.equals(br)&&ar.equals(cr)&&ar.equals(dr))
				System.out.println("perfect");
			else
			if(ar.equals(br)&&cr.equals(dr))
				System.out.println("even");
			else
			if(ar.equals(cr)&&br.equals(dr))
				System.out.println("cross");
			else
			if(ar.equals(dr)&&br.equals(cr))
				System.out.println("shell");
			else
				System.out.println("free");
		}	
	}
}