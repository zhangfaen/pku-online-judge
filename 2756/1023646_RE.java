import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.math.*;
public class Main
{


	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner cin = new Scanner(System.in);
		long n=cin.nextLong();
		while(n--!=0)
		{
			BigInteger a,b;
			a=new BigInteger(cin.next());
			b=new BigInteger(cin.next());
			System.out.println(a.add(b));
		}
			
		

	}

	
}
