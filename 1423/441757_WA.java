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
			if(n<30)
			{
				BigInteger s=new BigInteger("1");
				for(int i=1;i<=n;i++)
					s=s.multiply(new BigInteger(""+i));
				System.out.println(s.toString().length());
				continue;
			}
			int r=(int)(0.5*Math.log10(2*Math.PI*n)+(n*Math.log10(n))-(n*Math.log10(Math.E)));
			System.out.println(r);
		}
	}

	
}
