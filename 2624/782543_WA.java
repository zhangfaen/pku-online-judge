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
			cin.nextDouble();
			cin.nextDouble();
			double x3=cin.nextDouble();
			double y3=cin.nextDouble();
			System.out.printf("%.3f %.3f\n",(x3+x1)-x2,(y3+y1)-y2);
		}
	}
}