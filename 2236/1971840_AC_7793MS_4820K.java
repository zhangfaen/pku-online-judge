import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class Main
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String s = cin.readLine();
		String [] sa=s.split(" ");
		int n=Integer.parseInt(sa[0]);
		int d=Integer.parseInt(sa[1]);
		boolean [][] map=new boolean[n][n];
		int [] x=new int[n];
		int [] y=new int[n];
		for(int i=0;i<n;i++)
		{
			s=cin.readLine();
			sa=s.split(" ");
			int a=Integer.parseInt(sa[0]);
			int b=Integer.parseInt(sa[1]);
			x[i]=a;
			y[i]=b;
		}
		for(int i=0;i<n;i++)
			for(int j=i+1;j<n;j++)
			{
				double dis=Math.hypot(x[i]-x[j], y[i]-y[j]);
				if(dis<=d)
					map[i][j]=map[j][i]=true;
			}
		boolean [] good=new boolean[n];
		DisjointSet ds=new DisjointSet(n);
		while(true)
		{
			s=cin.readLine();
			if(s==null)break;
			sa=s.split(" ");
			if(sa[0].equals("O"))
			{
				int w=Integer.parseInt(sa[1])-1;
				good[w]=true;
				for(int i=0;i<n;i++)
					if(good[i]&&map[w][i])
					{
						ds.union(i, w);
					}
			}
			else
			{
				int a=Integer.parseInt(sa[1])-1;
				int b=Integer.parseInt(sa[2])-1;
				if(good[a]&&good[b]&&ds.find(a)==ds.find(b))
					out.println("SUCCESS");
				else
					out.println("FAIL");
			}
		}
		out.flush();
	}
	static  class DisjointSet
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
}
