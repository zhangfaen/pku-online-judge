import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		Scanner cin=new Scanner(System.in);
		int t=cin.nextInt();
		while(t--!=0)
		{
			int n=cin.nextInt();
			int p[]=new int[n+1];
			for(int i=1;i<=n;i++)
			{
				for(int j=0;j<=n;j+=i)
					p[j]++;
			}
			int sum=0;
			for(int i=1;i<=n;i++)
				if(p[i]%2!=0)
					sum++;
			System.out.println(sum);
		}
	} 

	
}
