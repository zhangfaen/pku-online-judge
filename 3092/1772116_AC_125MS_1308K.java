import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main
{
	static class Ele
	{
		int a, b;
		public Ele(int a, int b)
		{
			this.a = a;
			this.b = b;
		}
		public String toString()
		{
			return "[" + a + "," + b + "]";
		}
	}
	static List<Ele> p = new LinkedList<Ele>();
	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String s = in.readLine();
		int ts = Integer.parseInt(s);
		int count = 0;
		while (ts-- > 0)
		{
			count++;
			s = in.readLine();
			int n = Integer.parseInt(s);
			p.clear();
			dfs(n, 0);
			out.print(count + " " + p.size() + " ");
			for (Ele e : p)
				out.print(e + " ");
			out.println();
			out.flush();
		}
	}

	public static void dfs(int rest, int s2)
	{
		if(rest==0)return;
		if (rest == 1)
		{
			p.add(new Ele(s2, 0));
			return;
		}
		if (rest % 2 == 0)
		{
			dfs(rest / 2, s2 + 1);
		} else
		{
			int s3 = log3(rest);
			p.add(new Ele(s2, s3));
			dfs(rest - pow3(s3), s2);
		}
	}

	public static int log3(int n)
	{
		long t = 1;
		int re = 0;
		while (t <= n)
		{
			re++;
			t *= 3;
		}
		return re - 1;
	}

	public static int pow3(int z)
	{
		int re = 1;
		for (int i = 0; i < z; i++)
			re *= 3;
		return re;
	}
}
