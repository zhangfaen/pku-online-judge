import java.io.*;
import java.util.*;
public class Main
{

	public static void main(String [] args)throws Exception
	{
		Scanner cin=new Scanner(System.in);
		while(true)
		{
			int n=cin.nextInt();
			if(n==0)break;
			int sum=0;
			for(int i=1;i<n;i++)
			{
				if(g(n,i)==1)sum++;
			}
			System.out.println(sum);
		}

	}
	private static void f(int [] p)
	{
		p[0]=2;
		int tag=1;
		w:for(int i=3;i<=500001;i+=2)
		{
			int end=(int)Math.sqrt(i)+1;
			for(int j=2;j<end;j++)
			{
				if(i%j==0)
					continue w;
			}
			p[tag++]=i;
		}
	}
	private static int g(int a,int b)
	{
		if(a<b)
		{
			int t=a;a=b;b=t;
		}
		while(b!=0)
		{
			int t=a%b;
			a=b;
			b=t;
		}
		return a;
	}

	
}