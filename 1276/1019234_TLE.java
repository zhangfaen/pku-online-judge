import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main
{
	public static int n,a[],b[];
	public static int cash;
	public static int [][] p;
	public static void main(String [] args) throws FileNotFoundException
	{
		Scanner cin=new Scanner(System.in);
		while(cin.hasNextInt())
		{
			cash=cin.nextInt();
			n=cin.nextInt();
			a=new int[n];
			b=new int[n];
			p=new int[n][cash+1];
			for(int i=0;i<n;i++)
			{
				a[i]=cin.nextInt();
				b[i]=cin.nextInt();
			}
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
				{
					if(a[i]>a[j])
					{
						int t=a[i];a[i]=a[j];a[j]=t;
						t=b[i];b[i]=b[j];b[j]=t;
					}
				}
			for(int i=0;i<n;i++)
				for(int j=0;j<=cash;j++)
					p[i][j]=-1;
			if(n==0)
			{
				System.out.println(0);
				continue;
			}
			for(int i=0;i<n;i++)
				p[i][0]=0;
			for(int i=0;i<=cash;i++)
			{
				int m=0;
				int t=i;
				for(m=0;m<a[0];m++)
				{
					if(t>=b[0])
						t-=b[0];
					else break;
						
				}
				p[0][i]=t;
			}
			for(int i=1;i<n;i++)
				for(int j=1;j<=cash;j++)
				{
					int min=Integer.MAX_VALUE;
					for(int m=0;m<=a[i];m++)
					{
						if(j>=m*b[i])
						{
							int t1=p[i-1][j-m*b[i]];
							if(t1<min)
								min=t1;
						}
					}
					p[i][j]=min;
				}
		//	int min=f((int)(n-1),cash);
			System.out.println(cash-p[n-1][cash]);
		}
		
	}
	public static int f(int i,int cash)
	{
		if(p[i][cash]!=-1)
			return p[i][cash];
		if(cash==0)
			return 0;
		if(i==0)
		{
			int m=0;
			int t=cash;
			for(m=0;m<a[0];m++)
			{
				if(t>=b[i])
					t-=b[i];
				else break;
					
			}
			return p[i][cash]=t;
		}
		int min=Integer.MAX_VALUE;
		for(int m=0;m<=a[i];m++)
		{
			if(cash>=m*b[i])
			{
				int t1;
				if(p[i-1][cash-m*b[i]]!=-1)
					t1=p[i-1][cash-m*b[i]];
				else if(cash==0)
					t1=0;
				else t1=f(i-1,cash-m*b[i]);
				if(t1<min)
					min=t1;
			}
		}
		return p[i][cash]=min;
			
	}
}
