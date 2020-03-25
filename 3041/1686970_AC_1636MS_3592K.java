import java.io.*;
import java.util.*;
import java.math.*;
public class Main
{
	static boolean [][] map;
	public static void main(String[] args) throws Exception
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		int n, m;
		String rs = cin.readLine();
		String[] rsa = rs.split(" ");
		n=Integer.parseInt(rsa[0]);
		m=Integer.parseInt(rsa[1]);
		map=new boolean[n][n];
		for(int i=0;i<m;i++)
		{
			rs=cin.readLine();
			rsa=rs.split(" ");
			map[Integer.parseInt(rsa[0])-1][Integer.parseInt(rsa[1])-1]=true;
		}
		int re=BiGraph.get(n, n, map);
		System.out.println(re);
	}
}
class BiGraph
{
	static int m,n;
	static boolean [][] map;
	static int [] match1;
	static int [] match2;
	public static int get(int tm,int tn,boolean [][] tmap)
	{
		m=tm;
		n=tn;
		map=tmap;
		match1=new int[m];
		match2=new int[n];
		Arrays.fill(match1,-1);
		Arrays.fill(match2,-1);
		int re=0;
		for(int i=0;i<m;i++)
			re+=find(i);
		return re;
	}
	private static int find(int s)
	{
		int [] back=new int[n];
		Arrays.fill(back,-1);
		List<Integer> q=new LinkedList<Integer>();
		q.add(s);
		while(q.size()>0)
		{
			int cur=q.remove(0);
			for(int i=0;i<n;i++)
			{
				if(map[cur][i]&&back[i]==-1)
				{
					if(match2[i]>=0)
					{
						back[i]=cur;
						q.add(match2[i]);
					}
					else
					{
						while(true)
						{
							int ni=match1[cur];
							match1[cur]=i;
							match2[i]=cur;
							if(ni==-1)
								break;
							cur=back[ni];
							i=ni;
							
						}
						return 1;
					}
				}
			}
		}
		return 0;
	}
}
