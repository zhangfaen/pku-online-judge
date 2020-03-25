import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true)
		{
			String s=in.readLine();
			String [] sa=s.split(" ");
			int b,n;
			b=Integer.parseInt(sa[0]);
			n=Integer.parseInt(sa[1]);
			if(b+n==0)break;
			double da=Math.log(b)/Math.log(n);
			int a=(int)da;
			int left=Math.max(0, a-100);
			int right=a+20;
			int res=Integer.MAX_VALUE;
			for(int i=left;i<=right;i++)
			{
				int d=(int)Math.pow(i, n);
				if(Math.abs(d-b)<res)
				{
					res=Math.abs(d-b);
					a=i;
				}
			}
			System.out.println(a);
		}
		out.flush();
	}
	

}
