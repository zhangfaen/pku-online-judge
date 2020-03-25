import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main
{
	static int n, m;
	static char[][] map;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		out:while (true)
		{
			String s = cin.readLine();
			int n = Integer.parseInt(s);
			if (n == 0)
				break;
			int [][] map=new int[n][n];
			for(int i=0;i<n;i++)
			{
				s=cin.readLine();
				String [] sa=s.split(" ");
				for(int j=0;j<n;j++)
					map[i][j]=Integer.parseInt(sa[j]);
			}
			for(int i=0;i<n-1;i++)
				for(int j=0;j<n-1;j++)
				{
					int d0=map[i][j];
					int d1=map[i+1][j+1];
					int d2=map[i+1][j];
					int d3=map[i][j+1];
					if(d0+d1!=d2+d3)
					{
						System.out.println("not homogeneous");
						continue out;
					}
				}
			System.out.println("homogeneous");
		}
		out.flush();
		out.close();
	}
}