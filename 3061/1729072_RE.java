import java.io.*;
import java.util.*;
import java.math.*;
public class Main
{
	static int [] memo;
	static int N,S;
	static int [] sum;
	public static void main(String[] args)throws Exception
	{
//		int [] a={1,3,4};
//		System.out.println(Arrays.binarySearch(a, 2)+1);
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		String s=null;
		String [] sa=null;
		int tc=Integer.parseInt(in.readLine());
		out:while(tc--!=0)
		{
			s=in.readLine();
			sa=s.split(" ");
			N=Integer.parseInt(sa[0]);
			S=Integer.parseInt(sa[1]);
			int [] p=new int[N];
			sum=new int[N];
			memo=new int[N];
			Arrays.fill(memo, -1);
			s=in.readLine();
			sa=s.split(" ");
			for(int i=0;i<N;i++)
			{
				p[i]=Integer.parseInt(sa[i]);
				if(i==0)
					sum[i]=p[i];
				else
					sum[i]=p[i]+sum[i-1];
			}
			int re=dp(0);
			if(re==BIG)
				System.out.println(0);
			else
				System.out.println(re);
		}
		
	}
	static int BIG=Integer.MAX_VALUE;
	public static int dp(int ci)
	{
		if(ci==N)
			return BIG;
		int re=BIG;
		int fac=0;
		if(ci>0)
			fac=sum[ci-1];
		int bf=Arrays.binarySearch(sum, S+fac);
		if(bf>=0)
			re=(bf-ci+1);
		else
		{
			bf=-(bf+1);
			if(bf<N)
			{
				re=(bf-ci+1);
			}
		}
		re=Math.min(re, dp(ci+1));
		return memo[ci]=re;
	}
	
	
}