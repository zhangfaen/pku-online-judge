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
			if(s.equals("*"))break;
			boolean ok=true;
			int n=s.length();
			out:for(int j=1;j<n;j++)
			{
				Set<String> ss=new HashSet<String>();
				for(int i=0;i<n;i++)
				{
					if(i+j>=n)continue;
					String ts=s.charAt(i)+""+s.charAt(i+j);
					if(ss.contains(ts))
					{
						ok=false;
						break out;
					}
					else
						ss.add(ts);
				}
			}
			if(ok)
				System.out.println(s+" is surprising.");
			else
				System.out.println(s+" is NOT surprising.");
		}
		out.flush();
	}
	

}
