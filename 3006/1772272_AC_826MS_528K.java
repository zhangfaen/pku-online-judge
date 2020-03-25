import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while (true)
		{
			String s = in.readLine();
			String[] sa = s.split(" ");
			int a = Integer.parseInt(sa[0]);
			int d = Integer.parseInt(sa[1]);
			int n = Integer.parseInt(sa[2]);
			if (a + d + n == 0)
				break;
			int tag=0;
			int cur=a;
			while(true)
			{
				if(isPrime(cur))
					tag++;
				if(tag==n)break;
				cur+=d;
			}
			out.println(cur);
		}
		out.flush();
	}
	public static boolean isPrime(int n)
	{
		if(n==0||n==1)
			return false;
		if(n==2)
			return true;
		if(n%2==0)
			return false;
		int sqrt=(int)Math.sqrt(n);
		for(int i=3;i<=sqrt;i+=2)
		{
			if(n%i==0)
				return false;
		}
		return true;
	}
}
