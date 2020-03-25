import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args) throws Exception
	{
		
		Scanner cin=new Scanner(System.in);
		while(true)
		{
			int n=cin.nextInt();
			if(n==0)
				break;
			double areas=0;
			double xa=cin.nextDouble();
			double ya=cin.nextDouble();
			double xb=cin.nextDouble();
			double yb=cin.nextDouble();
			double len=0;
			double sina=sin(xa,ya);
			double cosa=cos(xa,ya);
			double sinb=sin(xb,yb);
			double cosb=cos(xb,yb);
			
			
			
		
			double sinab=Math.sin(Math.asin(sina)-Math.asin(sinb));
			for(int i=0;i<n;i++)
			{
				double t=cin.nextDouble();
				areas-=t*t/2;
				len+=t;
			}
			
			double x=len*(sinb+cosb)/(sina*cosb-cosa*sinb);
			double y=len*(sina+cosa)/(sina*cosb-cosa*sinb);
			areas+=x*y*sinab/2;
			System.out.printf("%.3f\n",areas);
			
		}
		
	}
	public static double sin(double a,double b)
	{
		return b/Math.sqrt(a*a+b*b);
	}
	public static double cos(double a,double b)
	{
		return a/Math.sqrt(a*a+b*b);
	}
	
}
