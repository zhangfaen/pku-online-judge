import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Main
{
	static class Interv implements Comparable<Interv>
	{
		int x,y;
		public Interv(int a,int b)
		{
			x=a;y=b;
		}
		@Override
		public boolean equals(Object obj)
		{
			Interv t=(Interv)obj;
			if(x>=t.x&&y<=t.y||x<=t.x&&y>=t.y)
				return true;
			return false;
			
		}
		@Override
		public int hashCode()
		{
			return 1;
		}
		public int compareTo(Interv o)
		{
			return x-o.x;
		}
		public String toString()
		{
			return x+" "+y;
		}
		
	}
	public static void main(String[] args)throws Exception
	{
		BufferedReader cin=new BufferedReader(new InputStreamReader(System.in));
		String s=cin.readLine();
		String [] sa=s.split(" ");
		int n=Integer.parseInt(sa[0]);
		int t=Integer.parseInt(sa[1]);
		Map<Interv,Integer> si=new HashMap<Interv,Integer>();
		for(int i=0;i<n;i++)
		{
			s=cin.readLine();
			sa=s.split(" ");
			int x=Integer.parseInt(sa[0]);
			int y=Integer.parseInt(sa[1]);
			Interv itv1=new Interv(x,y);
			Integer span=si.get(itv1);
			if(span==null)
			{
				si.put(itv1, y-x);
			}
			else
			{
				if(span<y-x)
				{
					si.remove(itv1);
					si.put(itv1, y-x);
				}
			}
		}
		Interv [] cs=new Interv[si.size()];
		int tag=0;
		for(Interv itv:si.keySet())
		{
			cs[tag++]=itv;
		}
		Arrays.sort(cs);
		if(cs[0].x>1){
			System.out.println(-1);
			return;
		}
		int cmax=cs[0].y;
		n=cs.length;
		int [] p=new int[t+1];
		Arrays.fill(p, -1);
		for(int i=0;i<n;i++)
		{
			p[cs[i].x]=i;
		}
		int re=0;
		for(int i=1;i<=t;)
		{
			if(p[i]!=-1)
			{
				i=cs[p[i]].y+1;
				re++;
			}
			else
			{
				boolean find=false;
				for(int j=i;j>=1;j--)
				{
					if(p[j]!=-1)
					{
						if(cs[p[j]].y<i)break;
						else
						{
							find=true;
							i=cs[p[j]].y+1;
							re++;
							break;
						}
					}
				}
				if(find==false)
				{
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(re);
	}
}
