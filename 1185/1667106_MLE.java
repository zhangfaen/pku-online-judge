import java.io.*;
import java.util.*;
import java.math.*;

public class Main
{
	static int m,n;
	static int [] map;
	static int [][][] memo;
	public static void main(String[] args) throws Exception
	{
		Scanner cin=new Scanner(System.in);
		m=cin.nextInt();
		n=cin.nextInt();
		map=new int[m];
		for(int i=0;i<m;i++)
		{
			String s=cin.next();
			int d=0;
			for(int j=0;j<n;j++)
			{
				if(s.charAt(j)=='H')
					d|=(1<<j);
			}
			map[i]=d;
		}
		memo=new int[m][1<<n][1<<n];
		for(int i=0;i<m;i++)
			for(int j=0;j<(1<<n);j++)
				for(int k=0;k<(1<<n);k++)
					memo[i][j][k]=-1;
//		int [][] p=new int[1<<n][1<<n];
//		int [][] q=new int[1<<n][1<<n];
//		int [][] r=new int[1<<n][1<<n];
//		for(int i=n-1;i>=0;i++)
//		{
//			for(int j=0;j<(1<<n);j++)
//				for(int k=0;k<(1<<n);k++)
//				{
//					if((j&map[i])!=0||(j&k)!=0||check(j)==false)
//						continue;
//					r[0][0]=Math.max(r[0][0], get(j)+get(k)+p[k][j]);
//				}
//			int [][] tmp;
//			tmp=q;q=r;p=tmp;
//		}
		int re=dp(0,0,0);
		System.out.println(re);
	}
	public static boolean check(int d)
	{
		for(int i=0;i<9;i++)
		{
			int x=(1<<i)&d;
			if(x!=0)
			{
				int y=(1<<(i+1))&d;
				int z=(1<<(i+2))&d;
				if(y!=0||z!=0)
					return false;
			}
		}
		return true;
	}
	public static int get(int d)
	{
		int re=0;
		for(int i=0;i<11;i++)
			if(((1<<i)&d)!=0)
				re++;
		return re;
	}

	public static int dp(int row,int s1,int s2)
	{
		if(row==m)
			return 0;
		if(memo[row][s1][s2]!=-1)
			return memo[row][s1][s2];
		int re=0;
		for(int i=0;i<(1<<n);i++)
		{
			if((i&map[row])==0&&(i&s1)==0&&(i&s2)==0&&check(i))
			{
				re=Math.max(re, get(i)+dp(row+1,i,s1));
			}
		}
		return re;
	}
}
