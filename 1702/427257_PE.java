import java.io.*;
import java.util.*;
public class Main
{
	private static long p[]=new long[20];
	private static long sum[]=new long[20];
	public static void main(String [] args)
	{
	
		Scanner cin=new Scanner(System.in);
		sum[0]=1;
		for(int i=0;i<20;i++)
		{
			p[i]=(int)Math.pow(3,i);
			if(i>=1)
				sum[i]=p[i]+sum[i-1];
		}
		int T=cin.nextInt();
		while(T--!=0)
		{
			long n=cin.nextLong();
			LinkedList<Long>left=new LinkedList<Long>();
			LinkedList<Long>right=new LinkedList<Long>();
			long t=n;
			while(t!=0)
			{
				if(t>0)
					for(int i=0;i<20;i++)
					{
						if(sum[i]>=t)
						{
							right.addFirst(p[i]);
							t-=p[i];
							break;
						}
					}
				if(t==0)break;
				if(t<0)
					for(int i=0;i<20;i++)
					{
						if(sum[i]>=-t)
						{
							left.addFirst(p[i]);
							t+=p[i];
							break;
						}
					}
			}
			if(left.size()==0)
				System.out.print("empty ");
			for(int i=0;i<left.size();i++)
			{
				if(i!=left.size()-1)
					System.out.print(left.get(i)+",");
				else
					System.out.print(left.get(i)+" ");
			}
			
			for(int i=0;i<right.size();i++)
			{
				if(i!=right.size()-1)
					System.out.print(right.get(i)+",");
				else
					System.out.print(right.get(i));
			}
			
		}
	}
}