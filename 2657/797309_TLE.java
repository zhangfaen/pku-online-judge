import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args)
	{
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt();
		int z=cin.nextInt();
		int m=cin.nextInt();
		if(m==0||z==1)
		{
			System.out.println(1);
			return;
		}
		int [] q=new int[n+1];
		int [] tag=new int[n+1];
		for(int i=0;i<m;i++)
		{
			int t=cin.nextInt();
			q[t]=1;
			for(int j=1;j<=t/2;j++)
			{
				if((t-1)%j==0&&(z-1)%j==0&&t<z)
					tag[j]=1;
				
			}
			
		}
		for(int k=1;k<=n-1;k++)
		{
			if(tag[k]==1)
				continue;
			int [] p=new int[n+1];
			p[1]=1;
			int cur=1;
			while(true)
			{
				cur=(cur+k)%n;
				if(cur==z)
				{
					System.out.println(k);
					return;
				}
				else
				if(q[cur]==1)
					break;
			}
		}
	}
}