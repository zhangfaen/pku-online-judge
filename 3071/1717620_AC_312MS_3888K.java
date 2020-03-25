import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

	static int round;
	static int n;
	static double[][] rate;
	static boolean [][][] map;
	static double [][] memo;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// PrintWriter out = new PrintWriter(new
		// OutputStreamWriter(System.out));
		while (true) {
			String s=in.readLine();
			String [] sa=null;
			round=Integer.parseInt(s);
			if(round==-1)
				break;
			n=1<<round;
			rate=new double[n][n];
			for(int i=0;i<n;i++)
			{
				s=in.readLine();
				sa=s.split(" ");
				for(int j=0;j<n;j++)
				{
					rate[i][j]=Double.parseDouble(sa[j]);
				}
			}
			map=new boolean[n][n][round];
			memo=new double[n][round];
			for(int i=0;i<n;i++)
				for(int j=0;j<round;j++)
					memo[i][j]=-1;
			fill(0,n-1,round-1);
			double res=0;
			int mt=-1;
			for(int i=0;i<n;i++)
			{
				double d=dp(i,round-1);
				if(d>res)
				{
					res=d;
					mt=i;
				}
			}
			System.out.println(mt+1);
			//System.out.println(res);
			
		}
	}
	public static double dp(int ct,int cr)
	{
		if(cr<0)
			return 1;
		if(memo[ct][cr]!=-1)
			return memo[ct][cr];
		
		double re=0;
		for(int i=0;i<n;i++)
		{
			if(map[ct][i][cr])
			{
				re+=rate[ct][i]*dp(i,cr-1)*dp(ct,cr-1);
			}
		}
		return memo[ct][cr]=re;
	}
	public static void fill(int low,int high,int cr)
	{
		if(low==high)
			return;
		int mid=(low+high)/2;
		for(int i=low;i<=mid;i++)
			for(int j=mid+1;j<=high;j++)
				map[j][i][cr]=map[i][j][cr]=true;
		fill(low,mid,cr-1);
		fill(mid+1,high,cr-1);
	}
	

}
