import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args) throws Exception
	{
		
		Scanner cin=new Scanner(System.in);
		int [] p=new int[5000];
		int total=1;
		p[0]=2;
		for(int i=3;i<10000;i+=2)
		{
			boolean is=true;
			int top=(int)Math.sqrt(i)+1;
			for(int j=3;j<top;j++)
			{
				if(i%j==0)
				{
					is=false;
					break;
				}	
			}
			if(is)
				p[total++]=i;
		}

		int [] sum=new int[total];
		sum[0]=p[0];
		for(int i=1;i<total;i++)
			sum[i]=sum[i-1]+p[i];
		while(true)
		{
			int n=cin.nextInt();
			if(n==0)break;
			int re=0;
			for(int i=0;i<total;i++)
			{
				if(n<p[i])
					break;
				if(f(sum,sum[i]-p[i]+n,total))
					re++;
			}
			System.out.println(re);
		}
	}
	public static boolean f(int [] sum,int t,int total)
	{
		int left=0,right=total-1;
		while(left<=right)
		{
			int mid=(left+right)/2;
			if(sum[mid]==t)
				return true;
			else
			if(sum[mid]<t)
				left=mid+1;
			else
				right=mid-1;
		}
		return false;
	}
}
