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
			for(int i=n;i>1;i--)
			{
				int j=(int)(d*i-2);
				if(j<1)
					j=1;
				int end=j+3;
				for(;j<=end;j++)
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
			for(int i=1;i<=n;i++)
			{
				int left=(int)(i/d-2);
				int right=left+4;
				int j=left>1?left:1;
				for(;j<=n&&j<=right;j++)
				{
					double t=(double)i/j;
					if(Math.abs(t-d)<c)
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