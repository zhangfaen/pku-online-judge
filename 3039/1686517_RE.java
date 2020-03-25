package pku;
import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		Scanner cin=new Scanner(System.in);
		int n,d;
		n=cin.nextInt();
		d=cin.nextInt();
		double fac=d*1.0/n;
		double sd=n*1.0/d;
		double min=Double.MAX_VALUE;
		int ren=0,red=0;
		for(int i=1;i<=32767;i++)
		{
			
			double mul=fac*i;
			int a=(int)mul-2;
			int b=(int)mul+2;
			for(int j=a;j<=b;j++)
			{
				if(j>=1&&j<=32767)
				{
					if(Math.abs(i*1.0/j-sd)<min)
					{
						int g=gcd(i,j);
						if(i/g==n&&j/g==d)
							continue;
						min=Math.abs(i*1.0/j-sd);
						ren=i;red=j;
					}
				}
			}
			
		}
		int gcd=gcd(ren,red);
		System.out.println((ren/gcd)+" "+(red/gcd));
		
	}
	public static int gcd(int a,int b)
	{
		if(a==0)
			return b;
		return gcd(b%a,a);
	}

}
