import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		int T=cin.nextInt(),N=cin.nextInt();
		int [][]map=new int[N+1][N+1];
		for(int i=0;i<=N;i++)
			for(int j=0;j<=N;j++)
			{
				if(i!=j)
					map[i][j]=Integer.MAX_VALUE;
				else
					map[i][j]=0;
			}
				
		for(int i=0;i<T;i++)
		{
			int x=cin.nextInt();
			int y=cin.nextInt();
			map[x][y]=map[y][x]=cin.nextInt();
		}
		for(int k=1;k<=N;k++)
			for(int i=1;i<=N;i++)
				for(int j=1;j<=N;j++)
				{
					map[i][j]=min(sum(map[i][k],map[k][j]),map[i][j]);
				}
		System.out.println(map[1][N]);
	}
	private static int sum(int a,int b)
	{
		if(a==Integer.MAX_VALUE||b==Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		return a+b;
	}
	private static int min(int a,int b)
	{
		if(a<b)return a;
		return b;
	}
}