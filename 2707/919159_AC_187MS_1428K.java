import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args) throws Exception
	{
		Scanner cin=new Scanner(System.in);
		while(true)
		{
			int a,b,c,d;
			a=cin.nextInt();
			b=cin.nextInt();
			c=cin.nextInt();
			d=cin.nextInt();
			if(a+b+c+d==0)
				break;
			if(a>b&&c<d)
			{
				int t=a;a=b;b=t;
			}
			if(a<b&&c>d)
			{
				int t=a;a=b;b=t;
			}
			double r1,r2;
			r1=(double)c/a;
			r2=(double)d/b;
			if(r1>=1&&r2>=1)
				System.out.println("100%");
			else
			{
				double r=r1<r2?r1:r2;
				System.out.println((int)(r*100)+"%");
			}
		}
	}
}
