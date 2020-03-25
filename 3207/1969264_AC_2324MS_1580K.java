import java.io.*;
import java.util.*;
import java.math.*;
public class Main
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();
		String [] sa=s.split(" ");
		int n=Integer.parseInt(sa[0]);
		int m=Integer.parseInt(sa[1]);
		int [] x=new int[m];
		int [] y=new int[m];
		for(int i=0;i<m;i++)
		{
			s=in.readLine();
			sa=s.split(" ");
			int a=Integer.parseInt(sa[0]);
			int b=Integer.parseInt(sa[1]);
			x[i]=Math.min(a, b);
			y[i]=Math.max(a, b);
		}
		boolean re=true;
		out:for(int i=0;i<m;i++)
			for(int j=0;j<m;j++)
				for(int k=0;k<m;k++)
				{
					if(inter(x[i],y[i],x[j],y[j])&&inter(x[i],y[i],x[k],y[k])&&inter(x[j],y[j],x[k],y[k]))
					{
						re=false;
						break out;
					}
				}
		if(re)
			System.out.println("panda is telling the truth...");
		else
			System.out.println("the evil panda is lying again");
	}
	public static boolean inter(int x0,int y0,int x1,int y1)
	{
		if(x1>x0&&x1<y0&&y1>y0||y1>x0&&y1<y0&&x1<x0)return true;
		return false;
	}
}