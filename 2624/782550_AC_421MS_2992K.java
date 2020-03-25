import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args) throws Exception
	{
		Scanner cin=new Scanner(System.in);
		while(cin.hasNextDouble())
		{
			double x1=cin.nextDouble();
			double y1=cin.nextDouble();
			double x2=cin.nextDouble();
			double y2=cin.nextDouble();
			double x3=cin.nextDouble();
			double y3=cin.nextDouble();
			double x4=cin.nextDouble();
			double y4=cin.nextDouble();
			double x5=x1+x2+x3+x4;
			double y5=y1+y2+y3+y4;
			if(x1==x2&&y1==y2)
			{
				x5-=3*x1;
				y5-=3*y1;
			}
			else
			if(x1==x3&&y1==y3)
			{
				x5-=3*x1;
				y5-=3*y1;
			}
			else
			if(x1==x4&&y1==y4)
			{
				x5-=3*x1;
				y5-=3*y1;
			}
			else
			if(x2==x3&&y2==y3)
			{
				x5-=3*x2;
				y5-=3*y2;
			}
			else
			if(x2==x4&&y2==y4)
			{
				x5-=3*x2;
				y5-=3*y2;
			}
			if(x3==x4&&y3==y4)
			{
				x5-=3*x3;
				y5-=3*y3;
			}
			System.out.printf("%.3f %.3f\n",x5,y5);
		}
	}
}