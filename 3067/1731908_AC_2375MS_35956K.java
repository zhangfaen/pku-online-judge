import java.io.*;
import java.util.*;
import java.math.*;
public class Main
{
	static int M,N;
	static long [][] sum;
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
			sum=new long[M][N];
			sum[M-1][0]=map[M-1][0];
			for(int i=M-1;i>=0;i--)
			{
				int js=0;
				if(i==M-1)js=1;
				for(int j=js;j<N;j++)
				{
					long re=0;
					re+=map[i][j];
					if(i+1<M)
						re+=sum[i+1][j];
					if(j>0)
						re+=sum[i][j-1];
					if(i+1<M&&j>0)
						re-=sum[i+1][j-1];
					sum[i][j]=re;
				}
			}
			long re=0;
			for(int i=0;i<M;i++)
				for(int j=0;j<N;j++)
				{
					if(map[i][j]==1&&i+1<M&&j>0)
					{
						re+=sum[i+1][j-1];
					}
				}
			System.out.printf("Test case %d: %d\n",go,re);
		}
		
	}
	
}