import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main
{
	static BufferedReader cin = null;
	static PrintWriter out = new PrintWriter(System.out);


	public static void main(String[] args) throws Exception
	{
		cin = new BufferedReader(new InputStreamReader(System.in));
		String s=cin.readLine();
		StringTokenizer st=new StringTokenizer(s);
		int k=Integer.parseInt(st.nextToken());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int [] ks=new int[k];
		for(int i=0;i<k;i++)
		{
			s=cin.readLine();
			ks[i]=Integer.parseInt(s)-1;
		}
		int [][] map=new int[n][n];
		for(int i=0;i<m;i++)
		{
			s=cin.readLine();
			st=new StringTokenizer(s);
			int x=Integer.parseInt(st.nextToken())-1;
			int y=Integer.parseInt(st.nextToken())-1;
			map[x][y]=1;
		}
		int [] cnt=new int[n];
		for(int i=0;i<k;i++)
		{
			boolean [] vst=new boolean[n];
			List<Integer> q=new LinkedList<Integer>();
			q.add(ks[i]);
			vst[ks[i]]=true;
			cnt[ks[i]]++;
			while(!q.isEmpty())
			{
				int cur=q.remove(0);
				for(int j=0;j<n;j++)
				{
					if(map[cur][j]==1&&vst[j]==false)
					{
						vst[j]=true;
						q.add(j);
						cnt[j]++;
					}
				}
			}
		}
		int res=0;
		for(int d:cnt)
			if(d==k)
				res++;
		System.out.println(res);

	}

	
}
