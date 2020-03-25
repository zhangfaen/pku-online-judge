import java.util.*;
import java.util.regex.*;
public class Main
{
	public static void main(String [] args)
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
			
			Pattern p=Pattern.compile(" ?([^ ]+)$");
			a=f(p,a);
			b=f(p,b);
			c=f(p,c);
			d=f(p,d);
			String ar,br,cr,dr;			
			p=Pattern.compile("[aeiou][^aeiou]*$");			
			ar=g(p,a);
			br=g(p,b);			
			cr=g(p,c);
			dr=g(p,d);
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
	static String f(Pattern p,String s)
	{
		Matcher m=p.matcher(s);
		m.find();
		return m.group(1).toLowerCase();
	}
	static String g(Pattern p,String s)
	{
		Matcher m=p.matcher(s);
		if(m.find())
			return m.group();
		else
			return s;
	}
}