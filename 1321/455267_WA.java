import java.util.*;
import java.io.*;
public class Main
{
	private static int []a;
	private static int [][]p;
	private static int n;
	private static int k;
	private static int sum=0;
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		while(true)
		{
			n=cin.nextInt();k=cin.nextInt();
			if(n==-1)break;
			sum=0;
			p=new int[n][n];
			a=new int[n];
			for(int i=0;i<n;i++)
				a[i]=-1;
			for(int i=0;i<n;i++)
			{
				String s=cin.next();
				for(int j=0;j<n;j++)
					if(s.charAt(j)=='.')p[i][j]=-1;
					else
						p[i][j]=0;
			}
		}
	}
	private static void f(int d,int x)
	{
		if(x==k)
		{
			sum++;
			return;
		}
		if(d==n)return;
		for(int i=0;i<n;i++)
			if(p[d][i]==0)
			{
				boolean isok=true;
				for(int j=0;j<d;j++)
					if(i==a[j])
						isok=false;
				if(isok)
				{
					a[d]=i;
					f(d+1,x+1);
					a[d]=-1;
					f(d+1,x);
					
				}
					
			}
	}
		
}
