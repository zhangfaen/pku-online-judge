import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		int prime[]=new int[10000];
		int length=f(prime);
		while(true)
		{
			int m,a,b;
			m=cin.nextInt();a=cin.nextInt();b=cin.nextInt();	
			if(m==0)break;
			int max=0;
			int p=0,q=0;
			for(int i=0;i<length;i++)
			{
				if(prime[i]*prime[i]>m)break;
				for(int j=i;j<length;j++)
				{
					long tarea=prime[j]*prime[i];
					if(tarea>m)break;
					if(prime[j]*a>prime[i]*b)break;
					if(tarea>max)
					{
						max=(int)tarea;
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
			for(int j=3;j<=end;j+=2)
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
			else return i;
		}
		return -1;
	}

	
}
