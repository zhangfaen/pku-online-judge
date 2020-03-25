import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		double D=cin.nextDouble();
		double H=cin.nextDouble();
		while(true)
		{
			double a=cin.nextDouble()/180*Math.PI;
			double b=cin.nextDouble()/180*Math.PI;
			double y=cin.nextDouble()/180*Math.PI;
			if(a+b+y==0)break;
			if(a==0||b==0||y==0)
			{
				System.out.println(0);
				continue;
			}
			double tanb2=Math.tan(b)*Math.tan(b);
			double h=Math.sqrt(200*D*D*tanb2/(100/Math.tan(y)*tanb2*1/Math.tan(y)+100/Math.tan(a)*tanb2*1/Math.tan(a)-200));
			System.out.println(Math.round(h+4));
		}

	}
}

