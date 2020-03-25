import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main
{
	static int n;
	static long [][][] memo;
	static int [] loc;
	public static void main(String[] args) throws IOException
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		String s=cin.readLine();
		String [] sa=s.split(" ");
		n=Integer.parseInt(sa[0]);
		int L=Integer.parseInt(sa[1]);
		memo=new long[n][n][2];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				for(int k=0;k<2;k++)
					memo[i][j][k]=-1;
		loc=new int[n];
		for(int i=0;i<n;i++)
		{
			s=cin.readLine();
			loc[i]=Integer.parseInt(s);
		}
		Arrays.sort(loc);
		int si=-2;
		for(int i=0;i<n;i++)
			if(L<loc[i])
			{
				si=i-1;
				break;
			}
		if(si==-2)
			si=n-1;
		long re=Long.MAX_VALUE;
		if(si>=0)
		{
			re=Math.min(re, getcnt(si,si+1)*(L-loc[si])+dp(si,si+1,1));
		}
		if(si+1<n)
		{
			re=Math.min(re, getcnt(si,si+1)*(loc[si+1]-L)+dp(si,si+1,0));
		}
		System.out.println(re);
		out.flush();
		out.close();
	}
	public static long dp(int li,int ri,int isLeft)
	{
		if(li>=0&&li<n&&ri>=0&&ri<n&&memo[li][ri][isLeft]!=-1)
			return memo[li][ri][isLeft];
		long re=Long.MAX_VALUE;
		if(isLeft==1)
		{
			if(li>0)
			{
				long d=getcnt(li-1,ri)*(loc[li]-loc[li-1])+dp(li-1,ri,1);
				re=Math.min(re,d);
			}
			if(ri<n)
			{
				long d=getcnt(li-1,ri)*(loc[ri]-loc[li])+dp(li-1,ri,0);
				re=Math.min(re, d);
			}
			if(re==Long.MAX_VALUE)
				re=0;
			if(li>=0&&li<n&&ri>=0&&ri<n)
				memo[li][ri][isLeft]=re;
			 return re;
		}
		else
		{
			if(li>=0)
			{
				long d=getcnt(li,ri+1)*(loc[ri]-loc[li])+dp(li,ri+1,1);
				re=Math.min(re,d);
			}
			if(ri<n-1)
			{
				long d=getcnt(li,ri+1)*(loc[ri+1]-loc[ri])+dp(li,ri+1,0);
				re=Math.min(re, d);
			}
			if(re==Long.MAX_VALUE)
				re=0;
			if(li>=0&&li<n&&ri>=0&&ri<n)
				memo[li][ri][isLeft]=re;
			 return re;
		}
		
	}
	public static long getcnt(int li,int ri)
	{
		long re=0;
		if(li>=0)
			re+=li+1;
		if(ri<n)
			re+=n-ri;
		return re;
	}
}