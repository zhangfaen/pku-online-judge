import java.util.*;
import java.math.BigInteger;
public class Main
{
	public static void main(String [] args)
	{
		Scanner cin=new Scanner(System.in);
		int T=cin.nextInt();
		while(T--!=0)
		{
			int n=cin.nextInt();
			int r=0;
			if(n==3)
				r=1;
			if(n==4)
				r=2;
			if(n>4)
				r=n-1;
			System.out.println(r);
		}
	}

	
}
