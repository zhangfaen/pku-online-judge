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
				recs[i]=new Rec(cin.nextDouble(),cin.nextDouble(),cin.nextDouble(),cin.nextDouble());
			}
			int sum=0;
			for(int i=0;i<n-1;i++)
				for(int j=i+1;j<n;j++)
				{
					if(recs[i].isCovedBy(recs[j]))
					{
						sum++;
						break;
					}
				}
			for(int i=n-2;i>=0;i--)
			{
				if(recs[n-1].isCovedBy(recs[i]))
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
	public double xmin;
	public double xmax;
	public double ymin;
	public double ymax;
	public Rec(double a,double b,double c,double d)
	{
		xmin=a;xmax=b;ymin=c;ymax=d;
	}
	public boolean isCovedBy(Rec t)
	{
		return t.xmax>=xmax&&t.xmin<=xmin&&t.ymin<=ymin&&t.ymax>=ymax;
	}
}