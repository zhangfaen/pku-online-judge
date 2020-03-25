import java.io.*;
import java.util.*;
import java.math.*;

public class Main
{

	static int[][] map = new int[1001][1001];

	static int n, m;

	public static void main(String[] args) throws IOException
	{
		// BufferedWriter bw=new BufferedWriter(new FileWriter("c:\\out.txt"));
		// for(int i=1;i<=1000;i++)
		// bw.write(i+" "+(i+1)+"\r\n");
		// bw.close();
		Scanner cin = new Scanner(System.in);
		int T = cin.nextInt();
		dd: while (T-- != 0)
		{
			n = cin.nextInt();
			m = cin.nextInt();
			for (int i = 0; i <= n; i++)
				for (int j = 0; j <= n; j++)
					map[i][j] = 1000000;
			for (int i = 0; i <= n; i++)
				map[i][i] = 0;
			for (int i = 0; i < m; i++)
			{
				int a, b;
				a = cin.nextInt();
				b = cin.nextInt();
				map[a][b] = 1;
			}
			for (int k = 1; k <= n; k++)
				for (int i = 1; i <= n; i++)
					for (int j = 1; j <= n; j++)
						map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
			//System.out.println(map[1][2]);
			for(int i=1;i<=n;i++)
				for(int j=1;j<=n;j++)
					if(map[i][j]>=1000000&&map[j][i]>=1000000)
					{
						System.out.println("No");
						continue dd;
					}
			System.out.println("Yes");
		}

	}

}
