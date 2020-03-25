import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main
{
	static class Cow implements Comparable<Cow>
	{
		int dis, bad;

		public Cow(int a, int b)
		{
			dis = a;
			bad = b;
		}

		public int compareTo(Cow o)
		{
			long t1=1L*dis*o.bad;
			long t2=1L*bad*o.dis;
			if(t1>t2)return 1;
			if(t1<t2)return -1;
			return dis-o.dis;
		}
	}
	static BufferedReader cin = null;
	static PrintWriter out = new PrintWriter(System.out);
	static int n;
	static Cow [] cs;
	public static void main(String[] args) throws Exception
	{
		cin = new BufferedReader(new InputStreamReader(System.in));
		String s = cin.readLine();
		n = Integer.parseInt(s);
		cs=new Cow[n];
		for (int i = 0; i < n; i++)
		{
			s=cin.readLine();
			StringTokenizer st = new StringTokenizer(s);
			int dis=Integer.parseInt(st.nextToken());
			int bad=Integer.parseInt(st.nextToken());
			cs[i]=new Cow(dis,bad);
		}
		Arrays.sort(cs);
		long [] sum=new long[n];
		sum[0]=cs[0].bad;
		for(int i=1;i<n;i++)
			sum[i]=sum[i-1]+cs[i].bad;
		long cur=0;
		long res=0;
		for(int i=0;i<n;i++)
		{
			res+=(sum[n-1]-sum[i])*cs[i].dis*2;
		}
		System.out.println(res);
	}
}
