import java.io.*;
import java.util.*;
import java.math.*;

public class Main
{
	static int m,n;
	static int [] map;
	static int [][][] memo;
	static int [] num;
	static int all;
	public static void main(String[] args) throws Exception
	{
//		Date t1=new Date();
		Scanner cin=new Scanner(System.in);
		m=cin.nextInt();
		n=cin.nextInt();
		all=1<<n;
		map=new int[m];
		num=new int[all];
		
		Arrays.fill(num, -1);
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
		//memo=new int[m][all][all];
//		for(int i=0;i<m;i++)
//			for(int j=0;j<(all);j++)
//				for(int k=0;k<(all);k++)
//					memo[i][j][k]=-1;
		int [][] p=new int[all][all];
		int [][] q=new int[all][all];
		for(int i=m-1;i>=0;i--)
		{
			for(int j=0;j<(all);j++)
				for(int k=0;k<(all);k++)
				{
					if((j&k)!=0)
						continue;
					for(int g=0;g<(all);g++)
					{
						if((g&map[i])==0&&(g&j)==0&&(g&k)==0&&check(g))
						{
							q[j][k]=Math.max(q[j][k], get(g)+p[g][j]);
						}
					}
				}
			int [][] tmp;tmp=p;p=q;q=tmp;
		}
		System.out.println(p[0][0]);
//		Date t2=new Date();
//		System.out.println(t2.getTime()-t1.getTime());
	}
	public static int dp(int row,int s1,int s2)
	{
		if(row==m)
			return 0;
		if(memo[row][s1][s2]!=-1)
			return memo[row][s1][s2];
		int re=0;
		for(int i=0;i<(all);i++)
		{
			if((i&map[row])==0&&(i&s1)==0&&(i&s2)==0&&check(i))
			{
				re=Math.max(re, get(i)+dp(row+1,i,s1));
			}
		}
		return re;
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
		if(num[d]!=-1)
			return num[d];
		int re=0;
		for(int i=0;i<11;i++)
			if(((1<<i)&d)!=0)
				re++;
		return num[d]=re;
	}

	
}
