import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
public class Main
{
	static int [][] p;
	static int [] map;
	public static void main(String[] args) throws Exception
	{
		Scanner cin = new Scanner(System.in);
		int n=cin.nextInt();
		map=new int[n];
		for(int i=0;i<n;i++)
			map[i]=cin.nextInt();
		p=new int[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				p[i][j]=-1;
		System.out.println(get(0,n-1));
	}
	public static int get(int x,int y)
	{
		if(p[x][y]!=-1)
			return p[x][y];
		if(x+1==y)
			return 0;
		if(x+2==y)
		{
			return p[x][y]=map[x+1]*map[x]*map[y];
		}
		int remin=Integer.MAX_VALUE;
		for(int i=x+1;i<=y-1;i++)
		{
			int t=map[x]*map[y]*map[i];
			t+=get(x,i)+get(i,y);
			if(t<remin)
				remin=t;
		}
		return p[x][y]=remin;
	}
	
}



