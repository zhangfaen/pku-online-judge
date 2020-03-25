import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		while(cin.hasNextInt())
		{
			int n=cin.nextInt();
			Rec [] recs=new Rec[n];
			for(int i=0;i<n;i++)
			{
				recs[i]=new Rec(cin.nextLong(),cin.nextLong(),cin.nextLong(),cin.nextLong());
			}
			int sum=0;
			for(int i=0;i<n;i++)
				for(int k=0,j=(i+1)%n;k<n-1;k++,j=(j+1)%n)
				{
					if(recs[i].isCovedBy(recs[j]))
					{
						sum++;
						break;
					}
				}
			System.out.println(sum);
		}	
	
			
	}
	
}
class Rec
{
	public long xmin;
	public long xmax;
	public long ymin;
	public long ymax;
	public Rec(long a,long b,long c,long d)
	{
		xmin=a;xmax=b;ymin=c;ymax=d;
	}
	public boolean isCovedBy(Rec t)
	{
		return t.xmax>=xmax&&t.xmin<=xmin&&t.ymin<=ymin&&t.ymax>=ymax;
	}
}