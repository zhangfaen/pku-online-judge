
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
	static int n;
	static long c;
	static long [][][] memo;
	public static void main(String[] args) throws Exception
	{
		// BufferedReader cin=new BufferedReader(new
		// InputStreamReader(System.in));
		// PrintWriter out=new PrintWriter(System.out);
		Scanner cin = new Scanner(System.in);
		int testcase=cin.nextInt();
		n=20;
		memo=new long[2][n][1<<16];
		while(testcase-->0)
		{
			n=cin.nextInt();
			c=cin.nextLong();
		}
	}
}
