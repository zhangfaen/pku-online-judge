

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Main
{
	static int [] p;
	static int [] q;
	public static void main(String[] args) throws Exception
	{
		String re = "";
		BufferedReader cin = new BufferedReader(
			new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String s = cin.readLine();
		int ts = Integer.parseInt(s);
		String[] sa = null;
		while (ts-- != 0)
		{
			s = cin.readLine();
			sa = s.split(" ");
			int n = Integer.parseInt(sa[0]);
			int m = Integer.parseInt(sa[1]);
			p=new int[n];
			q=new int[n];
			for(int i=0;i<n;i++)
				p[i]=i;
			while (m-- != 0)
			{
				s = cin.readLine();
				sa = s.split(" ");
				int x = Integer.parseInt(sa[1]) - 1;
				int y = Integer.parseInt(sa[2]) - 1;
				int xr=find(x),yr=find(y);
				if (sa[0].equals("D"))
				{
					if(xr==yr)
						continue;
					p[yr]=xr;
					q[yr]=(q[x]+1-q[y]+2)%2;
				} else
				{
					if(xr!=yr)
						re = "Not sure yet.";
					else
						if(q[x]==q[y])
							re = "In the same gang.";
						else
							re = "In different gangs.";
					out.println(re);
				}
				
			}
		}
		out.flush();
	}
	public static int find(int x)
	{
		if(p[x]==x)
			return x;
		int root=find(p[x]);
		q[x]=(q[x]+q[p[x]])%2;
		return p[x]=root;
	}
}
