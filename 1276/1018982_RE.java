import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main
{
	public static short cash,n,a[],b[];
	public static short [][] p;
	public static void main(String [] args) throws FileNotFoundException
	{
		Scanner cin=new Scanner(System.in);
		while(cin.hasNextInt())
		{
			cash=cin.nextShort();
			n=cin.nextShort();
			a=new short[n];
			b=new short[n];
			p=new short[n][cash+1];
			for(Short i=0;i<n;i++)
			{
				a[i]=cin.nextShort();
				b[i]=cin.nextShort();
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
	public static short f(int i,int cash)
	{
		if(p[i][cash]!=-1)
			return p[i][cash];
		if(cash==0)
			return 0;
		if(i==0)
		{
			short m;
			for(m=0;m<=a[1];m++)
			{
				if(cash>=m*b[i])
					;
				else break;
					
			}
			return p[i][cash]=(short) (cash-(m-1)*b[i]);
		}
		short min=Short.MAX_VALUE;
		for(int m=0;m<=a[i];m++)
		{
			if(cash>=m*b[i])
			{
				short t1=f(i-1,cash-m*b[i]);
				if(t1<min)
					min=t1;
			}
		}
		return p[i][cash]=min;
			
	}
}
