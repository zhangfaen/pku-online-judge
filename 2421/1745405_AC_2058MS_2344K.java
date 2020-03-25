import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public class Main
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		String s=cin.readLine();
		String [] sa=null;
		int vn=Integer.parseInt(s);
		int [][] vmap=new int[vn][vn];
		for(int i=0;i<vn;i++)
		{
			s=cin.readLine();
			sa=s.split(" ");
			for(int j=0;j<vn;j++)
				vmap[i][j]=Integer.parseInt(sa[j]);
		}
		DisjointSet ds=new DisjointSet(vn);
		int Q=Integer.parseInt(cin.readLine());
		for(int i=0;i<Q;i++)
		{
			sa=cin.readLine().split(" ");
			ds.union(Integer.parseInt(sa[0])-1, Integer.parseInt(sa[1])-1);
		}
		Map<Integer,Set<Integer> > pool=new HashMap<Integer,Set<Integer> >();
		for(int i=0;i<vn;i++)
		{
			int f=ds.find(i);
			Set<Integer> v=pool.get(f);
			if(v==null)
			{
				v=new HashSet<Integer>();
				v.add(i);
				v.add(f);
			}
			else
			{
				v.add(i);
			}
			pool.put(f, v);
		}
		int n=pool.size();
		int [][] map=new int[n][n];
		Integer [] keys=new Integer[n];
		pool.keySet().toArray(keys);
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
			{
				if(i==j)continue;
				Set<Integer> si=pool.get(keys[i]);
				Set<Integer> sj=pool.get(keys[j]);
				int dis=Integer.MAX_VALUE;
				for(int x:si)
					for(int y:sj)
					{
						dis=Math.min(dis, vmap[x][y]);
					}
				map[i][j]=dis;
			}
		int re=Kruskal.get(map);
		System.out.println(re);
	}
}
class Kruskal
{
	static class Endge implements Comparable<Endge>
	{
		int x,y;
		int len;
		public Endge(int a,int b,int c)
		{
			x=a;y=b;len=c;
		}
		public int compareTo(Endge o)
		{
			return len-o.len;
		}
	}
	public static int get(int [][] map)
	{
		int n=map.length;
		DisjointSet ds=new DisjointSet(n);
		Endge [] es=new Endge[n*n];
		int tag=0;
		for(int i=0;i<n;i++)
			for(int j=i+1;j<n;j++)
				es[tag++]=new Endge(i,j,map[i][j]);
		Arrays.sort(es,0,tag);
		int re=0;
		int ps=0;
		int s=0;
		while(ps<n-1)
		{
			Endge cur=es[s++];
			if(ds.find(cur.x)!=ds.find(cur.y))
			{
				ds.union(cur.x, cur.y);
				re+=cur.len;
				ps++;
			}
		}
		return re;
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