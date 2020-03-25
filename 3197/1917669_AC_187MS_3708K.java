import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

public class Main
{
	static int [] len;
	static int n;
	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String s = null;
		String[] sa = null;
		int tag = 0;
		while (true)
		{
			s = in.readLine();
			if (s.equals("0 0"))
				break;
			sa = s.split(" ");
			BigInteger p = new BigInteger(sa[0]);
			BigInteger q = new BigInteger(sa[1]);
			tag++;
			out.println("Case " + tag + ":");
			out.println(p + " / " + q);
			List<BigInteger> li = new LinkedList<BigInteger>();
			while (q.compareTo(new BigInteger("0"))>0)
			{
				li.add(p.divide(q));
				p = p.mod(q);
				BigInteger tmp = p;
				p = q;
				q = tmp;
			}
			BigInteger last=li.remove(li.size()-1);
			last=last.subtract(new BigInteger("1"));
			li.add(last);
			n=li.size();
			len=new int[n];
			len[n-1]=li.get(n-1).toString().length()+4;
			for(int i=n-2;i>=0;i--)
				len[i]=len[i+1]+3+li.get(i).toString().length();
			for(int i=0;i<n;i++)
			{
				if(i==n-1)
				{
					String re="1";
					while(re.length()<len[0])re="."+re;
					out.println(re);
					String t=li.get(i)+".+.-";
					while(t.length()<len[0])t="."+t;
					out.println(t);
					out.println(re);
				}
				else
				{
					String re="";
					for(int j=0;j<len[i+1];j++)
					{
						if(j==(len[i+1]%2==0?len[i+1]/2-1:len[i+1]/2))
							re+="1";
						else re+=".";
					}
					while(re.length()<len[0])
						re="."+re;
					out.println(re);
					re="";
					re=li.get(i)+".+.";
					while(re.length()<len[i])re+="-";
					while(re.length()<len[0])re="."+re;
					out.println(re);
				}
			
				out.flush();
			}
		}
	}
	public static void dfs(PrintWriter out,int ind,BigInteger p,BigInteger q)
	{
		
	}
}
