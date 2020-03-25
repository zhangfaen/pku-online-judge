import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Main
{
	static class NL implements Comparable<NL>
	{
		public int d,len,f;
		public NL(int a,int b,int c)
		{
			d=a;len=b;f=c;
		}
		public int compareTo(NL o)
		{
			if(f!=o.f)
				return o.f-f;
			if(len!=o.len)
				return o.len-len;
			return o.d-d;
		}
	}
	public static void main(String[] args) throws Exception
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		String s = cin.readLine();
		int A=Integer.parseInt(s);
		int B=Integer.parseInt(cin.readLine());
		int n=Integer.parseInt(cin.readLine());
		s=cin.readLine();
		int [][]memo=new int[1<<B][B+1];
		
		for(int i=0;i<s.length();i++)
		{
			for(int j=i+A;j<=i+B&&j<s.length();j++)
			{
				String t=s.substring(i,j);
				int d=Integer.parseInt(t,2);
				memo[d][t.length()]++;
			}
		}
		NL [] nls=new NL[(1<<B)*(B+1)];
		int tag=0;
		for(int i=0;i<(1<<B);i++)
			for(int j=0;j<(B+1);j++)
				nls[tag++]=new NL(i,j,memo[i][j]);
		Arrays.sort(nls);
		out.print(nls[0].f+" "+gets(nls[0].d,nls[0].len));
		int curf=nls[0].f;
		int count=0;
		for(int i=1;i<tag;i++)
		{
			if(nls[i].f==0)
				break;
			if(nls[i].f==curf)
			{
				out.print(" "+gets(nls[i].d,nls[i].len));
			}
			else
			{
				curf=nls[i].f;
				out.println();
				count++;
				if(count==n)break;
				out.print(nls[i].f+" "+gets(nls[i].d,nls[i].len));
			}
		}
		out.flush();
	}
	public static String gets(int d,int len)
	{
		String re=Integer.toBinaryString(d);
		while(re.length()<len)re="0"+re;
		return re;
	}

	
}
