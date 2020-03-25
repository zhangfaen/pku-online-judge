import java.util.*;
import java.io.*;
public class Main
{
	private static int []a;
	private static int [][]p;
	private static int n;
	private static int k;
	private static int sum=0;
	private static boolean []fangd;
	public static void main(String [] args)throws Exception
	{

		Scanner cin=new Scanner(System.in);
		while(true)
		{
			n=cin.nextInt();k=cin.nextInt();
			if(n==-1)break;
			sum=0;
			p=new int[n][n];
			a=new int[n];
			fangd=new boolean[n];
			for(int i=0;i<n;i++)
			{
				a[i]=-1;
				fangd[i]=true;
			}
			for(int i=0;i<n;i++)
			{
				String s=cin.next();
				for(int j=0;j<n;j++)
					if(s.charAt(j)=='.')p[i][j]=-1;
					else
						p[i][j]=0;
			}
	
			f(0,0);
			System.out.println(sum);
		}
	}
	private static void f(int d,int x)
	{
		if(x==k)
		{
			sum++;
			return;
		}
		if(n-d<k-x)return;
		if(d==n)return;
		for(int i=0;i<n;i++)
			if(p[d][i]==0)
			{
				boolean isok=true;
				for(int j=0;j<d;j++)
					if(i==a[j])
					{
						isok=false;
						break;
					}
				if(isok)
				{
			
			
					a[d]=i;
					f(d+1,x+1);

					if(fangd[i])
					{
						fangd[i]=false;
						a[d]=-1;
						f(d+1,x);
					}
					
				}
					
			}
	}
		
}
