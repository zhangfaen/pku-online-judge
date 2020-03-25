import java.io.*;
import java.util.*;
import java.math.*;
public class Main
{
	static boolean [][] map;
	public static void main(String[] args) throws Exception
	{
		int [] primes=getPrimes2(20001);
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		String rs=cin.readLine();
		int n=Integer.parseInt(rs);
		int re=1,fac=1;
		for(int i=0;i<n;i++)
		{
			int d=Integer.parseInt(cin.readLine());
			if(d<2)
				continue;
			for(int j=primes.length-1;j>=0;j--)
			{
				if(d%primes[j]==0&&primes[j]>fac)
				{
					re=d;fac=primes[j];
				}
			}
		}
		System.out.println(re);
	}
	public static int[] getPrimes2(int n)
	{
		boolean[] prime = new boolean[n + 1];
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false;
		int m = (int) Math.sqrt(n);
		int size=0;
		for (int i = 2; i <= m; i++)
		{
			if (prime[i])
			{	
				for (int k = i * i; k <= n; k += i)
					prime[k] = false;
			}
		}
		for(boolean bl:prime)
			if(bl)
				size++;
		int [] re=new int[size];
		int tag=0;
		for(int i=0;i<n+1;i++)
			if(prime[i])
				re[tag++]=i;
		return re;
	}
}
