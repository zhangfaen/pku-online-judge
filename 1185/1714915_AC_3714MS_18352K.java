import java.io.*;
import java.util.*;
public class Main
{
	static int m,n;
	static int [] map;
	static int [][][]memo;
	static int numOfStates=200;
	static int ssize=0;
	static int [] ss=new int[numOfStates];
	public static void main(String [] args)
	{
		Scanner cin=new Scanner(System.in);
		m=cin.nextInt();
		n=cin.nextInt();
		map=new int[m];
		for(int i=0;i<m;i++)
		{
			String s=cin.next();
			int d=0;
			for(int j=0;j<s.length();j++)
				if(s.charAt(j)=='H')
					d|=(1<<(n-1-j));
			map[i]=d;
		}
		memo=new int[m][numOfStates][numOfStates];
		for(int i=0;i<m;i++)
			for(int j=0;j<numOfStates;j++)
				for(int k=0;k<numOfStates;k++)
					memo[i][j][k]=-1;
		for(int i=0;i<(1<<n);i++)
		{
			if(check(i))
				ss[ssize++]=i;
		}
		int res=dp(0,0,0);
		System.out.println(res);
	}
	public static int dp(int row,int s1,int s2)
	{
		if(row==m)
			return 0;
		if(memo[row][s1][s2]!=-1)
			return memo[row][s1][s2];
		int re=0;
		for(int i=0;i<ssize;i++)
		{
			if((ss[i]&map[row])==0&&(ss[i]&ss[s1])==0&&(ss[i]&ss[s2])==0)
			{
				re=Math.max(re, Integer.bitCount(ss[i])+dp(row+1,i,s1));
			}

		}
		return memo[row][s1][s2]=re;
	}
	public static boolean check(int state)
	{
		for(int i=0;i<n;i++)
		{
			if((state&(1<<i))!=0)
			{
				for(int j=Math.max(0, i-2);j<Math.min(n, i+2);j++)
					if(j!=i&&(state&(1<<j))!=0)
						return false;
			}
		}
		return true;
	}
}
