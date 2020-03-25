import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
public class Main
{
	static boolean[][] map;
	public static void main(String[] args) throws Exception
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		String s=cin.readLine();
		int ts=Integer.parseInt(s);
		String [] sa=null;
		out:while(ts--!=0)
		{
			s=cin.readLine();
			sa=s.split(" ");
			String n=sa[0];
			String m=sa[1];
			HashSet<Character> ns=new HashSet<Character>();
			HashSet<Character> ms=new HashSet<Character>();
			for(int i=0;i<n.length();i++)
				ns.add(n.charAt(i));
			for(int j=0;j<m.length();j++)
				ms.add(m.charAt(j));
			if(ns.equals(ms))
			{
				out.println("friends");
				continue;
			}
			char [] nc=n.toCharArray();
			char [] mc=m.toCharArray();
			for(int i=0;i<n.length()-1;i++)
			{
				if(nc[i]<'9'&&nc[i+1]>'0')
				{
					String newn=n.substring(0,i)+(char)(nc[i]+1)+(char)(nc[i+1]-1)+n.substring(i+2);
					if(isok(newn,ms))
					{
						out.println("almost friends");
						continue out;
					}
				}
				if(nc[i]>'0'&&nc[i+1]<'9')
				{
					if(nc[i]=='1'&&i==0)
						continue;
					String newn=n.substring(0,i)+(char)(nc[i]-1)+(char)(nc[i+1]+1)+n.substring(i+2);
					if(isok(newn,ms))
					{
						out.println("almost friends");
						continue out;
					}
				}
			}
			for(int i=0;i<m.length()-1;i++)
			{
				if(mc[i]<'9'&&mc[i+1]>'0')
				{
					String newn=m.substring(0,i)+(char)(mc[i]+1)+(char)(mc[i+1]-1)+m.substring(i+2);
					if(isok(newn,ns))
					{
						out.println("almost friends");
						continue out;
					}
				}
				if(mc[i]>'0'&&mc[i+1]<'9')
				{
					if(mc[i]=='1'&&i==0)
						continue;
					String newn=m.substring(0,i)+(char)(mc[i]-1)+(char)(mc[i+1]+1)+m.substring(i+2);
					if(isok(newn,ns))
					{
						out.println("almost friends");
						continue out;
					}
				}
			}
			out.println("nothing");
		}
		out.flush();
	}
	public static boolean isok(String s,HashSet<Character> t)
	{
		boolean re=false;
		HashSet<Character> ss=new HashSet<Character>();
		for(int i=0;i<s.length();i++)
			ss.add(s.charAt(i));
		return ss.equals(t);
	}
}