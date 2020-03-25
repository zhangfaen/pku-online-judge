import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin =new Scanner(System.in);
		int n=cin.nextInt();
		int [][]a=new int[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<=i;j++)
				a[i][j]=cin.nextInt();
		int [][]sum=new int[n][n];
		sum[0][0]=a[0][0];
		for(int i=1;i<n;i++)
			for(int j=0;j<=i;j++)
			{
				int p1=0,p2=0;
				if(j<i)
					p1=sum[i-1][j];
				if(j>0)
					p2=sum[i-1][j-1];
				sum[i][j]=p1+a[i][j]>p2+a[i][j]?p1+a[i][j]:p2+a[i][j];
				
			}
		int max=0;
		for(int j=0;j<n;j++)
		{
			if(max<sum[n-1][j])
				max=sum[n-1][j];	
		}
		System.out.println(max);
	}
}