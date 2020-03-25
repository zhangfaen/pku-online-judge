import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
public class Main
{
	static int [] map;
	static HashMap<String,Integer> p;
	static int n;
	public static void main(String[] args) throws Exception
	{
		Scanner cin = new Scanner(System.in);
		int cs=cin.nextInt();
		while(cs--!=0)
		{
			n=cin.nextInt();
			map=new int[n+1];
			for(int i=1;i<=n;i++)
			{
				map[i]=cin.nextInt();
			}
			p=new HashMap<String,Integer>();
			System.out.println(get(1,1));
		}
	}
	public static int get(int a,int b)
	{
		if(a>n||b>n)
			return 0;
		Integer pt=p.get(""+a+b);
		if(pt!=null)
			return pt;
		int t=a;
		while(t<=n&&map[t]<b)
			t++;
		if(t<=n)
		{
			
			int tre=Math.max(get(t+1,map[t]+1)+1,get(t+1,b));
			p.put(""+a+b,tre);
			return tre;
		}
		p.put(""+a+b,0);
		return 0;
	}
}



