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

	static LinkedList [] mapa;
	static LinkedList [] mapt;
	static int [] order;
	static int tag;
	static boolean [] vst;
	static int [] id;
	static int [] id_degree_cnt;
	public static void main(String[] args) throws IOException
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true)
		{
			int n=0,m=0;
			try
			{
				String s=cin.readLine().trim();
				String [] sa=s.split(" +");
				n=Integer.parseInt(sa[0]);
				if(n==0)break;
				m=Integer.parseInt(sa[1]);
				mapa=new LinkedList[n];
				mapt=new LinkedList[n];
				for(int i=0;i<n;i++)
				{
					mapa[i]=new LinkedList<Integer>();
					mapt[i]=new LinkedList<Integer>();
				}
				if(m>=0)
				{				
					s=cin.readLine().trim();
					sa=s.split(" +");
				}
				else sa=new String[] {};
				for(int i=0;i<sa.length;i+=2)
				{
					int from=Integer.parseInt(sa[i])-1;
					int to=Integer.parseInt(sa[i+1])-1;
					mapa[from].add(to);
					mapt[to].add(from);
				}
			}catch(Exception e)
			{
				
			}
			
			order=new int[n];
			tag=0;
			vst=new boolean[n];
			for(int i=0;i<n;i++)
				if(vst[i]==false)
				{
					vst[i]=true;
					dfsa(i);
				}
			id=new int[n];
			tag=0;
			Arrays.fill(vst,false);
			for(int i=n-1;i>=0;i--)
			{
				if(vst[order[i]]==false)
				{
					vst[order[i]]=true;
					dfst(order[i]);
					tag++;
				}
			}
			id_degree_cnt=new int[tag];
			for(int i=0;i<n;i++)
			{
				LinkedList ll=mapa[i];
				for(int j=0;j<ll.size();j++)
				{
					int next=(Integer)ll.get(j);
					if(id[i]!=id[next])
						id_degree_cnt[id[i]]++;
				}
			}
			List<Integer>rel=new ArrayList<Integer>(n);
			for(int i=0;i<n;i++)
				if(id_degree_cnt[id[i]]==0)
					rel.add(i);
			for(int d:rel)
				out.print((d+1)+" ");
			out.println();
			
		}
		out.flush();
		out.close();
	}
	public static void dfsa(int ci)
	{
	
		for(int i=0;i<mapa[ci].size();i++)
		{
			int next=(Integer)mapa[ci].get(i);
			if(vst[next]==false)
			{
				vst[next]=true;
				dfsa(next);
			}
		}
		order[tag++]=ci;
	}
	public static void dfst(int ci)
	{
		id[ci]=tag;
		for(int i=0;i<mapt[ci].size();i++)
		{
			int next=(Integer)mapt[ci].get(i);
			if(vst[next]==false)
			{
				vst[next]=true;
				dfst(next);
			}
		}
	}
	
}