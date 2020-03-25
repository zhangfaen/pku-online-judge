import java.io.*;
import java.util.*;
import java.math.*;
public class Main
{
	public static void main(String [] args)
	{
		Scanner cin=new Scanner(System.in);
		while(cin.hasNextInt())
		{
			int n=cin.nextInt();
			BigInteger bi=new BigInteger("2");
			BigInteger ci=new BigInteger("1");
			BigInteger [] map=new BigInteger[1001];
			map[1]=ci;
			map[2]=ci;
			BigInteger ti=ci;
			for(int i=3;i<=1000;i++)
			{
				map[i]=bi.pow(i-2).add(ti);
				if(i%2==1)
					ti=ti.multiply(bi).subtract(ci);
				else
					ti=ti.multiply(bi).add(ci);
			}
		
				System.out.println(map[n]);
		}
	}
}