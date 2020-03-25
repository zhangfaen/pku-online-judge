import java.util.*;
import java.io.*;
public class Main
{
	private static int [][]p;
	private static int [][]q;
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		int r,c;
		r=cin.nextInt();
		c=cin.nextInt();
		p=new int[r+2][c+2];
		q=new int[r+2][c+2];
		for(int i=0;i<r+2;i++)
			p[i][0]=p[i][c+1]=Integer.MAX_VALUE;
		for(int j=0;j<c+2;j++)
			p[0][j]=p[r+1][j]=Integer.MAX_VALUE;
		for(int i=1;i<=r;i++)
			for(int j=1;j<=c;j++)
			{
				p[i][j]=cin.nextInt();
				q[i][j]=-1;
			}
		int max=-1;
		for(int i=1;i<=r;i++)
			for(int j=1;j<=c;j++)
			{
				if(max<f(i,j))
					max=f(i,j);
			}
		System.out.println(max+1);
	}
	private static int f(int x,int y)
	{
		if(q[x][y]>=0)return q[x][y];
		int a=0,b=0,c=0,d=0;
		if(p[x][y]>p[x-1][y])
			a=1+f(x-1,y);
			
		if(p[x][y]>p[x+1][y])
			b=1+f(x+1,y);
			
		if(p[x][y]>p[x][y+1])
			c=1+f(x,y+1);
			
		if(p[x][y]>p[x][y-1])
			d=1+f(x,y-1);
		int max=-1;
		if(a>max)max=a;
		if(b>max)max=b;
		if(c>max)max=c;
		if(d>max)max=d;
		return p[x][y]=max;
	}
}

