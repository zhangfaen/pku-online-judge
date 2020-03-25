import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		while(true)
		{
			int n=cin.nextInt();
			if(n==0)break;
			int [][]p=new int[102][102];
			int [][]q=new int[102][102];
			for(int i=0;i<102;i++)
				for(int j=0;j<102;j++)
					q[i][j]=-1;
			int a,b;
			for(int i=0;i<n;i++)
			{
				a=cin.nextInt();
				b=cin.nextInt();
				p[a][b]=1;	
			}
			h(p,q,1,1);
			System.out.println(q[1][1]);
			
		}
		System.out.println("*");

	}
	private static int h(int [][]p,int [][]q,int x,int y)
	{
		if(x>100||y>100)
			return 0;
		if(q[x][y]>-1)
			return q[x][y];
		int r=0;
		if(p[x][y]==1)
			r++;
		q[x][y]=max(r+h(p,q,x+1,y),r+h(p,q,x,y+1));
		return q[x][y];
	}
	private static int max(int a,int b)
	{
		if(a>b)return a;
		return b;
	}

}
