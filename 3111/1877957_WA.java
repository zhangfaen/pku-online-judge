import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Main
{
	static class Fen implements Comparable<Fen>
	{
		int v,u,index;
		public Fen(int v,int u,int index)
		{
			this.v=v;
			this.u=u;
			this.index=index;
		}
		public int compareTo(Fen o)
		{
			long t1=1L*v*o.u;
			long t2=1L*u*o.v;
			if(t1==t2)return 0;
			if(t1<t2)return 1;
			return -1;
		}
		
	}
	public static void main(String[] args) throws Exception
	{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		String s=null;
		String [] sa=null;
		s=in.readLine();
		sa=s.split(" ");
		int n,k;
		n=Integer.parseInt(sa[0]);
		k=Integer.parseInt(sa[1]);
		Fen [] all=new Fen[n];
		for(int i=0;i<n;i++)
		{
			s=in.readLine();
			sa=s.split(" ");
			int v=Integer.parseInt(sa[0]);
			int u=Integer.parseInt(sa[1]);
			all[i]=new Fen(v,u,i+1);
		}
		Arrays.sort(all);
		PrintWriter out=new PrintWriter(System.out);
		for(int i=0;i<k;i++)
			out.print(all[i].index+" ");
		out.flush();
	}

	
}
