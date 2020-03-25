import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main
{
	static int n;
	static int [] p;
	static String os="";
	static int [] sum;
	static int [][] memo;
	static int BIG=Integer.MAX_VALUE/2;
	static char [][] best;
	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String s=in.readLine();
		int ts=Integer.parseInt(s);
		while (ts-->0)
		{
			s=in.readLine();
			n=Integer.parseInt(s);
			p=new int[n];
			s=in.readLine();
			String [] sa=s.split(" ");
			int tot=0;
			sum=new int[n];
			for(int i=0;i<n;i++)
			{
				p[i]=Integer.parseInt(sa[i]);
				tot+=p[i];
				if(i==0)
					sum[i]=p[i];
				else
					sum[i]=sum[i-1]+p[i];
			}
			if(tot%2==1)
			{
				out.println("IMPOSSIBLE");
			}
			else
			{
				memo=new int[n][1001];
				for(int i=0;i<n;i++)
					for(int j=0;j<1001;j++)
						memo[i][j]=-1;
				best=new char[n][1001];
				int re=dp(0,0);
				if(re==BIG)
				{
					out.println("IMPOSSIBLE");
				}
				else
				{
					int ci=0,cy=0;
					while(ci!=n)
					{
						System.out.print(best[ci][cy]);
						if(best[ci][cy]=='U')
						{
							cy+=p[ci];ci++;
						}
						else
						{
							cy-=p[ci];ci++;
						}
					}
					out.println();
				}
			}
			
		}
		out.flush();
		
	}
	public static int dp(int ci,int cy)
	{
		if(ci==n)
		{
			if(cy==0)
				return 0;
			return BIG;
		}
		if(memo[ci][cy]!=-1)
		{
			return memo[ci][cy];
		}
		int re=BIG;
		int d1=BIG,d2=BIG;
		if(cy>=p[ci])
		{
			d1=dp(ci+1,cy-p[ci]);
		}
		d2=dp(ci+1,cy+p[ci]);
		int dm=Math.min(d1, d2);
		if(d1<d2)
		{
			best[ci][cy]='D';
		}
		else
			best[ci][cy]='U';
		if(dm<BIG)
		{
			re=Math.max(dm, cy);
		}
		return memo[ci][cy]=re;
	}
	
}
