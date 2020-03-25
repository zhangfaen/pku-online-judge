import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		// BufferedReader cin = new BufferedReader(new
		// InputStreamReader(System.in));
		Scanner cin = new Scanner(System.in);
		// PrintWriter out = new PrintWriter(System.out);
		out: while (cin.hasNextInt())
		{
			int n = cin.nextInt();
			int[] p = new int[n - 1];
			int[] q = new int[n];
			for (int i = 0; i < n; i++)
				q[i] = cin.nextInt();
			for (int i = 0; i < n - 1; i++)
				p[i] = Math.abs(q[i + 1] - q[i]);
			Arrays.sort(p);
			for (int i = 0; i < n - 1; i++)
			{
				if (p[i] != i + 1)
				{
					System.out.println("Not jolly");
					continue out;
				}
			}
			System.out.println("Jolly");
		}
	}
}
