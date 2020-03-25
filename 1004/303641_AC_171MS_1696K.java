import java.io.*;
import java.util.*;
import java.math.*;
public class Main
{
	public static void main(String [] args)throws Exception 
	{
	
		//Scanner cin=new Scanner(new File("c:\\fafa.txt"));
		Scanner cin=new Scanner(System.in);
		double per,sum=0;
		int n=0;
		while(cin.hasNext())
		{
			per=cin.nextDouble();
			n++;
			sum+=per;
			
		}	
		System.out.println("$"+Math.round(100*sum/n)/100.0);
	}
}