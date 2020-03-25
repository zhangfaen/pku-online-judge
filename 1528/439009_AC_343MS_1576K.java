import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.text.NumberFormat;
public class Main
{

	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		System.out.println("PERFECTION OUTPUT");
		while(true)
		{
			int n=cin.nextInt();
			if(n==0)break;
			int sum=0;
			for(int i=1;i<n;i++)
			{
				if(n%i==0)
					sum+=i;
			}
			if(sum==n)
			{
				System.out.printf("%5d  PERFECT\n",n);
			}
			else
				if(sum>n)
				{
					System.out.printf("%5d  ABUNDANT\n",n);
				}
				else
				{
					System.out.printf("%5d  DEFICIENT\n",n);
				}
		}
		System.out.println("END OF OUTPUT");
		
	}
}