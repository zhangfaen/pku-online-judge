import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main
{
	static int n,m;
	static int [] p;
	static int [] rela;
	public static void main(String[] args) throws IOException
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String ts=cin.readLine();
		int testcase=Integer.parseInt(ts);
		int tag=0;
		out:while (testcase-->0)
		{
			tag++;
			String s=cin.readLine();
			String [] sa=s.split(" ");
			n=Integer.parseInt(sa[0]);
			m=Integer.parseInt(sa[1]);
			p=new int[n+1];
			rela=new int[n+1];
			for(int i=0;i<n+1;i++)
				p[i]=i;
			for(int i=0;i<m;i++)
			{
				s=cin.readLine();
				sa=s.split(" ");
				int x=Integer.parseInt(sa[0]);
				int y=Integer.parseInt(sa[1]);
				int fx=find(x);
				int fy=find(y);
				if(fx==fy)
				{
					if(rela[x]==rela[y])
					{
						System.out.println("Scenario #"+tag+":");
						System.out.println("Suspicious bugs found!");
						System.out.println();
						for(i++;i<m;i++)
							cin.readLine();
						continue out;
					}
				}
				else
				{
					union(x,y);
				}
			}

			System.out.println("Scenario #"+tag+":");
			System.out.println("No suspicious bugs found!");
			System.out.println();
		}
		out.flush();
		out.close();
	}
	public static int find(int x)
	{
		if(x==p[x])
			return x;
		int root=find(p[x]);
		int rr=(rela[x]+rela[p[x]])%2;
		rela[x]=rr;
		p[x]=root;
		return root;
	}
	
	public static void union(int x,int y)
	{
		int fx=find(x);
		int fy=find(y);
		int xfr=rela[x];
		int yfr=(rela[y]+1)%2;
		if(xfr==yfr)
		{
			rela[fy]=0;
			p[fy]=fx;
		}
		else
		{
			rela[fy]=1;
			p[fy]=fx;
		}
	}
	
}