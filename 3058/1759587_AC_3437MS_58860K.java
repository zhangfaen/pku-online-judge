import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Main
{
	public static void main(String [] args)throws Exception
	{
		BufferedReader cin=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		String s=cin.readLine();
		int ts=Integer.parseInt(s);
		while(ts-->0)
		{
			s=cin.readLine();
			StringBuffer sb=new StringBuffer(1000000);
			for(int i=0;i<s.length();i++)
			{
				char c=s.charAt(i);
				if(Character.isLetter(c)||c=='.')
				{
					sb.append(c);
				}
				else
				{
					String ns="";
					c=s.charAt(i-1);
					while(i<s.length()&&Character.isDigit(s.charAt(i)))ns+=s.charAt(i++);
					i--;
					int d=Integer.parseInt(ns)-1;
					while(d-->0)
						sb.append(c);
				}
			}
			char [] p=sb.toString().toCharArray();
			char [] q=sb.toString().toCharArray();
			Arrays.sort(p);
			sb.delete(0, sb.length());
			int n=p.length;
			int [] next=new int[n];
			List [] cis=new LinkedList[26];
			for(int i=0;i<26;i++)
				cis[i]=new LinkedList();
			int ps=-1;
			for(int i=0;i<n;i++)
			{
				if(q[i]=='.')
				{
					ps=i;
				}
				else
				{
					cis[q[i]-'A'].add(i);
				}
			}
			next[0]=ps;
			for(int i=1;i<n;i++)
			{
				next[i]=(Integer)cis[p[i]-'A'].remove(0);
			}
			boolean [] vst=new boolean[n];
			for(int i=0;i<n;i++)
			{
				if(vst[i])continue;
				int cur=i;
				vst[i]=true;
				while(true)
				{
					sb.append(p[cur]);
					int nc=next[cur];
					if(nc==i)break;
					cur=nc;
					vst[cur]=true;
				}
			}
			String res=sb.substring(1)+".";
			out.println(res);
		}
		out.flush();
	}
}
