import java.io.*;
import java.util.*;
import java.math.*;

public class Main
{
	static int n,m;
	static int [] map;
	static int [][] memo;
	static int [][] back;
	static int BIG=Integer.MAX_VALUE/2;
	static int [][] which;
	public static void main(String[] args) throws Exception
	{
		Scanner cin=new Scanner(System.in);
		int tag=0;
		while(true)
		{
			n=cin.nextInt();
			m=cin.nextInt();
			if(n+m==0)break;
			tag++;
			map=new int[n];
			for(int i=0;i<n;i++)
				map[i]=cin.nextInt();
			memo=new int[n][m+1];
			back=new int[n][m+1];
			which=new int[n][n];
			for(int i=0;i<n;i++)
				for(int j=0;j<m+1;j++)
					memo[i][j]=-1;
			int re=dp(0, m);
			System.out.println("Chain "+tag);
			int ci=0,cl=m;
			while(true)
			{
				int t=back[ci][cl];
				System.out.printf("Depot %d at restaurant %d serves restaurants %d to %d\n",m-cl+1,which[ci][t]+1,ci+1,t+1);
				ci=t+1;cl--;
				if(t==n-1)break;
			}
			System.out.println("Total distance sum = "+re);
		}
	}
	public static int dp(int index,int left)
	{
		if(n==index&&left==0)
			return 0;
		if(index<n&&left==0)
			return BIG;
		if(memo[index][left]!=-1)
			return memo[index][left];
		int re=BIG;
		for(int i=index;i<=n-left;i++)
		{
			int d=get(index,i)+dp(i+1,left-1);
			if(d<re)
			{
				re=d;
				back[index][left]=i;
			}
		}
		return memo[index][left]=re;
	}
	public static int get(int i,int j)
	{
		if(i==j)
		{
			which[i][j]=i;
			return 0;
		}
		int m1=(i+j)/2;
		int m2=(i+j)/2+1;
		int sum1=0,sum2=0;
		for(int a=i;a<m1;a++)
			sum1+=Math.abs(map[a]-map[m1]);
		for(int a=m1+1;a<=j;a++)
			sum1+=Math.abs(map[a]-map[m1]);
		for(int a=i;a<m2;a++)
			sum2+=Math.abs(map[a]-map[m2]);
		for(int a=m2+1;a<=j;a++)
			sum2+=Math.abs(map[a]-map[m2]);
		if(sum1<sum2)
		{
			which[i][j]=m1;
			return sum1;
		}
		else
		{
			which[i][j]=m2;
			return sum2;
		}
		
	}

}
