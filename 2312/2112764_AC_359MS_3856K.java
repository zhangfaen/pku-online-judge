import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class Main
{
	static int n, m;
	static char [][] map;
	static int [] dx= {1,-1,0,0};
	static int [] dy= {0,0,1,-1};
	public static void main(String[] args) throws IOException
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while (true)
		{
			String s = cin.readLine();
			String[] sa = s.split(" ");
			m = Integer.parseInt(sa[0]);
			n = Integer.parseInt(sa[1]);
			if (m + n == 0)
				break;
			map=new char[m][n];
			int sx=0,sy=0,tx=0,ty=0;
			for(int i=0;i<m;i++)
			{
				s=cin.readLine();
				for(int j=0;j<n;j++)
				{
					map[i][j]=s.charAt(j);
					if(map[i][j]=='Y')
					{
						sx=i;sy=j;
						map[i][j]='E';
					}
					else if(map[i][j]=='T')
					{
						tx=i;ty=j;
					}
				}
			}
			int [][] best=new int[m][n];
			for(int i=0;i<m;i++)
				for(int j=0;j<n;j++)
					best[i][j]=Integer.MAX_VALUE;
			best[sx][sy]=0;
			List<Integer>q=new LinkedList<Integer>();
			q.add(sx);q.add(sy);
			while(!q.isEmpty())
			{
				int cx=q.remove(0),cy=q.remove(0);
				int cs=best[cx][cy];
				for(int d=0;d<4;d++)
				{
					int nx=cx+dx[d];
					int ny=cy+dy[d];
					if(nx<0||nx>=m||ny<0||ny>=n)continue;
					if(map[nx][ny]=='S'||map[nx][ny]=='R')continue;
					if(map[nx][ny]=='E'&&cs+1<best[nx][ny])
					{
						best[nx][ny]=cs+1;
						q.add(nx);q.add(ny);
					}
					if(map[nx][ny]=='B'&&cs+2<best[nx][ny])
					{

						best[nx][ny]=cs+2;
						q.add(nx);q.add(ny);
					}
					if(map[nx][ny]=='T'&&cs+1<best[nx][ny])
						best[nx][ny]=cs+1;
				}
			}
			if(best[tx][ty]==Integer.MAX_VALUE)
				System.out.println(-1);
			else System.out.println(best[tx][ty]);
		}
		out.flush();
		out.close();
	}
}