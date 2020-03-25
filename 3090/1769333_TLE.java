import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class Main
{

	public static void main(String[] args)throws Exception
	{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int ts=Integer.parseInt(in.readLine());
		int tag=0;
		while(ts-->0)
		{
			tag++;
			int n=Integer.parseInt(in.readLine());
			int re=0;
			for(int i=1;i<=n;i++)
				for(int j=i+1;j<=n;j++)
				{
					int fac=gcd(i,j);
					if(fac==1)
						re++;
				}
			re*=2;
			re+=3;
			out.println(tag+" "+n+" "+re);
		}
		out.flush();
	}
	public static int gcd(int a,int b)
	{
		if(a==0)
			return b;
		return gcd(b%a,a);
	}
}
