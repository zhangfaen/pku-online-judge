import java.util.*;
import java.io.*;
import java.util.regex.*;
public class Main
{
	static int [] sum;
	public static void main(String [] args) throws Exception
	{
		Scanner cin=new Scanner(System.in);
		while(true)		
		{
			int n=cin.nextInt();
			if(n==0)break;
			int [] p=new int[n];
			int [][] q=new int[n][n];
			sum=new int[n];
			for(int i=0;i<n;i++)
			{
				p[i]=cin.nextInt();
				
			}
			sum[0]=p[0];
			for(int i=1;i<n;i++)
				sum[i]=p[i]+sum[i-1];
			int total=f(0,n-1,q,p);
			System.out.println(total);
		}
	}

	public static int f(int i,int j,int [][] q,int [] p)
	{
		if(i==j)
			return 0;
		if(i+1==j)
			return p[i]+p[j];
		if(q[i][j]>0)
			return q[i][j];
		int min=Integer.MAX_VALUE;
		int lag=-1;
		for(int k=i;k<j;k++)
		{
			int tmin=f(i,k,q,p)+f(k+1,j,q,p)+sum[j]-sum[i]+p[i];
			if(min>tmin)
			{
				min=tmin;
				lag=k;
			}
		}
		
		return (q[i][j]=min);
		
	}
}