import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		long [][]p=new long[101][101];
		while(true)
		{
			int n,m;
			n=cin.nextInt();m=cin.nextInt();
			if(n==0)break;
			System.out.printf("%d things taken %d at a time is %d exactly.\n",n,m,comb(p,n,m));
		}
	}
	private static long comb(long [][] p,int n,int m)
	{
		if(n==m)return 1;
		if(n<m)return 0;
		if(m==0)return 1;
		if(p[n][m]!=0)
			return p[n][m];
		return p[n][m]=comb(p,n-1,m-1)+comb(p,n-1,m);
	}

	
}
