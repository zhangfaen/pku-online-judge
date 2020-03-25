import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		double pi=3.14159;
		while(true)
		{
			String s=cin.next();
			if(!s.equals("START"))break;
			int x,y,z;
			x=cin.nextInt();
			y=cin.nextInt();
			z=cin.nextInt();
			cin.next();
			if(z>180)z=360-z;
			double dis=2*x*pi*(double)z/180;
			int can=y*5;
			if(can>=dis)
			{
				System.out.println("YES "+(int)(y-(dis/5)));
			}
			else
				System.out.println("NO "+y*5);
			
		}
	
	
	}

}