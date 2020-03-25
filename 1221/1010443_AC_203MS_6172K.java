import java.util.*;
import java.io.*;
public class Main
{
	static long [][] map=new long[500][500];
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner cin=new Scanner(System.in);
		for(int i=0;i<500;i++)
			for(int j=0;j<500;j++)
				map[i][j]=-1;
		while(true)
		{
			int n=cin.nextInt();
			if(n==0)
				break;
			long sum=0;
			if(n%2==1)
			{
				for(int i=1;i<=n;i+=2)
					sum+=f((n-i)/2,i);
			}
			else
			{
				int half=n/2;
				sum+=f(half,half);
				for(int i=2;i<=n;i+=2)
					sum+=f((n-i)/2,i);
			}
			System.out.println(n+" "+sum);
		}
	}
	public static long f(int i,int j)
	{
		if(map[i][j]!=-1)
			return map[i][j];
		if(i+j==0)
			return 1;
		if(j==0)
			return map[i][j]=0;
		if(j==1)
			return map[i][j]=1;
		if(i<j)
			return map[i][j]=f(i,i);
		int tsum=0;
		for(int k=0;;k++)
		{
			if(i>=k*j)
				tsum+=f(i-k*j,j-1);
			else
				break;
		}
		return map[i][j]=tsum;
	}
	
}

