import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.*;
public class Main
{
	public static int [][] p=new int[1001][50001];
	
	public static void main(String [] args) throws FileNotFoundException
	{
		//System.out.println(gcd(-3,3));
		Scanner cin=new Scanner(System.in);
		while(cin.hasNextInt())
		{
			int n=cin.nextInt();
			int [] x=new int[n];
			int [] y=new int[n];
			HashMap<String,Integer > hs=new HashMap<String,Integer>();
			for(int i=0;i<n;i++)
			{
				x[i]=cin.nextInt();
				y[i]=cin.nextInt();
			}
			int max=2;
			for(int i=0;i<n-1;i++)
				for(int j=i+1;j<n;j++)
				{
					String key=xie(x[i],y[i],x[j],y[j]);
					Integer it=hs.get(key);
					if(it==null)
					{
						hs.put(key,1);
					}
					else
					{
						it=it+1;
						hs.put(key,it);
						if(it>max)
							max=it;
					}
					
				}
			System.out.println((int)Math.sqrt(max*2)+1);
		}
		
	}
	public static String xie(int x1,int y1,int x2,int y2)
	{
		int t1=y1-y2;
		int t2=x1-x2;
		int t3=x1*(y2-y1)-y1*(x2-x1);
		if(t1<0)
		{
			t1=-t1;
			t2=-t2;
			t3=-t3;
		}
		int g=gcd(gcd(Math.abs(t1),Math.abs(t2)),Math.abs(t3));
		return ""+(t1/g)+(t2/g)+(t3/g);
	}
	public static int gcd(int a,int b)
	{
		if(p[a][b]>0)
			return p[a][b];
		int c=a,d=b;
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
		return p[c][d]=p[d][c]=a;
	}
	public static boolean ok(int x1,int y1,int x2,int y2,int x,int y)
	{
		return (y-y1)*(x2-x1)==(x-x1)*(y2-y1);
	}
}
