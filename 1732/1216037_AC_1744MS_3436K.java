import java.io.BufferedReader;
import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class Main
{
	static int [] cmap={2,2,2,3,3,3,4,4,1,1,5,5,6,6,0,7,0,7,7,8,8,8,9,9,9,0};
	static String os;
	static int [] p;
	static int [] back;
	static HashMap<String,String> pool;
	static int BIG=10000000;
	public static void main(String[] args) throws Exception
	{
		
		//Scanner cin = new Scanner(new File("c:\\in.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br=new BufferedReader(new FileReader("c:\\in.txt"));
		os=br.readLine();
		if(os.length() > 0){
		p=new int[os.length()];
		back=new int[os.length()];
		for(int i =  0; i < os.length(); i++)
			p[i] = -1;
		pool=new HashMap<String,String>();
		for(int i = 0; i < os.length(); i++){
			for(int j = i + 1; j <= os.length(); j++){
				pool.put(os.substring(i,j),"");
			}
		}
		int n=Integer.parseInt(br.readLine().trim());
		for(int i=0;i<n;i++)
		{
			String s=br.readLine().toLowerCase();
			String t = stod(s);
			if(pool.containsKey(t))
				pool.put(t,s);
		}
		int sum = get(0);
		if(p[0]>=BIG)
		{
			System.out.println("No solution.");
		}
		else
		{
			int cur=0;
			String res = "";
			while(true)
			{
				int ncur=back[cur];
				res += pool.get(os.substring(cur,ncur))+" ";
				cur=ncur;
				if(cur==os.length())
					break;
			}
			System.out.println(res);
		}
		}
		else
			System.out.println("No solution.");
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
			if(pool.containsKey(ts) && !pool.get(ts).equals(""))
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

