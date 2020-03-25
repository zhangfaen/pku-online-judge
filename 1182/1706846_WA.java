
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Main
{
	static int [] p;
	static int [] q;
	static int [] rank;
	static int n;
	public static void main(String [] args) throws IOException
	{
		BufferedReader cin = new BufferedReader(
			new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String s = cin.readLine();
		String [] sa=s.split(" ");
		int m;
		n=Integer.parseInt(sa[0]);
		m=Integer.parseInt(sa[1]);
		p=new int[n];
		q=new int[n];
		rank=new int[n];
		for(int i=0;i<n;i++)
			p[i]=i;
		int re=0;
		while(m--!=0)
		{
			s=cin.readLine();
			sa=s.split(" ");
			int type=Integer.parseInt(sa[0]);
			int x=Integer.parseInt(sa[1])-1;
			int y=Integer.parseInt(sa[2])-1;
			if(x>=n||y>=n||(type==2&&x==y))
			{
				re++;continue;
			}
			int xr=find(x),yr=find(y);
			if(xr!=yr)
			{
				if(rank[xr]<rank[yr])
				{
					int t=xr;xr=yr;yr=t;
				}
				if(rank[xr]==rank[yr])
					rank[xr]++;
				if(type==2)
				{
					p[yr]=xr;
					q[yr]=(q[x]+1-q[y]+3)%3;
				}
				else
				{
					p[yr]=xr;
					q[yr]=(q[x]-q[y]+3)%3;
				}
				
			}
			else
			{
				if(type==2)
				{
					if((q[x]+1)%3!=q[y])
						re++;
				}
				else
				{
					if(q[x]!=q[y])
						re++;
				}
			}
		}
		System.out.println(re);
	}
	public static int find(int x)
	{
		if(p[x]==x)
			return x;
		int root=find(p[x]);
		q[x]=(q[x]+q[p[x]])%3;
		p[x]=root;
		return root;
	}
}