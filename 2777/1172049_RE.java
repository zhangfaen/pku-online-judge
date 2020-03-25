import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
public class Main
{
	static char[] sc;
	static char[] tc;
	static HashMap<String, Byte> hsb = new HashMap<String, Byte>(10000);
	public static void main(String[] args) throws IOException
	{
		//Scanner cin = new Scanner(new File("c:\\in.txt"));
		BufferedReader br=new BufferedReader(new FileReader(new File("c:\\in.txt")));
		int L,T,O;
		String [] s=br.readLine().split(" +");
		L=Integer.parseInt(s[0]);T=Integer.parseInt(s[1]);O=Integer.parseInt(s[2]);
		HashSet<Integer>[] p=new HashSet[T+1];
		for(int i=1;i<p.length;i++)
			p[i]=new HashSet<Integer>(100001);
		for(int i=1;i<=L;i++)
			p[1].add(i);
		while(true)
		{
			String st=br.readLine();
			if(st==null)
				break;
			String [] sta=st.split(" +");
			int x=Integer.parseInt(sta[1]);
			int y=Integer.parseInt(sta[2]);
			if(sta[0].equals("C"))
			{
				int ct=Integer.parseInt(sta[3]);
				for(int i=1;i<=T;i++)
				{
					for(int j=x;j<=y;j++)
					{
						p[i].remove(j);
						p[ct].add(j);
					}
				}	
			}
			else
			{
				int re=0;
				for(int i=1;i<=T;i++)
				{
					for(int j=x;j<=y;j++)
						if(p[i].contains(j))
						{
							re++;
							break;
						}
				}
				System.out.println(re);
			}
		}
		
	}
	
}
