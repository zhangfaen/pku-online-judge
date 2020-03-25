import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Main
{
	static class T implements Comparable<T>
	{
		int ci,cmax;
		public T(int a,int b)
		{
			ci=a;cmax=b;
		}
		public int compareTo(T o)
		{
			if(cmax!=o.cmax)
				return cmax-o.cmax;
			return ci-o.ci;
		}
		public String toString()
		{
			return "ci:"+ci+" cmax:"+cmax;
		}
	}
	static int n;
	static LinkedList<Integer> [] map;
	static HashMap<Integer,Integer> [] memo;
	public static void main(String [] args)throws Exception
	{
		BufferedReader cin=new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader cin=new BufferedReader(new FileReader("c:\\out.txt"));
		PrintWriter out=new PrintWriter(System.out);
		String s=null;
		String [] sa=null;
		s=cin.readLine();
		int ts=Integer.parseInt(s);
		while(ts-->0)
		{
			s=cin.readLine();
			n=Integer.parseInt(s);
			map=new LinkedList[n];
			for(int i=0;i<n;i++)
				map[i]=new LinkedList<Integer>();
			memo=new HashMap[n];
			for(int i=0;i<n;i++)
				memo[i]=new HashMap<Integer,Integer>();
			for(int i=0;i<n-1;i++)
			{
				s=cin.readLine();
				sa=s.split(" ");
				int a=Integer.parseInt(sa[0])-1;
				int b=Integer.parseInt(sa[1])-1;
				map[a].add(b);
				map[b].add(a);
			}
			T [] res=new T[n];
			for(int i=0;i<n;i++)
			{
				int tmax=Integer.MIN_VALUE;
				for(int j=0;j<map[i].size();j++)
				{
					tmax=Math.max(tmax, dp(i,map[i].get(j)));
				}
				res[i]=new T(i,tmax);
			}
			Arrays.sort(res);
			T cur=res[0];
			out.print(cur.ci+1);
			out.print(" "+cur.cmax);
//			for(int i=1;i<n;i++)
//				if(res[i].cmax==cur.cmax)
//					out.print(" "+(res[i].ci+1));
			out.println();
		}
		
		out.flush();
	}
	public static int dp(int cf,int cn)
	{
		Integer ire=memo[cf].get(cn);
		if(ire!=null)
			return ire;
		int re=1;
		for(int i=0;i<map[cn].size();i++)
		{
			int d=map[cn].get(i);
			if(d==cf)continue;
			re+=dp(cn,d);
		}
		memo[cf].put(cn, re);
		return re;
	}
}
