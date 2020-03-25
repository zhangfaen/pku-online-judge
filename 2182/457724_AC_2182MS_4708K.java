import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt();
		int []p=new int[n];
		int []q=new int[n];
		for(int i=1;i<n;i++)
			p[i]=cin.nextInt();
		for(int i=1;i<=n;i++)
		{
			int guo=0;
			for(int j=n-1;j>=0;j--)
			{
				if(q[j]>0)
				{
					guo++;
					continue;
				}
				if(p[j]==i-guo-1)
				{
					q[j]=i;
					break;
				}
			}
		}
		for(int i=0;i<n;i++)
		{
			System.out.println(q[i]);
		}
	}

}
