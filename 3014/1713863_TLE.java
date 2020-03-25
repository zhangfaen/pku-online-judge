import java.io.*;
import java.util.*;
import java.math.*;



public class Main
{
	static int [][] memo;
	static int k;
	static int n;
	public static void main(String [] args)
	{
		Scanner cin=new Scanner(System.in);
		k=cin.nextInt();
		n=cin.nextInt();
		memo=new int[n+1+k][k+1];
		int re=dp(n+k,k);
		System.out.println(re);
	}
	public static int dp(int n,int k)
	{
		if(n<k)
			return 0;
		if(k==1)
			return 1;
		int re=0;
		re+=dp(n-1,k-1)+dp(n-k,k);
		return memo[n][k]=re%1000000007;
	}
}
