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
		while(cin.hasNextShort())
		{
			cash=cin.nextShort();
			n=cin.nextShort();
			a=new short[n];
			b=new short[n];
			p=new short[n][cash+1];
			for(short i=0;i<n;i++)
			{
				a[i]=cin.nextShort();
				b[i]=cin.nextShort();
			}
			for(short i=0;i<n;i++)
				for(short j=0;j<=cash;j++)
					p[i][j]=-1;
			if(n==0)
			{
				System.out.println(0);
				continue;
			}
			short min=f((short)(n-1),cash);
			System.out.println(cash-min);
		}
		
	}
	public static short f(short i,short cash)
	{
		if(p[i][cash]!=-1)
			return p[i][cash];
		if(cash==0)
			return 0;
		if(i==0)
		{
			short m=0;
			short t=cash;
			for(m=0;m<a[0];m++)
			{
				if(t>=b[i])
					t-=b[i];
				else break;
					
			}
			return p[i][cash]=t;
		}
		short min=Short.MAX_VALUE;
		for(int m=0;m<=a[i];m++)
		{
			if(cash>=m*b[i])
			{
				short t1=f((short)(i-1),(short)(cash-m*b[i]));
				if(t1<min)
					min=t1;
			}
		}
		return p[i][cash]=min;
			
	}
}
