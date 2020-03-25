import java.io.*;
import java.util.*;
import java.math.*;
public class Main
{
	public static void main(String[] args) throws Exception
	{
		Scanner cin = new Scanner(new BufferedInputStream(System.in));
		//Scanner cin=new Scanner(new File("c:\\in.txt"));
		int ma=cin.nextInt();
		tag:while(ma--!=0)
		{
			int n=cin.nextInt();	
			long re=0;
			int [] p=new int[n];
			for(int i=0;i<n;i++)
				p[i]=cin.nextInt();
			if(n<2)
			{
				System.out.println(p[0]);
				continue;
			}
			re=getLcd(p[0],p[1]);
			for(int i=2;i<n;i++)
			{
				re=getLcd(re,p[i]);
				if(re>1E9)
				{
					System.out.println("More than a billion.");
					continue tag;
				}
			}
			System.out.println(re);
		}
		
	}
	public static long getLcd(long a,long b)
	{
		if(a<b)
		{
			long t=a;a=b;b=t;
		}
		long re=a*b;
		while(b!=0)
		{
			long t=a%b;
			a=b;
			b=t;
		}
		return re/a;
	}
}
