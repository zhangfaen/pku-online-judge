import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main
{
	static long[][][][][][][] memo;
	static int n;

	public static void main(String[] args) throws IOException
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while (true)
		{
			String s = cin.readLine();
			n = Integer.parseInt(s);
			if (n == -1)
				break;
			memo = new long[4][n][2][2][2][2][2];
			for (int i = 0; i < 4; i++)
				for (int j = 0; j < n; j++)
					for (int p = 0; p < 2; p++)
						for (int q = 0; q < 2; q++)
							for (int x = 0; x < 2; x++)
								for (int y = 0; y < 2; y++)
									memo[i][j][p][q][x][y][0] = memo[i][j][p][q][x][y][1] = -1;
			
			long re=0;
			re+=dp(0,1,1,0,0,0,0);
			re+=dp(1,1,0,1,0,0,0);
			re+=dp(2,1,0,0,1,0,0);
			re+=dp(3,1,0,0,0,1,0);
			System.out.println(n+": "+re);
		}
		out.flush();
		out.close();
	}

	public static long dp(int pn,int ci,int in0,int in1,int in2,int in3,int dif3)
	{
		int cnt=in0+in1+in2+in3;
		if(ci==n)
		{
			if(cnt>=3&&dif3==1)
				return 1;
			return 0;
		}
		long re=memo[pn][ci][in0][in1][in2][in3][dif3];
		if(re!=-1)return re;
		re=0;
		if(cnt>=3&&dif3==1)
		{
			return (long)Math.pow(4, n-ci);
		}
		re+=dp(0,ci+1,1,in1,in2,in3,dif3==1?1:(Math.abs(pn-0)==3?1:0));
		re+=dp(1,ci+1,in0,1,in2,in3,dif3==1?1:(Math.abs(pn-1)==3?1:0));
		re+=dp(2,ci+1,in0,in1,1,in3,dif3==1?1:(Math.abs(pn-2)==3?1:0));
		re+=dp(3,ci+1,in0,in1,in2,1,dif3==1?1:(Math.abs(pn-3)==3?1:0));
		memo[pn][ci][in0][in1][in2][in3][dif3]=re;
		return re;
		
	}
}