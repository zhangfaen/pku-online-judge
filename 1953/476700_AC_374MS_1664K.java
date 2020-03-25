import java.util.*;
import java.io.*;
import java.text.*;
public class Main
{
	private static long [][]p=new long[47][47];;
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		
		for(int i=0;i<47;i++)
			for(int j=0;j<47;j++)
				p[i][j]=-1;
		int t=cin.nextInt();
		for(int i=1;i<=t;i++)
		{
			System.out.println("Scenario #"+i+":");
			long sum=0;
			int n=cin.nextInt();
			for(int j=n/2;j<=n;j++)
				sum+=cmn(j+1,n-j);
			System.out.println(sum);
			System.out.println();	
		}
		
		
	}
	private static long cmn(int m,int n)
	{
		if(n==0)
			return p[m][n]=1;
		if(m<n)
			return p[m][n]=0;
		if(m==n)
			return p[m][n]=1;
		if(p[m][n]>=0)
			return p[m][n];
		return p[m][n]=cmn(m-1,n)+cmn(m-1,n-1);
		
	}
	
}

