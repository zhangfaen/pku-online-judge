import java.util.*;
import java.io.*;
public class Main2140
{
	public static void main(String [] args)throws Exception
	{
		Scanner cin=new Scanner(System.in);
		int [] sum=new int[10000];
		for(int i=1;i<10000;i++)
			sum[i]=i+sum[i-1];
	//	System.out.println(sum[9999]);
		while(cin.hasNextInt())
		{
			int n=cin.nextInt();
			int t=0;
			for(int i=1;i<9999;i++)
				if(n<=sum[i])
				{
					if(n==sum[i])t=i;
					else t=i-1;
					break;
				}
			int max=1;
			for(int i=2;i<=t;i++)
			{
				if((2*n-i*i-i)%(2*i)==0)
					max++;
			}
			System.out.println(max);
		}
			
		
	} 

	
}
