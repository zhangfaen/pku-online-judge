import java.io.*;
import java.util.*;
import java.math.*;
public class Main
{
	public static void main(String [] args)throws Exception 
	{
	
		//Scanner cin=new Scanner(new File("c:\\fafa.txt"));
		Scanner cin=new Scanner(System.in);
		int n;
		n=cin.nextInt();
		for(int i=0;i<n;i++)
		{
			double a,b;
			a=cin.nextDouble();
			b=cin.nextDouble();
			double area=Math.PI*(a*a+b*b)/2;
			int year=(int)(area/50)+1;
			System.out.println("Property "+(i+1)+": This property will begin eroding in year "+year+".");
		}
		System.out.println("END OF OUTPUT.");
		
	}
}