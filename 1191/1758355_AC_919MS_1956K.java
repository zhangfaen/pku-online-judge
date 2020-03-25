import java.util.Scanner;


public class Main
{
	static int [][] map=new int[8][8];
	static int [][][][]sum=new int[8][8][8][8];
	static int BIG=Integer.MAX_VALUE/2;
	static int [][][][][] memo;
	public static void main(String []args)
	{
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt();
		for(int i=0;i<8;i++)
			for(int j=0;j<8;j++)
				map[i][j]=cin.nextInt();
		for(int i=0;i<8;i++)
			for(int j=0;j<8;j++)
				for(int x=i;x<8;x++)
					for(int y=j;y<8;y++)
					{
						int ts=0;
						for(int p=i;p<=x;p++)
							for(int q=j;q<=y;q++)
								ts+=map[p][q];
						sum[i][j][x][y]=ts;
					}
		memo=new int[8][8][8][8][n];
		for(int i=0;i<8;i++)
			for(int j=0;j<8;j++)
				for(int x=i;x<8;x++)
					for(int y=j;y<8;y++)
						for(int d=0;d<n;d++)
							memo[i][j][x][y][d]=-1;
		int re=dp(0,0,7,7,n-1);
		int d=sum[0][0][7][7];
		double fq=re-1.0*d*d/n;
		fq/=n;
		fq=Math.sqrt(fq);
		System.out.printf("%.3f\n",fq);
		
	}
	public static int dp(int x0,int y0,int x1,int y1,int d)
	{
		if(d==0)
		{
			return pf(sum[x0][y0][x1][y1]);
		}
		if(memo[x0][y0][x1][y1][d]!=-1)
			return memo[x0][y0][x1][y1][d];
		int re=BIG;
		for(int i=x0;i<x1;i++)
		{
			int tre=pf(sum[x0][y0][i][y1]);
			tre+=dp(i+1,y0,x1,y1,d-1);
			re=Math.min(re, tre);
			tre=pf(sum[i+1][y0][x1][y1]);
			tre+=dp(x0,y0,i,y1,d-1);
			re=Math.min(re, tre);
		}
		for(int j=y0;j<y1;j++)
		{
			int tre=pf(sum[x0][y0][x1][j]);
			tre+=dp(x0,j+1,x1,y1,d-1);
			re=Math.min(re, tre);
			tre=pf(sum[x0][j+1][x1][y1]);
			tre+=dp(x0,y0,x1,j,d-1);
			re=Math.min(re, tre);
		}
		return  memo[x0][y0][x1][y1][d]=re;
	}
	public static int pf(int a)
	{
		return a*a;
	}
}
