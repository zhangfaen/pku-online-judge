import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main
{
	

	public static void main(String[] args) throws Exception
	{
		BufferedReader cin=new BufferedReader(new InputStreamReader(System.in));
		
		int testcase=1;
		while(true)
		{
			String s=cin.readLine();
			String [] sa=s.split(" +");
			int keynum=Integer.parseInt(sa[0]);
			int sentencenum=Integer.parseInt(sa[1]);
			Set<String> ss=new HashSet<String>();
			for(int i=0;i<keynum;i++)
			{
				s=cin.readLine();
				ss.add(s.trim());
			}
			List<String>ls=new ArrayList<String>();
			int best=-1;
			for(int i=0;i<sentencenum;i++)
			{
				s=cin.readLine().trim();
				sa=s.split("[^a-zA-Z]+");
				int d=0;
				for(String t:sa)
				{
					if(t.length()>0&&ss.contains(t.toLowerCase()))
					{
						d++;
					}
				}
				if(d==best)
				{
					ls.add(s);
				}
				else if(d>best)
				{
					best=d;
					ls.clear();
					ls.add(s);
				}
			}
			System.out.println("Excuse Set #"+testcase);
			for(String t:ls)
			{
				System.out.println(t);
			}
			System.out.println();
			testcase++;
		}
		
		
	}

	
}