import java.util.*;
import java.io.*;
import java.math.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		Scanner cin=new Scanner(System.in);
		int num=cin.nextInt();
		int ft=num;
		while(num--!=0)
		{
			double R=cin.nextDouble();
			int n=cin.nextInt();
			double t=R/(1/Math.sin(Math.PI/n)+1);
			int tt=(int)(t*10000);
			if(tt%10>=5)
				tt+=10;
			tt/=10;
			System.out.printf("Scenario #%d:\n%.3f\n\n",ft-num,tt/1000.0);
		}
		
		
	}
}