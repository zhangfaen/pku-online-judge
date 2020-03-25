import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.math.*;
public class Main
{


	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner cin = new Scanner(System.in);
		BigInteger n=new BigInteger(cin.next());
		if(n.compareTo(new BigInteger("0"))<0)
			return ;
		while(!n.equals(new BigInteger("0")))
		{
			n=n.subtract(new BigInteger("1"));
			BigInteger a,b;
			String s,t;
			s=cin.next();
			t=cin.next();
			if(s.charAt(0)=='+')
				s=s.substring(1);
			if(t.charAt(0)=='+')
				t=t.substring(1);
			a=new BigInteger(s);
			b=new BigInteger(t);
			System.out.println(a.add(b));
		}
			
		

	}

	
}
