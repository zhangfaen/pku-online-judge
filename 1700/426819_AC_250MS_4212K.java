import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		int T=cin.nextInt();
		while(T--!=0)
		{
			int n=cin.nextInt();
			int []a=new int[n];
			for(int i=0;i<n;i++)
				a[i]=cin.nextInt();
			Arrays.sort(a);
			int sum=0;
			if(n==1)
				sum=a[0];
			if(n==2)
				sum=a[1];
			if(n==3)
				sum=a[1]+a[0]+a[2];
			if(n>3)
			{
				if(n%2==0)
				{
					for(int i=n-1;i>=2;i-=2)
					{
						if(a[i]+a[i-1]+2*a[0]<a[i]+2*a[1]+a[0])
							sum+=a[i]+a[i-1]+2*a[0];
						else
							sum+=a[i]+2*a[1]+a[0];
					}
					sum+=a[1];
				}
				else
				{
					for(int i=n-1;i>=4;i-=2)
					{
						if(a[i]+a[i-1]+2*a[0]<a[i]+2*a[1]+a[0])
							sum+=a[i]+a[i-1]+2*a[0];
						else
							sum+=a[i]+2*a[1]+a[0];
					}
					sum+=a[1]+a[0]+a[2];
				}
			}
			System.out.println(sum);
		}
	}
}