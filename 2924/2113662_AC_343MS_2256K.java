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
		String s=cin.readLine();
		int tag=0;
		int ts=Integer.parseInt(s);
		while (ts-->0)
		{
			tag++;
			s=cin.readLine();
			String [] sa=s.split(" ");
			long n=Integer.parseInt(sa[0]);
			long m=Integer.parseInt(sa[1]);
			long re=(n+m)*(Math.abs(m-n)+1)/2;
			System.out.println("Scenario #"+tag+":");
			System.out.println(re);
			System.out.println();
		}
		out.flush();
		out.close();
	}
}