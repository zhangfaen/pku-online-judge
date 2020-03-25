import java.util.*;
import java.io.*;

public class Main
{
	static int [] xs;
	static int [] ys;
	public static void main(String[] args) throws Exception
	{
		Scanner cin=new Scanner(System.in);
		int scen=0;
		while(true)
		{
			int n=cin.nextInt();
			if(n==0)
				break;
			scen++;
			xs=new int[n];
			ys=new int[n];
			for(int i=0;i<n;i++)
			{
				xs[i]=cin.nextInt();
				ys[i]=cin.nextInt();
			}
			double [] p=new double[n];
			Arrays.fill(p, Double.MAX_VALUE);
			p[0]=0;
			boolean [] vst=new boolean[n];
			while(true)
			{
				double tmin=Double.MAX_VALUE;
				int next=-1;
				boolean find=false;
				for(int i=0;i<n;i++)
				{
					if(vst[i]==false&&tmin>p[i])
					{
						tmin=p[i];
						next=i;
						find=true;
					}
				}
				if(find==false)break;
				vst[next]=true;
				for(int i=0;i<n;i++)
				{
					if(vst[i]==false)
					{
						p[i]=Math.min(p[i], Math.max(p[next], getDis(next,i)));
					}
				}
			}
			double res=p[1];
			System.out.println("Scenario #"+scen);
			System.out.printf("Frog Distance = %.3f\n\n",res);
		}
		
		
	}
	public static double getDis(int i,int j)
	{
		double res=Math.hypot(xs[i]-xs[j], ys[i]-ys[j]);
		return res;
	}

}