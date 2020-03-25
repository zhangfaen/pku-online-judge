import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class Main
{
	static int m,n;
	static boolean [][] map;
	static int [] match1;
	static int [] match2;
	public static void main(String [] args)throws Exception
	{
		Scanner cin=new Scanner(System.in);
		m=cin.nextInt();
		n=cin.nextInt();
		map=new boolean[m+1][n+1];
		match1=new int[m+1];
		match2=new int[n+1];
		for(int i=1;i<=m;i++)
		{
			int t=cin.nextInt();
			for(int j=0;j<t;j++)
			{
				int tt=cin.nextInt();
				map[i][tt]=true;
			}
		}
		int sum=0;
		for(int i=1;i<=m;i++)
			sum+=find(i);
		System.out.println(sum);
	}
	public static int find(int k)
	{
		List<Integer> q=new LinkedList<Integer>();
		q.add(k);
		int [] back1=new int[m+1];
		int [] back2=new int[n+1];
		while(q.size()>0)
		{
			int cur=q.remove(0);
			for(int j=1;j<=n;j++)
			{
				if(map[cur][j]&&back2[j]==0)
				{
					if(match2[j]==0)
					{
						while(true)
						{
							match1[cur]=j;
							match2[j]=cur;
							j=back1[cur];
							cur=back2[j];
							if(j==0)
								break;
						}
						return 1;
					}
					else
					{
						back2[j]=cur;
						back1[match2[j]]=j;
						q.add(match2[j]);
					}
				}
			}
		}
		return 0;
	}
	
}

