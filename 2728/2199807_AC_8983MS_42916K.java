import java.io.*;
import java.util.*;
import java.math.*;

public class Main
{
	static BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter out = new PrintWriter(System.out);
	static int n;
	static int[] x;
	static int[] y;
	static int[] z;
	static double[][] map;
	static int[][] cost;
	static double[][] len;

	public static void main(String[] args) throws IOException
	{
		while (true)
		{
			String s = cin.readLine();
			n = Integer.parseInt(s);
			if (n == 0)
				break;
			x=new int[n];
			y=new int[n];
			z=new int[n];
			for(int i=0;i<n;i++)
			{
				s=cin.readLine();
				String [] sa=s.split(" ");
				x[i]=Integer.parseInt(sa[0]);
				y[i]=Integer.parseInt(sa[1]);
				z[i]=Integer.parseInt(sa[2]);
			}
			len=new double[n][n];
			cost=new int[n][n];
			for(int i=0;i<n;i++)
				for(int j=i+1;j<n;j++)
				{
		
						len[j][i]=len[i][j]=Math.hypot(x[i]-x[j], y[i]-y[j]);
						cost[j][i]=cost[i][j]=Math.abs(z[i]-z[j]);
					
				}
			map=new double[n][n];
			double left=0,right=1e10;
			while(right-left>1e-6)
			{
				double mid=(right+left)/2;
				for(int i=0;i<n;i++)
					for(int j=i+1;j<n;j++)
					{
						map[j][i]=map[i][j]=cost[i][j]-mid*len[i][j];
					}
				double best=0;
				double [] ml=new double[n];
				for(int i=1;i<n;i++)
					ml[i]=map[0][i];
				boolean [] vst=new boolean[n];
				vst[0]=true;
				for(int i=1;i<n;i++)
				{
					double tmin=1e50;
					int ti=-1;
					for(int j=0;j<n;j++)
					{
						if(vst[j]==false&&ml[j]<tmin)
						{
							tmin=ml[j];
							ti=j;
						}
					}
					vst[ti]=true;
					best+=tmin;
					for(int j=0;j<n;j++)
						if(vst[j]==false)
							ml[j]=Math.min(ml[j], map[ti][j]);
				}
				if(best>0)
					left=mid;
				else right=mid;
			}
			System.out.printf("%.3f\n",left);
		}
	}
}