import java.util.*;
import java.io.*;
public class Main
{
	public static int [][]p;
	public static int n,min,maxc;
	
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner cin=new Scanner(System.in);
		while(true)
		{
			min=Integer.MAX_VALUE;
			n=cin.nextInt();
			if(n==-1)
				break;
			p=new int[n][n];
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
				{
					p[i][j]=cin.nextInt();
				}
			f(1);
			System.out.println(min);
		}
	}
	public static void f(int d)
	{
		if(d==n)
		{
			int t=get();
			if(t<min)
			{
				min=t;
			}
			return;
		}
		
		for(int i=0;i<n;i++)
		{
			int t=p[d][0];
			for(int j=0;j<n-1;j++)
				p[d][j]=p[d][j+1];
			p[d][n-1]=t;
			f(d+1);
		}
			
	}
	public static int get()
	{
		int max=Integer.MIN_VALUE;
		for(int j=0;j<n;j++)
		{
			int tsum=0;
			for(int i=0;i<n;i++)
				tsum+=p[i][j];
			if(tsum>max)
				max=tsum;
		}
		return max;
	}
}

