import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Main
{
	public static void main(String [] args) throws IOException
	{
		BufferedReader cin = new BufferedReader(
			new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String s = cin.readLine();
		String [] sa=s.split(" ");
		int n,m;
		n=Integer.parseInt(sa[0]);
		m=Integer.parseInt(sa[1]);
		DisjointSet same=new DisjointSet(n+1);
		DisjointSet relation=new DisjointSet(n+1);
		int [] pre=new int[n+1];
		int [] next=new int[n+1];
		int [] kill=new int[n+1];
		int re=0;
		while(m--!=0)
		{
			s=cin.readLine();
			sa=s.split(" ");
			int or12=Integer.parseInt(sa[0]);
			int x=Integer.parseInt(sa[1]);
			int y=Integer.parseInt(sa[2]);
			if(x>n||y>n||(or12==2&&x==y))
			{
				re++;continue;
			}
			int rlx=relation.find(x),rly=relation.find(y);
			if(rlx!=rly)
			{
				relation.union(x, y);
				if(or12==1)
				{
					int prex=pre[x],prey=pre[y],nextx=next[x],nexty=next[y];
					same.union(x, y);
					if(prex!=0&&prey!=0)
					{
						same.union(prex, prey);
						kill[same.find(prex)]=same.find(x);
					}
					if(prex!=0&&prey==0)
					{
						prey=pre[y]=prex;
						kill[same.find(prex)]=same.find(x);
					}
					if(prex==0&&prey!=0)
					{
						prex=pre[x]=prey;
						kill[same.find(prey)]=same.find(x);
					}
					if(nextx!=0&&nexty!=0)
					{
						same.union(nextx, nexty);
						kill[same.find(x)]=same.find(nextx);
					}
					if(nextx!=0&&nexty==0)
					{
						nexty=next[y]=nextx;
						kill[same.find(x)]=same.find(nextx);
					}
					if(nextx==0&&nexty!=0)
					{
						nextx=next[x]=nexty;
						kill[same.find(x)]=same.find(nexty);
					}
				}
				else
				{
					int prex=pre[x],prey=pre[y],nextx=next[x],nexty=next[y];
					if(nextx==0)
						nextx=next[x]=y;
					same.union(nextx, y);
					kill[same.find(x)]=same.find(y);
					
					if(prey==0)
						prey=pre[y]=x;
					same.union(prey, x);
					kill[same.find(x)]=same.find(y);
					
					if(prex!=0&&nexty==0)
					{
						nexty=next[y]=prex;
						if(pre[prex]==0)
							pre[prex]=y;
						kill[same.find(y)]=same.find(prex);
					}
					if(prex==0&&nexty!=0)
					{
						prex=pre[x]=nexty;
						if(next[nexty]==0)
							next[nexty]=x;
						kill[same.find(nexty)]=same.find(x);
					}
					if(prex!=0&&nexty!=0)
					{
						if(next[nexty]==0)
							next[nexty]=x;
						if(pre[prex]==0)
							pre[prex]=y;
						same.union(prex, nexty);
						kill[same.find(prex)]=same.find(x);
						kill[same.find(y)]=same.find(prex);
					}
					kill[same.find(x)]=same.find(y);
				}
			}
			else
			{
				int sx=same.find(x),sy=same.find(y);
				if(or12==1)
				{
					if(sx!=sy)
						re++;
				}
				else
				{
					if(sx==sy)
						re++;
					if(sx!=sy&&kill[sx]!=sy)
						re++;
				}
			}
		}
		System.out.println(re);
	}
}
class DisjointSet
{
	private int[] p;
	private int n;
	private int[] rank;
	public DisjointSet(int n)
	{
		this.n = n;
		p = new int[n];
		rank = new int[n];
		for (int i = 0; i < n; i++)
			p[i] = i;
	}

	public void union(int x, int y)
	{
		link(find(x), find(y));
	}

	private void link(int x, int y)
	{
		if (rank[x] > rank[y])
		{
			p[y] = x;
		} else
		{
			p[x] = y;
			if (rank[x] == rank[y])
				rank[y]++;
		}
	}

	public int find(int x)
	{
		if (p[x] != x)
			p[x] = find(p[x]);
		return p[x];
	}
}