import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
public class Main
{
	static boolean[][] map;
	public static void main(String[] args) throws Exception
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		String s=cin.readLine();
		int ts=Integer.parseInt(s);
		String [] sa=null;
		while(ts--!=0)
		{
			s=cin.readLine();
			sa=s.split(" ");
			int n=Integer.parseInt(sa[0]);
			int m=Integer.parseInt(sa[1]);
			DisjointSet ds=new DisjointSet(n);
			DisjointSet relation=new DisjointSet(n);
			int [] nts=new int[n];
			Arrays.fill(nts, -1);
			while(m--!=0)
			{
				s=cin.readLine();
				sa=s.split(" ");
				int x=Integer.parseInt(sa[1])-1;
				int y=Integer.parseInt(sa[2])-1;
				if(sa[0].equals("D"))
				{
					int nx=nts[x];int ny=nts[y];
					relation.union(x, y);
					if(nx==-1&&ny==-1)
					{
						nts[x]=y;nts[y]=x;
					}
					if(nx==-1&&ny!=-1)
					{
						ds.union(x, ny);
						nts[x]=y;
					}
					if(nx!=-1&&ny==-1)
					{
						ds.union(nx, y);
						nts[y]=x;
					}
					if(nx!=-1&&ny!=-1)
					{
						ds.union(nx, y);
						ds.union(x, ny);
					}
					
				}
				else
				{
					int rx=relation.find(x);
					int ry=relation.find(y);
					String re="";
					if(rx!=ry)
					{
						re="Not sure yet.";
					}
					else
					{
						int sx=ds.find(x);int sy=ds.find(y);
						if(sx==sy)
						{
							re="In the same gang.";
						}
						else
						{
							re="In different gangs.";
						}
					}
					out.println(re);
				}
			}
		}
		out.flush();
	}
}
class DisjointSet
{
	int [] p;
	int n;
	int [] rank;
	public DisjointSet(int n)
	{
		this.n=n;
		p=new int[n];
		rank=new int[n];
		for(int i=0;i<n;i++)
			p[i]=i;
	}
	public void union(int x,int y)
	{
		link(find(x),find(y));
	}
	private void link(int x,int y)
	{
		if(rank[x]>rank[y])
		{
			p[y]=x;
		}
		else
		{
			p[x]=y;
			if(rank[x]==rank[y])
				rank[y]++;
		}
	}
	public int find(int x)
	{
		if(p[x]!=x)
			p[x]=find(p[x]);
		return p[x];
	}
}