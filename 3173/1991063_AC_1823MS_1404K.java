import java.util.Scanner;
public class Main
{
	public static void main(String[] args) throws Exception
	{
//		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
//		String s = cin.readLine();
//		String[] sa = s.split(" ");
		Scanner cin=new Scanner(System.in);
		int N =cin.nextInt(); ;
		int S = cin.nextInt();
		int[][] map = new int[N][N];
		int tag = S;
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j <= i; j++)
			{
				map[j][i] = tag;
				tag++;
				if(tag==10)tag=1;
			}
		}
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < N; j++)
				if (map[i][j] != 0)
					System.out.print(map[i][j] + " ");
				else System.out.print("  ");
			System.out.println();
		}
	}
}