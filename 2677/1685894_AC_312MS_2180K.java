import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main
{
	static int BIG=Integer.MAX_VALUE/2;
	static double [][]	memo;
	static int n;
	static int [] x;
	static int [] y;
	public static void main(String [] args) throws FileNotFoundException
	{
		Scanner cin=new Scanner(System.in);
		while(cin.hasNextInt())
		{
			n=cin.nextInt()+2;
			memo=new double[n][n];
			x=new int[n];
			y=new int[n];
			for(int i=1;i<n-1;i++)
			{
				x[i]=cin.nextInt();
				y[i]=cin.nextInt();
			}
			x[0]=x[1];y[0]=y[1];
			x[n-1]=x[n-2];y[n-1]=y[n-2];
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					memo[i][j]=-1;
			double re=dp(0,1);
			System.out.printf("%.2f\n",re);
		}
		
	}
	public static double dp(int i,int j)
	{
		if(memo[i][j]!=-1)
			return memo[i][j];
		int next=Math.max(i, j)+1;
		if(next==n)
			return 0;
		double re=Double.MAX_VALUE;
		if(x[next]>x[i])
		{
			re=Math.min(re, dis(next,i)+dp(next,j));
		}
		if(x[next]>x[j])
		{
			re=Math.min(re, dis(next,j)+dp(i,next));
		}
		memo[i][j]=re;
		return re;
	
	}
	public static double dis(int i,int j)
	{
		return Math.hypot((x[i]-x[j]), (y[i]-y[j])	);
	}
}
