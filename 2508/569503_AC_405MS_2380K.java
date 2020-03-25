import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String [] args)throws Exception
	{
		Scanner cin=new Scanner(System.in);
		while(cin.hasNextDouble())
		{
			double r=cin.nextDouble();
			double h=cin.nextDouble();
			double d1=cin.nextDouble();
			double a1=cin.nextDouble();
			double d2=cin.nextDouble();
			double a2=cin.nextDouble();
			double l=Math.sqrt(r*r+h*h);
			double rate=r/l;
			double a=Math.abs(a1-a2);
			if(a>=180)
				a=360-a;
			a*=rate;
			double c=Math.sqrt(d1*d1+d2*d2-2*d1*d2*Math.cos(a/180*Math.PI));
			long t=(long)(c*1000);
			if(t%10>=5)
				t+=10;
			t/=10;
			c=(double)t;
			System.out.printf("%.2f\n",c/100);
		}
	}
}