import java.util.Scanner;
public class Main
{
	static int [][] memo;
	static int n;
	static int [][] map;
	public static void main(String[] args) throws Exception
	{
//		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
//		String s = cin.readLine();
//		String[] sa = s.split(" ");
		Scanner cin=new Scanner(System.in);
		int N =cin.nextInt(); ;
		map = new int[N][N];
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j <= i; j++)
			{
				map[i][j]=cin.nextInt();
			}
		}
		memo=new int[N][N];
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				memo[i][j]=-1;
		n=N;
		int re=dp(0,0);
		System.out.println(re);
	}
	public static int dp(int i,int j)
	{
		if(memo[i][j]!=-1)return memo[i][j];
		if(i==n-1)return map[i][j];
		int re=0;
		if(j<n-1)
			re=Math.max(map[i][j]+dp(i+1,j+1), re);
		re=Math.max(map[i][j]+dp(i+1,j), re);
		return memo[i][j]=re;
	}
}