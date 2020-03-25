import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String [] args)
	{
		Scanner cin=new Scanner(System.in);
		int T=cin.nextInt();
		while(T--!=0)
		{
			int n=cin.nextInt();
			int min=Integer.MAX_VALUE;
			int t=0;
			int sum=0;
			for(int i=0;i<n;i++)
			{
				t=cin.nextInt();
				if(t<min)
					min=t;
				sum+=t;
				
			}
			sum-=min;
			System.out.println(sum);
		}
	}
}