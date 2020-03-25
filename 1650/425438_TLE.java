import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		double d=cin.nextDouble();
		int n=cin.nextInt();
		if(d<1)
		{
			int a=0,b=0;
			double c=Double.MAX_VALUE;
			for(int i=n;i>=1;i--)
			{
				for(int j=1;j<=i;j++)
				{
					double t=(double)j/i;
					if(Math.abs(t-d)<=c)
					{
						c=Math.abs(t-d);
						a=j;
						b=i;
					}
				}
			}
			System.out.println(a+" "+b);
		}
		else
		{
			int a=0,b=0;
			double c=Double.MAX_VALUE;
			for(int i=n;i>=1;i--)
			{
				for(int j=1;j<=i;j++)
				{
					double t=(double)i/j;
					if(Math.abs(t-d)<=c)
					{
						c=Math.abs(t-d);
						a=i;
						b=j;
					}
				}
			}
			System.out.println(a+" "+b);
		}
	//	System.out.println((double)9940/3164);
	//	System.out.println((double)355/113);
	}
}