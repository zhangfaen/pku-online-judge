import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main
{
	static class Endge
	{
		int index,cost;
		public Endge(int a,int b)
		{
			index=a;
			cost=b;
		}
	}
	static List<Endge> [] lmap;
	static int n;
	public static void main(String[] args) throws Exception
	{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		String s=null;
		String [] sa=null;
		s=in.readLine();
		sa=s.split(" ");
		n=Integer.parseInt(sa[0]);
		int m=Integer.parseInt(sa[1]);
		lmap=new ArrayList[n];
		for(int i=0;i<n;i++)
			lmap[i]=new ArrayList<Endge>(900);
		for(int i=0;i<m;i++)
		{
			s=in.readLine();
			sa=s.split(" ");
			int a=Integer.parseInt(sa[0])-1;
			int b=Integer.parseInt(sa[1])-1;
			int c=Integer.parseInt(sa[2]);
			lmap[a].add(new Endge(b,c));
		}
		
		int [] pool=new int[n];
		Arrays.fill(pool, Integer.MAX_VALUE);
		List<Integer> q=new LinkedList<Integer>();
		q.add(0);
		pool[0]=0;
		int [] ps=new int[n];
		ps[0]++;
		while(q.size()>0)
		{
			int ci=q.remove(0);
			ps[ci]--;
			if(ps[ci]>0)continue;
			int cc=pool[ci];
			for(int i=0;i<lmap[ci].size();i++)
			{
				int nt=lmap[ci].get(i).index;
				int c=lmap[ci].get(i).cost;
				if(cc+c<pool[nt])
				{
					pool[nt]=cc+c;
					ps[nt]++;
					q.add(nt);
				}
			}
		}
		
		
		int re=pool[n-1];
		System.out.println(re);
	}
	public static int st()
	{
		int re=0;
		int [] pool=new int[n];
		Arrays.fill(pool,Integer.MAX_VALUE);
		boolean [] vst=new boolean[n];
		pool[0]=0;
		int cur=0;
		while(cur!=n-1)
		{
			int min=Integer.MAX_VALUE;
			int ni=-1;
			for(int i=0;i<n;i++)
			{
				if(vst[i]==false&pool[i]<min)
				{
					min=pool[i];
					ni=i;
				}
			}
			if(ni==-1)
				break;
			vst[ni]=true;
			cur=ni;
			for(int j=0;j<lmap[ni].size();j++)
			{
				int d=lmap[ni].get(j).index;
				int c=lmap[ni].get(j).cost;
				if(pool[ni]+c<pool[d])
				{
					pool[d]=pool[ni]+c;
				}
			}
		}
		return pool[n-1];
	}

	
}