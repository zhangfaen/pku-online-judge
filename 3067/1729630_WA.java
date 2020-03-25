import java.io.*;
import java.util.*;
import java.math.*;
public class Main
{
	static int M,N;
	static int [][] sum;
	static int [][] map;
	public static void main(String[] args)throws Exception
	{

		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		String s=null;
		String [] sa=null;
		int tc=Integer.parseInt(in.readLine());
		for(int go=1;go<=tc;go++)
		{
			s=in.readLine();
			sa=s.split(" ");
			M=Integer.parseInt(sa[0]);
			N=Integer.parseInt(sa[1]);
			int K=Integer.parseInt(sa[2]);
			map=new int[M][N];
			while(K--!=0)
			{
				s=in.readLine();
				sa=s.split(" ");
				int a=Integer.parseInt(sa[0])-1;
				int b=Integer.parseInt(sa[1])-1;
				map[a][b]=1;
			}
			sum=new int[M][N];
			for(int i=0;i<M;i++)
				for(int j=0;j<N;j++)
					sum[i][j]=-1;
			sum[M-1][0]=map[M-1][0];
			dp(0,N-1);
			int re=0;
			for(int i=0;i<M;i++)
				for(int j=0;j<N;j++)
				{
					if(map[i][j]==1&&i+1<M&&j>0)
					{
						re+=sum[i+1][j-1];
					}
				}
			System.out.printf("Test case %d: %d",go,re);
		}
		
	}
	public static int dp(int ci,int cj)
	{
		if(sum[ci][cj]!=-1)
			return sum[ci][cj];
		int re=0;
		re+=map[ci][cj];
		if(ci+1<M)
			re+=dp(ci+1,cj);
		if(cj>0)
			re+=dp(ci,cj-1);
		if(ci+1<M&&cj>0)
			re-=dp(ci+1,cj-1);
		return sum[ci][cj]=re;
	}
	
	
}