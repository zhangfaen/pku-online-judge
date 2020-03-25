import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Main
{
	static int [][] memo;
	static int INF=Integer.MAX_VALUE;
	static int [] sum;
	static List<Integer> list;
	static int len;
	public static void main(String[] args) throws Exception
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true)
		{
			String s=cin.readLine();
			String [] sa=s.split(" ");
			int m=Integer.parseInt(sa[0]);
			int n=Integer.parseInt(sa[1]);
			if(m+n==0)break;
			Map<String,List<Integer>> mss=new HashMap<String,List<Integer>>();
			s=cin.readLine();
			sa=s.split(" ");
			for(String t:sa)
				mss.put(t, new ArrayList<Integer>(100));
			for(int i=0;i<n;i++)
			{
				s=cin.readLine();
				sa=s.split(" ");
				mss.get(sa[1]).add(Integer.parseInt(sa[0]));
			}
			int res=0;
			for(String key:mss.keySet())
			{
				list=mss.get(key);
				len=list.size();
				if(len==0)continue;
				sum=new int[list.size()];
				sum[0]=list.get(0);
				for(int i=1;i<list.size();i++)
				{
					sum[i]=list.get(i)+sum[i-1];
				}
				memo=new int[len][sum[len-1]+1];
				for(int i=0;i<len;i++)
					for(int j=0;j<sum[len-1]+1;j++)
						memo[i][j]=INF;
				int d=dp(0,0);
				res+=(sum[len-1]-d)/2+d;
			}
			System.out.println(res);
		}
		
		out.flush();
	}
	public static int dp(int ci,int cs)
	{
		if(ci==len)
		{
			return Math.abs(sum[len-1]-cs-cs);
		}
		if(memo[ci][cs]!=INF)
			return memo[ci][cs];
		int re=Integer.MAX_VALUE/2;
		int d1=dp(ci+1,cs+list.get(ci));
		int d2=dp(ci+1,cs);
		re=Math.min(d1, d2);
		memo[ci][cs]=re;
		return re;
	}
}