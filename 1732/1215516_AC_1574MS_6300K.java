import java.io.BufferedReader;
import java.io.*;
import java.util.*;

public class Main
{
	static int [] cmap={2,2,2,3,3,3,4,4,1,1,5,5,6,6,0,7,0,7,7,8,8,8,9,9,9,0};
	static String os;
	static int [] p;
	static int [] back;
	static HashMap<String,String> pool;
	static int BIG=Integer.MAX_VALUE/2;
	public static void main(String[] args) throws Exception
	{
		
		//Scanner cin = new Scanner(new File("c:\\in.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br=new BufferedReader(new FileReader("c:\\in.txt"));
		os=br.readLine();
		p=new int[os.length()];
		back=new int[os.length()];
		Arrays.fill(p,-1);
		pool=new HashMap<String,String>();
		int n=Integer.parseInt(br.readLine().trim());
		for(int i=0;i<n;i++)
		{
			String s=br.readLine();
			pool.put(stod(s),s);
		}
		get(0);
		if(p[0]>=BIG)
		{
			System.out.println("No solution.");
		}
		else
		{
			int cur=0;
			while(true)
			{
				int ncur=back[cur];
				System.out.print(pool.get(os.substring(cur,ncur))+" ");
				cur=ncur;
				if(cur==os.length())
					break;
			}
		}
		
	}
	public static int get(int cur)
	{
		if(cur>=os.length())
			return 0;
		if(p[cur]!=-1)
			return p[cur];
		int min=BIG;
		String ts="";
		for(int k=cur;k<os.length();k++)
		{
			ts+=os.charAt(k);
			
			if(pool.containsKey(ts))
			{
				
				int tg=get(k+1)+1;
				if(min>tg)
				{
					min=tg;
					back[cur]=k+1;
				}
				
			}
		}
		return p[cur]=min;
		
	}
	public static String stod(String s)
	{
		String re="";
		for(int i=0;i<s.length();i++)
		{
			re+=cmap[s.charAt(i)-'a'];
		}
		return re;
	}
}

