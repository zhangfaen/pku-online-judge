import java.util.*;
import java.io.*;
public class Main
{
	public static int [][] p;
	public static String s,t;
	public static int a,b;
	public static int [][] map={{5,-1,-2,-1,-3},{-1,5,-3,-2,-4},
			{-2,-3,5,-2,-2},{-1,-2,-2,5,-1},{-3,-4,-2,-1,-1000000}};
	public static void main(String [] args) throws Exception
	{
		Scanner cin=new Scanner(System.in);
		int testcase=cin.nextInt();
		while(testcase--!=0)
		{
			a=cin.nextInt();
			s=cin.next();
			b=cin.nextInt();
			t=cin.next();
			p=new int[a+1][b+1];
			for(int i=0;i<=a;i++)
				for(int j=0;j<=b;j++)
					p[i][j]=-10000000;
			System.out.println(f(a,b));
		}
	}
	public static int f(int i,int j)
	{
		if(p[i][j]!=-10000000)
		{
			return p[i][j];
		}
		if(i==0&&j==0)
			return 0;
		if(i==0)
		{
			int sum=0;
			for(int k=0;k<j;k++)
				sum+=getC('-',t.charAt(k));
			return p[i][j]=sum;
		}
		if(j==0)
		{
			int sum=0;
			for(int k=0;k<i;k++)
				sum+=getC(s.charAt(k),'-');
			return p[i][j]=sum;
		}
		int tmax1,tmax2,tmax3,max=-10000000;
		tmax1=f(i,j-1)+getC('-',t.charAt(j-1));
		tmax2=f(i-1,j-1)+getC(s.charAt(i-1),t.charAt(j-1));
		tmax3=f(i-1,j)+getC(s.charAt(i-1),'-');
		max=maxt(tmax1,tmax2,tmax3);
		return p[i][j]=max;
			
	}
	public static int maxt(int a,int b,int c)
	{
		int t;
		if(a>b)
			t=a;
		else
			t=b;
		if(t>c)
			return t;
		else
			return c;
	}
	public static int getC(char c1,char c2)
	{
		int a,b;
		if(c1=='A') a=0;
		else if(c1=='C') a=1;
		else if(c1=='G') a=2;
		else if(c1=='T') a=3;
		else a=4;
		
		if(c2=='A') b=0;
		else if(c2=='C') b=1;
		else if(c2=='G') b=2;
		else if(c2=='T') b=3;
		else b=4;
		return map[a][b];
	}
}
