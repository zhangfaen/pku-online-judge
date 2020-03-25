import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args)
	{
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt();
		double a0=cin.nextDouble();
		double an1=cin.nextDouble();
		double ci=0;
		for(int i=n;i>=1;i--)
		{
			ci+=2*(n-i+1)*cin.nextDouble();
			ci-=a0;
		}
		double a1=an1-ci;
		a1/=(n+1);
		System.out.printf("%.2f\n",a1);
	}
}