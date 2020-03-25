import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
public class Main
{
	static class Point
	{
		int index, x, y, cost;
		public Point(int index, int x, int y, int cost)
		{
			this.index = index;
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
		public boolean isNeibor(Point t)
		{
			return Math.abs(x - t.x) + Math.abs(y - t.y) == 1;
		}
	}
	static int n;
	static Point[] ps;
	static List [] cnt;
	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();
		n = Integer.parseInt(s);
		ps = new Point[n];
		for(int i=0;i<n;i++)
		{
			s=in.readLine();
			String [] sa=s.split(" ");
			int x=Integer.parseInt(sa[0]);
			int y=Integer.parseInt(sa[1]);
			int cost=Integer.parseInt(sa[2]);
			ps[i]=new Point(i,x,y,cost);
		}
		cnt=new LinkedList[n];
		for(int i=0;i<n;i++)
			cnt[i]=new LinkedList();
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
			{
				if(i==j)
					continue;
				if(ps[i].isNeibor(ps[j]))
					cnt[i].add(j);
			}
		int res=Integer.MIN_VALUE;
		for(int i=0;i<n;i++)
		{
			int tre=ps[i].cost;
			for(int j=0;j<cnt[i].size();j++)
			{
				int neibor=(Integer)cnt[i].get(j);
				if(neibor==i)
					continue;
				tre+=dp(i,neibor);
			}
			res=Math.max(res, tre);
		}
		System.out.println(res);
	}
	public static int dp(int fn,int cn)
	{
		int re=ps[cn].cost;
		for(int i=0;i<cnt[cn].size();i++)
		{
			int neibor=(Integer)cnt[cn].get(i);
			if(fn==neibor)
				continue;
			re+=dp(cn,neibor);
		}
		if(re<0)
			return 0;
		return re;
	}
}
