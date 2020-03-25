package pku;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main
{
	static BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter out = new PrintWriter(System.out);
	static int INF = Integer.MAX_VALUE / 2;

	public static void main(String[] args) throws Exception
	{
		String s = cin.readLine();
		int testcase = Integer.parseInt(s);
		while (testcase-- > 0)
		{
			s = cin.readLine();
			int n = Integer.parseInt(s);
			int[] hs = new int[n];
			int[] ts = new int[n];
			for (int i = 0; i < n; i++)
			{
				s = cin.readLine();
				String[] sa = s.split(" ");
				hs[i] = Integer.parseInt(sa[0]);
				ts[i] = Integer.parseInt(sa[1]);
			}
			for (int j = 0; j < n; j++)
				for (int k = j + 1; k < n; k++)
				{
					if (hs[j] < hs[k])
					{
						int t = hs[j];
						hs[j] = hs[k];
						hs[k] = t;
						t = ts[j];
						ts[j] = ts[k];
						ts[k] = t;
					}
				}
			int[] sum = new int[n];
			sum[0] = ts[0];
			for (int j = 1; j < n; j++)
				sum[j] = sum[j - 1] + ts[j];
			int maxt = sum[n - 1];
			int [][][] memo=new int[maxt][maxt][n+1];
			int res = Integer.MAX_VALUE;
			for(int j=0;j<maxt;j++)
				for(int k=0;k<maxt;k++)
					memo[j][k][n]=INF;
			memo[0][0][n]=0;
			for (int i = n - 1; i > 0; i--)
			{
				for (int j = 0; j < maxt; j++)
				{
					for (int k = 0; k < maxt; k++)
					{					
						memo[j][k][i]=memo[j][k][i+1];
						if(j>=ts[i])
							memo[j][k][i]=Math.min(memo[j][k][i], memo[j-ts[i]][k][i+1]);
						if(k>=ts[i])
							memo[j][k][i]=Math.min(memo[j][k][i], Math.max(memo[j][k-ts[i]][i+1], hs[i]));
						if(memo[j][k][i]!=INF&&memo[j][k][i]!=0)
						{
							res=Math.min(res, mymax(j,k,maxt-j-k)*(hs[i]+memo[j][k][i]+hs[0]));
						}
					}
				}
			}
			out.println(res);
		}
		out.flush();
		out.close();
	}
	public static int mymax(int a,int b,int c)
	{
		return Math.max(a, Math.max(b, c));
	}
}