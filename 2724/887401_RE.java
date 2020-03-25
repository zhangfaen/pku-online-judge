import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String [] args) throws Exception
	{
		Scanner cin=new Scanner(System.in);
		while(true)
		{
			int N=cin.nextInt();
			int M=cin.nextInt();
			if(N+M==0)break;
			Set<String> hss=new HashSet<String>();
			for(int i=0;i<M;i++)
			{
				String t=cin.next();
				String t0=t.replace('*','0');
				String t1=t.replace('*','1');
				hss.add(t0);
				hss.add(t1);
			}
			List<Node> an=new ArrayList<Node>(2002);
			int total=0;
			for(Iterator it=hss.iterator();it.hasNext();)
			{
				String t=(String)it.next();
				an.add(new Node(t,total++));
			}
			for(int i=0;i<total-1;i++)
				for(int j=i+1;j<total;j++)
				{
					if(Node.isAdj(an.get(i),an.get(j)))
					{
						an.get(i).degree++;
						an.get(j).degree++;
						an.get(i).link.add(an.get(j));
						an.get(j).link.add(an.get(i));
					}
				}
			int re=0;
			boolean goon=true;
			while(goon)
			{
				goon=false;
				for(int i=0;i<an.size();i++)
				{
					if(an.get(i)==null)continue;
					if(an.get(i).link.size()==0)
					{
						re++;
						an.set(i,null);
					}
					if(an.get(i).link.size()==1)
					{
						Node d1=an.get(i);
						Node d2=an.get(i).link.get(0);
						goon=true;
						List<Node> t=d2.link;
						for(int j=0;j<t.size();j++)
						{
							t.get(j).link.remove(d2);
						}
						an.set(d2.num,null);
						an.set(i,null);
						re++;
					}
				}
			}
			System.out.println(re);
			
		}
	}
}
class Node
{
	int num=-1;
	String s=null;
	int degree=0;
	boolean tag=false;
	List<Node> link=new LinkedList<Node>();
	public Node(String s,int num)
	{
		this.s=s;
		this.num=num;
	}
	public static boolean isAdj(Node a,Node b)
	{
		String s=a.s;
		String t=b.s;
		int sum=0;
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)!=t.charAt(i))
				sum++;
			if(sum>=2)
				return false;
		}
		if(sum==1)
			return true;
		else
			return false;
	}
}