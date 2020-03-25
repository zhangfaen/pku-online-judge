import java.io.*;
import java.util.*;
import java.math.*;
public class Main
{
	public static void main(String args[]) throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		while(true)
		{
			int n=cin.nextInt(),m=cin.nextInt();
			if(n==0)break;
			int []a=new int[m+1];
			a[0]=1;
			int []b=new int[n];
			int []c=new int[n];
			for(int i=0;i<n;i++)
				b[i]=cin.nextInt();
			for(int i=0;i<n;i++)
			{
				int t=cin.nextInt();
				for(int j=0;j<t;j++)
					mul(a,b[i],m);
			}
			int sum=0;
			for(int i=0;i<=m;i++)
				if(a[i]>0)
					sum++;
			System.out.println(sum-1);
			
		}
		

		
	}
	public static void mul(int []a,int n,int m)
	{
		//int []b=a.clone();
		for(int i=m;i>=n;i--)
		{
			a[i]=a[i-n]+a[i];
		}
	}
}

