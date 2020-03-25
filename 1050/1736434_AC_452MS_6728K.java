import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		// InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int p[][] = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				p[i][j] = cin.nextInt();
		int max = matrixMaxSum(p,0,0,n,n);
		
		System.out.println(max);
	}

	public static int matrixMaxSum(int[][] A, int x1, int y1, int x2, int y2)
	{
		int res = Integer.MIN_VALUE;
		int[][][] memo = new int[x2 - x1][y2 - y1][y2 - y1];
		for (int j = 0; j < y2 - y1; j++)
		{
			int t = 0;
			for (int k = 0; k <= j; k++)
			{
				t += A[x1][j + y1 - k];
				memo[0][j][k] = t;
				res = Math.max(res, memo[0][j][k]);
			}
		}
		for (int i = 1; i < x2 - x1; i++)
		{
			for (int j = 0; j < y2 - y1; j++)
			{
				int t = 0;
				for (int k = 0; k <= j; k++)
				{
					t += A[i + x1][j + y1 - k];
					if (memo[i - 1][j][k] < 0)
					{
						memo[i][j][k] = t;
					} else
					{
						memo[i][j][k] = t + memo[i - 1][j][k];
					}
					res = Math.max(res, memo[i][j][k]);
				}
			}
		}
		return res;
	}
}