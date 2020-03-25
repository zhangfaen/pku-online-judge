import java.util.*;
import java.io.*;

public class Main
{
	
	static int V,M;
	static int res=Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception
	{
		Scanner cin = new Scanner(System.in);
		//BufferedReader cin=new BufferedReader(new InputStreamReader(System.in));
		V=cin.nextInt();
		M=cin.nextInt();
		for(int i=M;i<=100;i++)
		{
			if(i*i*M>V)
				break;
			for(int j=M;j<=V;j++)
			{
				int tv=i*i*j;
				if(tv>V)
					break;
				dfs(V-tv,i*i+2*i*j,1,i,j);
			}
		}
		System.out.println(res==Integer.MAX_VALUE?0:res);
	}
	public static void dfs(int rv,int s,int m,int r,int h)
	{
		if(m==M)
		{
			if(rv==0)
				res=Math.min(res, s);
			return;
		}
		int c=M-m;
		int mins=c*(1+c);
		if(mins+s>=res)
			return;
		int minv=c*(c+1)*(2*c+1)/6;
		if(rv<minv||rv>getMaxV(r,h,m))
			return;
		for(int i=r-1;i>c-1;i--)
			for(int j=h-1;j>c-1;j--)
			{
				int tv=i*i*j;
				int ts=2*i*j;
				if(tv>rv||ts+s>=res)
					continue;
				dfs(rv-tv,s+ts,m+1,i,j);
			}
	}
	public static int getMaxV(int r,int h,int m)
	{
		int c=M-m;
		int re=0;
		r--;h--;
		for(int i=0;i<c;i++)
		{
			re+=(r-i)*(r-i)*(h-i);
		}
		return re;
	}
	
}