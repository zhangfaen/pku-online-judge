import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
public class Main
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		String s ="";
		String[] sa = null;
		LinkedList<String> pre = new LinkedList<String>();
		LinkedList<String> post = new LinkedList<String>();
		String curUrl="http://www.acm.org/";
		while (true)
		{
			s = cin.readLine();
			if (s.equals("QUIT"))
				break;
			String url="";
			if (s.equals("BACK"))
			{
				if(pre.size()>0)
				{
					post.addFirst(curUrl);
					curUrl=pre.remove(0);
					url=curUrl;
				}
				else
				{
					url="Ignored";
				}
				
			} else if (s.equals("FORWARD"))
			{
				if(post.size()>0)
				{
					pre.addFirst(curUrl);
					curUrl=post.remove(0);
					url=curUrl;
				}
				else
				{
					url="Ignored";
				}
			} else
			{
				s=s.split(" ")[1];
				pre.addFirst(curUrl);
				curUrl=s;
				url=curUrl;
				post.clear();
			}
			System.out.println(url);
		}
	}
}