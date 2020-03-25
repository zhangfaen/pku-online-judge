import java.util.*;
import java.io.*;
public class Main
{
	static int [][] memo;
	static int vlg;
	static int [][] p;
	static int BIG=Integer.MAX_VALUE/2;
	public static void main(String [] args) throws FileNotFoundException
	{
		Scanner cin=new Scanner(System.in);
		vlg=cin.nextInt();
		int post=cin.nextInt();
		int [] map=new int[vlg];
		for(int i=0;i<vlg;i++)
		{
			map[i]=cin.nextInt();
		}
		memo=new int[vlg][post+1];
		for(int i=0;i<vlg;i++)
			for(int j=0;j<post+1;j++)
				memo[i][j]=-1;
		p=new int[vlg][vlg];
		for(int i=0;i<vlg;i++)
			for(int j=i;j<vlg;j++)
			{
				int min=Integer.MAX_VALUE;
				
				for(int k=i;k<=j;k++)
				{
					int sum=0;
					for(int w=i;w<=j;w++)
					{
						sum+=Math.abs(map[w]-map[k]);
					}
					min=Math.min(min, sum);
				}
				p[i][j]=min;
			}
		System.out.println(dp(0,post));
	}
	public static int dp(int index,int post)
	{
		if(index<vlg&&post==0)
			return BIG;
		if(index==vlg&&post==0)
			return 0;
		if(vlg-index<=post)
			return 0;
		if(memo[index][post]!=-1)
			return memo[index][post];
		int re=Integer.MAX_VALUE;
		for(int i=index;i<vlg;i++)
		{
			re=Math.min(re, p[index][i]+dp(i+1,post-1));
		}
		return memo[index][post]=re;
	}
}
