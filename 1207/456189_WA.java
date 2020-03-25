import java.util.*;
import java.io.*;
public class Main
{
	private static int [] p=new int[10001];
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		int m,n;
		while(cin.hasNext())
		{
			m=cin.nextInt();n=cin.nextInt();
			if(m>n)
			{
				int t=m;m=n;n=t;
			}
		
			int max=0;
			for(int i=m;i<=n;i++)
			{
				int t=f(i);
				if(max<t)
					max=t;
			}
			System.out.println(m+" "+n+" "+max);
		}
		
	
	}
	private static int f(int x)
	{
		if(p[x]!=0)
			return p[x];
		int sum=0;
		while(x!=1)
		{
			if(x%2!=0)
				x=3*x+1;
			else
				x=x/2;
			sum++;
		}
		return p[x]=sum+1;
	}
}