import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args)
	{
		Scanner cin=new Scanner(System.in);
		while(cin.hasNextInt())
		{
			int n=cin.nextInt();
			int k=cin.nextInt();
			int sum=0;
			sum+=n;
			int t=0;
			t+=n;
			while(t>=k)
			{
				int d=t/k;
				sum+=d;
				t%=k;
				t+=d;
			}
			System.out.println(sum);
			
		}
	}
}