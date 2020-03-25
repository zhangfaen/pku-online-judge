import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
public class Main
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		String s = cin.readLine();
		String[] sa = s.split(" ");
		int N = Integer.parseInt(sa[0]);
		int M = Integer.parseInt(sa[1]);
		int[][] map = new int[N][N];
		int[] x = new int[M];
		int[] y = new int[M];
		for (int i = 0; i < M; i++)
		{
			s = cin.readLine();
			sa = s.split(" ");
			int a = Integer.parseInt(sa[0]);
			int b = Integer.parseInt(sa[1]);
			int cap = Integer.parseInt(sa[2]);
			map[a][b] = cap;
			x[i] = a;
			y[i] = b;
		}
		MFTest mf = new MFTest(map);
		mf.get(0, N - 1);
		int re = 0;
		for (int i = 0; i < M; i++)
		{
			int a = x[i];
			int b = y[i];
			int t = map[a][b];
			if(t>0)continue;
			map[a][b] = Integer.MAX_VALUE / 2;
			boolean ok = mf.augmentable(0, N - 1);
			if (ok)
				re++;
			map[a][b] = t;
		}
		System.out.println(re);
	}
	static class MFTest
	{
		private int [][] cap;
		private int n;
		private int [] back;
		public MFTest(int [][] cap)
		{
			this.cap=cap;
			this.n=cap.length;
			this.back=new int[n];
		}
		public int get(int s,int t)
		{
			int re=0;
			while(augmentable(s,t))
			{
				int cp=Integer.MAX_VALUE;
				int cur=t;
				while(cur!=s)
				{
					cp=Math.min(back[cur], cur);
					cur=back[cur];
				}
				cur=t;
				while(cur!=s)
				{
					cap[back[cur]][cur]-=cp;
					cap[cur][back[cur]]+=cp;
					cur=back[cur];
				}
				re+=cp;
			}
			return re;
		}
		public boolean augmentable(int s,int t)
		{
			boolean re=false;
			Arrays.fill(back,-1);
			back[s]=s;
			List<Integer> q=new LinkedList<Integer>();
			q.add(s);
			while(!q.isEmpty())
			{
				int cur=q.remove(0);
				for(int i=0;i<n;i++)
				{
					if(cap[cur][i]>0&&back[i]==-1)
					{
						back[i]=cur;
						if(i==t)
							return true;
						q.add(i);
					}
				}
			}
			return re;
		}
	}
}