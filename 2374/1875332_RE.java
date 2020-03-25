package com.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main
{
	static int N,S;
	static int [] x1s;
	static int [] x2s;
	static int BIG=Integer.MAX_VALUE/2;
	static int [][] memo;
	public static void main(String [] args)throws Exception
	{
		BufferedReader cin=new BufferedReader(new InputStreamReader(System.in));
		String s=null;
		String [] sa=null;
		s=cin.readLine();
		sa=s.split(" ");
		N=Integer.parseInt(sa[0])+2;
		S=Integer.parseInt(sa[1]);
		x1s=new int[N];
		x2s=new int[N];
		for(int i=2;i<N;i++)
		{
			s=cin.readLine();
			sa=s.split(" ");
			int x1=Integer.parseInt(sa[0]);
			int x2=Integer.parseInt(sa[1]);
			x1s[i]=x1;
			x2s[i]=x2;
		}
		try
		{
			x1s[0]=0;x2s[0]=BIG;
			x1s[1]=-BIG;x2s[1]=0;
			memo=new int[N][2];
			for(int i=0;i<N;i++)
				for(int j=0;j<2;j++)
					memo[i][j]=-1;
			for(int i=0;i<N;i+=100)
			{
				dp(i,0);
				dp(i,1);
			}
			int d1=S-x1s[N-1]+dp(N-1,0);
			int d2=x2s[N-1]-S+dp(N-1,1);
			int re=Math.min(d1, d2);
			System.out.println(re);
		}catch(Exception e){}
		
		
	}
	public static int dp(int ci,int lr)
	{
		if(ci==-1)return 0;
		if(memo[ci][lr]!=-1)
			return memo[ci][lr];
		int re=Integer.MAX_VALUE;
		if(lr==0)
		{
			int ni=-1;
			for(int i=ci-1;i>=0;i--)
			{
				if(x1s[i]<x1s[ci]&&x1s[ci]<x2s[i])
				{
					ni=i;
					break;
				}
			}
			if(ni==-1)return 0;
			int d1=x1s[ci]-x1s[ni]+dp(ni,0);
			int d2=x2s[ni]-x1s[ci]+dp(ni,1);
			re=Math.min(d1, d2);
		}
		else
		{
			int ni=-1;
			for(int i=ci-1;i>=0;i--)
			{
				if(x1s[i]<x2s[ci]&&x2s[ci]<x2s[i])
				{
					ni=i;
					break;
				}
			}
			if(ni==-1)return 0;
			int d1=x2s[ci]-x1s[ni]+dp(ni,0);
			int d2=x2s[ni]-x2s[ci]+dp(ni,1);
			re=Math.min(d1, d2);
		}
		return memo[ci][lr]=re;
	}
	
	
}
