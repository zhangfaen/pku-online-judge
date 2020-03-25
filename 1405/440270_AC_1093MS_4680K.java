import java.util.*;
import java.math.BigInteger;
public class Main
{
	public static void main(String [] args)
	{
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt();
		System.out.println(2);
		BigInteger t=new BigInteger("2");
		for(int i=1;i<n;i++)
		{
			t=t.subtract(new BigInteger("1")).multiply(t).add(new BigInteger("1"));
			System.out.println(t);
		}
	}
	
}
