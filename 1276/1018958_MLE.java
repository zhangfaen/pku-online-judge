import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main
{
	public static int cash,n,a[],b[];
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
				for(int j=0;j<=cash;j++)
					p[i][j]=-1;
			if(n==0)
			{
				System.out.println(0);
				continue;
			}
			int min=f(n-1,cash);
			System.out.println(cash-min);
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
			int m;
			for(m=0;m<=a[1];m++)
			{
				if(cash>=m*b[i])
					;
				else break;
					
			}
			return p[i][cash]=cash-(m-1)*b[i];
		}
		int min=Integer.MAX_VALUE;
		for(int m=0;m<=a[i];m++)
		{
			if(cash>=m*b[i])
			{
				int t1=f(i-1,cash-m*b[i]);
				if(t1<min)
					min=t1;
			}
		}
		return p[i][cash]=min;
			
	}
}
