import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		int prime[]=new int[50000];
		int length=f(prime);
		while(true)
		{
			int m,a,b;
			m=cin.nextInt();a=cin.nextInt();b=cin.nextInt();	
			if(m==0)break;
			double ratio=(double)b/a;
			int max=0;
			int p=0,q=0;
			for(int i=0;i<length;i++)
			{
				if(prime[i]*prime[i]>m)break;
				for(int j=find(prime,(int)Math.floor(prime[i]*ratio))+1;j>=i;j--)
				{
					int tarea=prime[j]*prime[i];
					if(tarea>max&&tarea<=m&&(double)prime[j]/prime[i]<=ratio)
					{
						max=tarea;
						p=prime[i];
						q=prime[j];
					}
				}
			}
			System.out.println(p+" "+q);
		}
	}
	private static int f(int [] prime)
	{
		prime[0]=2;
		int index=1;
		for(int i=3;i<100000;i+=2)
		{
			boolean tag=true;
			int end=(int)Math.sqrt(i)+1;
			for(int j=2;j<=end;j++)
				if(i%j==0)
				{
					tag=false;
					break;
				}
			if(tag)
				prime[index++]=i;
		}
		return index;
	}
	private static int find(int [] prime,int x)
	{
		for(int i=0;i<prime.length;i++)
		{
			if(prime[i]<=x);
			else return i-1;
		}
		return -1;
	}

	
}
