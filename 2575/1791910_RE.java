import java.io.PrintWriter;
import java.util.Scanner;

public class Main
{

	
	public static void main(String[] args) throws Exception
	{
		//BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		Scanner cin=new Scanner(System.in);
		out:while(cin.hasNextInt())
		{
			int n=cin.nextInt();
			int [] p=new int[n];
			int cur=cin.nextInt();
			if(n==1)
			{
				if(cur==1)
					out.println("Jolly");
				else out.println("Not jolly");
				for(int i=2;i<=n;i++)
					cin.nextInt();
				continue out;
			}
			boolean ok=true;
			for(int i=2;i<=n;i++)
			{
				int nc=cin.nextInt();
				int dif=Math.abs(nc-cur);
				if(dif<=0||dif>n-1)
				{
					ok=false;
				}
				cur=nc;
				p[dif]++;
			}
			if(ok==false)
			{
				out.println("Not jolly");
				continue out;
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
