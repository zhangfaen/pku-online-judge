import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
public class Main
{
	public static void main(String [] args) throws FileNotFoundException
	{
		System.out.println(gcd(3,0));
		Scanner cin=new Scanner(System.in);
		while(cin.hasNextInt())
		{
			int n=cin.nextInt();
			boolean [][] p=new boolean[n][n];
			boolean [] state=new boolean[n];
			int [] x=new int[n];
			int [] y=new int[n];
			HashSet<String > hs=new HashSet<String>();
			for(int i=0;i<n;i++)
			{
				x[i]=cin.nextInt();
				y[i]=cin.nextInt();
			}
			int max=2;
			for(int i=0;i<n-1;i++)
				for(int j=i+1;j<n;j++)
				{
					int tsum=0;
					if(hs.contains(xie(x[i],y[i],x[j],y[j])))
						continue;
					hs.add(xie(x[i],y[i],x[j],y[j]));
					for(int k=0;k<n;k++)
						if(ok(x[i],y[i],x[j],y[j],x[k],y[k]))
						{
							tsum++;
						}
					if(tsum>max)
						max=tsum;
				}
			System.out.println(max);
		}
		
	}
	public static String xie(int x1,int y1,int x2,int y2)
	{
		int t1=y1-y2;
		int t2=x1-x2;
		int t3=x1*(y2-y1)-y1*(x2-x1);
		int g=gcd(gcd(t1,t2),t3);
		return ""+(t1/g)+(t2/g)+(t3/g);
	}
	public static int gcd(int a,int b)
	{
		if(a<b)
		{
			int t=a;a=b;b=t;
		}
		while(b!=0)
		{
			int t=a%b;
			a=b;
			b=t;
		}
		return a;
	}
	public static boolean ok(int x1,int y1,int x2,int y2,int x,int y)
	{
		return (y-y1)*(x2-x1)==(x-x1)*(y2-y1);
	}
}
