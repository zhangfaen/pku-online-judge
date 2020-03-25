import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		while(true)
		{
			double a,b,c;
			a=cin.nextDouble();
			b=cin.nextDouble();
			c=cin.nextDouble();
			if(a+b+c==0)break;
			boolean ok=false;
			if(a<=4.5&&b>=150&&c>=200)
			{
				System.out.print("Wide Receiver ");
				ok=true;
			}
			if(a<=6.0&&b>=300&&c>=500)
			{
				ok=true;
				System.out.print("Lineman ");
			}
			if(a<=5.0&&b>=200&&c>=300)
			{
				System.out.print("Quarterback  ");
				ok=true;
			}
			
			if(!ok)
				System.out.print("No positions");
			System.out.println();
			
			
		}
	}
}

