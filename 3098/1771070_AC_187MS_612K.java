import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true)
		{
			String s=in.readLine();
			if(s.equals("#"))break;
			List<String> sr=new LinkedList<String>();
			sr.add(s);
			while(true)
			{
				s=in.readLine();
				if(s.equals("*"))break;
				sr.add(s);
			}
			Collections.sort(sr);
			while(true)
			{
				s=in.readLine();
				if(s.equals("**")){
					System.out.println("$");
					break;
				}
				String [] qs=s.split("\\|");
				boolean ok=false;
				out:for(int i=0;i<sr.size();i++)
				{
					for(int j=0;j<qs.length;j++)
					{
						if(match(qs[j],sr.get(i)))
						{
							ok=true;
							System.out.println(sr.get(i));
							break out;
						}
					}
				}
				if(ok==false)
				{
					System.out.println("NONE");
				}
			}
		}
		out.flush();
	}
	public static boolean match(String q,String s)
	{
		String us="";
		int tag=q.length();
		for(int i=0;i<q.length();i++)
		{
			if(q.charAt(i)=='+'||q.charAt(i)=='-')
			{
				tag=i;
				break;
			}
		}
		us=q.substring(0,tag);
		boolean ok=false;
		for(int i=0;i<us.length();i++)
		{
			if(s.indexOf(us.charAt(i))>=0)
			{
				ok=true;
				break;
			}
		}
		if(ok==false)
			return false;
		for(int i=tag;i<q.length();i++)
		{
			char c=q.charAt(i);
			if(c=='+')
			{
				c=q.charAt(i+1);
				if(s.indexOf(c)<0)
					return false;
			}
			else if(c=='-')
			{
				c=q.charAt(i+1);
				if(s.indexOf(c)>=0)
					return false;
			}
		}
		return true;
	}

}
