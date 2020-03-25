import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class Main
{

	public static void main(String[] args) throws Exception
	{
	//	BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		Scanner cin=new Scanner(System.in);
		while(cin.hasNextInt())
		{
			int m=cin.nextInt();
			boolean [][] map=new boolean[m][7*12];
			for(int i=0;i<m;i++)
			{
				int pn=cin.nextInt();
				for(int j=0;j<pn;j++)
				{
					int p=cin.nextInt(),q=cin.nextInt();
					map[i][(p-1)*12+q-1]=true;
				}
			}
			int re=BiGraph.get(m, 7*12, map);
			System.out.println(re);
		}
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