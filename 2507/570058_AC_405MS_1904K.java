import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String [] args)throws Exception
	{
		Scanner cin=new Scanner(System.in);
		while(cin.hasNextDouble())
		{
			double x=cin.nextDouble();
			double y=cin.nextDouble();
			double c=cin.nextDouble();
			double l=0,r=Math.min(x,y);
			double d=0;
			while(true)
			{
				double t=(l+r)/2;
				d=c/Math.sqrt(x*x-t*t)+c/Math.sqrt(y*y-t*t);
				if(Math.abs(d-1.0)<0.00000001)
					break;
			//	System.out.println(t+" "+d);
				if(d<1)
					l=t;
				if(d>1)
					r=t;
				
			}
			long tt=(long)(r*10000);
			if(tt%10>=5)
				tt+=10;
			tt/=10;
			r=(double)tt;
			System.out.printf("%.3f\n",r/1000);

		}
	}


}