import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
public class Main
{
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	public static void main(String[] args) throws Exception
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while (true)
		{
			String s = cin.readLine();
			int n = Integer.parseInt(s);
			if (n == 0)
				break;
			if (n == 1)
				out.println(0);
			else if (n % 2 == 0)
			{
				out.println("No Solution!");
			} else
			{
				out.println(n / 2 + 1);
			}
		}
		out.flush();
	}
}