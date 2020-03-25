import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main
{
	static int n,m;
	static double [] p;
	static double [] q;
	static int nm;
	static double tc=10000;
	static double BIG=Double.MAX_VALUE/2;
	static double [][] memo;
	public static void main(String []args)throws Exception
	{
		BufferedReader cin=new BufferedReader(new InputStreamReader(System.in));
		String s=cin.readLine();
		String [] sa=s.split(" ");
		n=Integer.parseInt(sa[0]);
		m=Integer.parseInt(sa[1]);
		nm=n+m;
		p=new double[n];
		q=new double[nm];
		for(int i=1;i<n;i++)
			p[i]=p[i-1]+tc/n;
		for(int i=1;i<nm;i++)
			q[i]=q[i-1]+tc/nm;
		memo=new double[n][nm];
		for(int i=0;i<n;i++)
			for(int j=0;j<nm;j++)
				memo[i][j]=-1;
		double re=dp(0,0);
		System.out.printf("%.4f",re);
	}
	public static double dp(int pi,int qi)
	{
		if(pi==n)
		{
			return 0;
		}
		if(qi==nm)
		{
			return BIG;
		}
		if(memo[pi][qi]!=-1)
			return memo[pi][qi];
		int bi=Arrays.binarySearch(q, p[pi]);
		double re=0;
		if(bi>=0)
		{
			re=dp(pi+1,bi+1);
		}
		else
		{
			bi=-(bi+1);
			re=BIG;
			if(bi-1>=qi)
			{
				re=Math.min(re, p[pi]-q[bi-1]+dp(pi+1,bi));
			}
			if(bi<nm)
			{
				re=Math.min(re, q[bi]-p[pi]+dp(pi+1,bi+1));
			}
		}
		return memo[pi][qi]=re;
	}
}