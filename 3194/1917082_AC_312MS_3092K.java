import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main
{
	static int [] dx={0,0,1,-1};
	static int [] dy={1,-1,0,0};
	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = null;
		String[] sa = null;
		out:while (true)
		{
			s = in.readLine();
			int n=Integer.parseInt(s);
			if(n==0)break;
			int [][] map=new int[n][n];
			for(int i=0;i<n-1;i++)
			{
				s=in.readLine();
				sa=s.split(" ");
				for(int j=0;j<sa.length;j+=2)
				{
					int x=Integer.parseInt(sa[j])-1;
					int y=Integer.parseInt(sa[j+1])-1;
					map[x][y]=i+1;
				}
			}
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					if(map[i][j]==0)map[i][j]=n;
			boolean [][] vst=new boolean[n][n];
			for(int k=1;k<=n;k++)
			{
				tt:for(int i=0;i<n;i++)
					for(int j=0;j<n;j++)
					{
						if(map[i][j]==k)
						{
							List<Integer> q=new LinkedList<Integer>();
							q.add(i);q.add(j);
							vst[i][j]=true;
							while(!q.isEmpty())
							{
								int cx=q.remove(0);
								int cy=q.remove(0);
								for(int d=0;d<4;d++)
								{
									int nx=cx+dx[d];
									int ny=cy+dy[d];
									if(nx<0||nx>=n||ny<0||ny>=n)continue;
									if(map[nx][ny]!=k||vst[nx][ny])continue;
									vst[nx][ny]=true;
									q.add(nx);q.add(ny);
								}
							}
							break tt;
						}
					}
			}
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					if(vst[i][j]==false)
					{
						System.out.println("wrong");
						continue out;
					}
			System.out.println("good");
		}
	}
	
}
