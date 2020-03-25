import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main
{
	static class Pair
	{
		int p,index;
		public Pair(int p,int index)
		{
			this.p=p;
			this.index=index;
		}
		public String toString()	
		{
			return p+" "+index;
		}
	}
	public static void main(String[] args) throws Exception
	{

		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		String s=null;
		String [] sa=null;
		s=in.readLine();
		int tsc=Integer.parseInt(s);
		while(tsc-->0)
		{
			int n,m;
			s=in.readLine();
			sa=s.split(" ");
			n=Integer.parseInt(sa[0]);
			m=Integer.parseInt(sa[1]);
			LinkedList<Pair> q=new LinkedList<Pair>();
			s=in.readLine();
			sa=s.split(" ");
			for(int i=0;i<n;i++)
			{
				q.add(new Pair(Integer.parseInt(sa[i]),i));
			}
			int ct=0;
			while(q.isEmpty()==false)
			{
				Pair cp=q.remove(0);
				boolean ok=true;
				for(int i=0;i<q.size();i++)
					if(q.get(i).p>cp.p)
					{
						ok=false;
						break;
					}
				if(ok)
				{
					if(cp.index==m)
					{
						ct++;
						break;
					}
					else
					{
						ct++;
					}
				}
				else
					q.addLast(cp);
			}
			System.out.println(ct);
		}
	}

	
}
