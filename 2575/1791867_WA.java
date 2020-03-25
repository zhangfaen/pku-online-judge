import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Main
{

	
	public static void main(String[] args) throws Exception
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		out:while(true)
		{
			String s=cin.readLine();
			if(s==null||s.trim().equals(""))break;
			s=s.trim();
			String [] sa=s.split(" +");
			int n=Integer.parseInt(sa[0]);
			int [] p=new int[n];
			int cur=Integer.parseInt(sa[1]);
			if(n==1)
			{
				if(cur==1)
					out.println("Jolly");
				else out.println("Not jolly");
				continue out;
			}
			for(int i=2;i<=n;i++)
			{
				int nc=Integer.parseInt(sa[i]);
				int dif=Math.abs(nc-cur);
				if(dif<=0||dif>n-1)
				{
					out.println("Not jolly");
					continue out;
				}
				cur=nc;
				p[dif]++;
			}
			for(int i=1;i<n;i++)
				if(p[i]!=1)
				{
					out.println("Not jolly");
					continue out;
				}
			
			out.println("Jolly");
		}
		
		out.flush();
	}
	

	
}
