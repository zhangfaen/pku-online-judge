import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class Main
{
	static int [] map;
	static int [][] p;
	static int n;
	public static void main(String[] args) throws Exception
	{
		Scanner cin = new Scanner(System.in);
		int cs=cin.nextInt();
		while(cs--!=0)
		{
			n=cin.nextInt();
			map=new int[n+1];
			for(int i=1;i<=n;i++)
			{
				map[i]=cin.nextInt();
			}
			p=new int[n+1][n+1];
			for(int i=1;i<=n;i++)
				for(int j=1;j<=n;j++)
					p[i][j]=-1;
			System.out.println(get(1,1));
		}
	}
	public static int get(int a,int b)
	{
		if(a>n||b>n)
			return 0;
		if(p[a][b]!=-1)
			return p[a][b];
		int t=a;
		while(t<=n&&map[t]<b)
			t++;
		if(t<=n)
		{
			return p[a][b]=Math.max(get(t+1,map[t]+1)+1,get(a+1,b));
		}
		return p[a][b]=0;
	}
}



