import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args) throws Exception
	{
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt();
		int [][] pmap=new int[n][n];
		int [][] out=new int[n][n];
		for(int i=0;i<n;i++)
		{
			String s=cin.next();
			for(int j=0;j<n;j++)
			{
				char c=s.charAt(j);
				if(c=='*')
					pmap[i][j]=-1;
					
			}
		}
		f(pmap,n);
		boolean ok=true;
		for(int i=0;i<n;i++)
		{
			String s=cin.next();
			for(int j=0;j<n;j++)
			{
				char c=s.charAt(j);
				if(c=='x'&&pmap[i][j]==-1)
					ok=false;
				if(c=='x')
					out[i][j]=1;
				else
					out[i][j]=-1;
			}
		}
		if(ok)
		{
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					if(out[i][j]==1)
						System.out.print(pmap[i][j]);
					else
						System.out.print('.');
				}
				System.out.println();
			}
		}
		else
		{
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					if(pmap[i][j]==-1)
						System.out.print('*');
					else
					if(out[i][j]==1)
						System.out.print(pmap[i][j]);
					else
						System.out.print('.');
				}
				System.out.println();
			}
		}
	}
	public static void f(int [][]p,int n)
	{
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(p[i][j]==-1)
				{
					int x=i,y=j;
					x=i;y=j;
					x=i+1;
					if(x<n&&p[x][y]>=0)
						p[x][y]++;
					
					x=i;y=j;
					x=i-1;
					if(x>=0&&p[x][y]>=0)
						p[x][y]++;
					
					x=i;y=j;
					y=j-1;
					if(y>=0&&p[x][y]>=0)
						p[x][y]++;
					
					x=i;y=j;
					y=j+1;
					if(y<n&&p[x][y]>=0)
						p[x][y]++;
					
					x=i;y=j;
					x=i+1;y=j+1;
					if(x<n&&y<n&&p[x][y]>=0)
						p[x][y]++;
					
					x=i;y=j;
					x=i-1;y=j-1;
					if(x>=0&&y>=0&&p[x][y]>=0)
						p[x][y]++;
					
					x=i;y=j;
					x=i-1;y=j+1;
					if(x>=0&&y<n&&p[x][y]>=0)
						p[x][y]++;
					
					x=i;y=j;
					x=i+1;y=j-1;
					if(x<n&&y>=0&&p[x][y]>=0)
						p[x][y]++;
				}
			}
		}
	}
}
