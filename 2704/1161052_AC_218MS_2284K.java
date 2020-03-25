import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Main
{
	static int n;
	static int[][] map;
	static long[][] p;
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner cin = new Scanner(System.in);
		while (true)
		{
			n = cin.nextInt();
			if (n == -1)
				break;
			map = new int[n][n];
			p = new long[n][n];
			for (int i = 0; i < n; i++)
			{
				String s=cin.next();
				for (int j = 0; j < n; j++)
				{
					map[i][j] = s.charAt(j)-'0';
					p[i][j] = -1;
				}
			}
				
			System.out.println(f(0,0));
			
		}
	}
	public static long f(int x,int y)
	{
		if(p[x][y]!=-1)
			return p[x][y];
		if(x==n-1&&y==n-1)
			return 1;
		if(map[x][y]==0)
			return 0;
		long re=0;
		if(x+map[x][y]<n)
			re+=f(x+map[x][y],y);
		if(y+map[x][y]<n)
			re+=f(x,y+map[x][y]);
		return p[x][y]=re;
	}
}
