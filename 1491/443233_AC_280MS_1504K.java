import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		while(true)
		{
			int n=cin.nextInt();
			if(n==0)break;
			int [] p=new int[n];
			for(int i=0;i<n;i++)
				p[i]=cin.nextInt();
			int a=0,b=0;
			for(int i=0;i<n-1;i++)
				for(int j=i+1;j<n;j++)
				{
					b++;
					if(huzhi(p[i],p[j]))
						a++;
				}
			if(a==0)
				System.out.println("No estimate for this data set.");
			else
				System.out.println(Math.round(Math.sqrt(6*(double)b/a)*1000000)/1000000.0);
		}
	}
	private static boolean huzhi(int a,int b)
	{
		if(a>b)
		{
			int t=a;a=b;b=t;
		}
		while(b!=0)
		{
			int t=a%b;
			a=b;
			b=t;
		}
		if(a==1)return true;
		return false;
	}

	
}
