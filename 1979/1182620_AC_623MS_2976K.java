import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Scanner;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		int [] dx={1,-1,0,0};
		int [] dy={0,0,1,-1};
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		while(true)
		{
			int m,n;
			String [] sa=br.readLine().split(" +");
			n=Integer.parseInt(sa[0]);
			m=Integer.parseInt(sa[1]);
			if(m+n==0)
				break;
			boolean [][] map=new boolean[m][n];
			boolean [][] p=new boolean[m][n];
			int sx=-1,sy=-1;
			for(int i=0;i<m;i++)
			{
				String s=br.readLine();
				for(int j=0;j<s.length();j++)
				{
					if(s.charAt(j)=='.')
						map[i][j]=true;
					else
					{
						if(s.charAt(j)=='@')
						{
							sx=i;sy=j;
						}
					}
				}
			}
			int [] q=new int[5000];
			int size=0;
			q[size++]=sx;
			q[size++]=sy;
			int res=0;
			int tag=0;
			while(tag<size)
			{
				res++;
				int curx=q[tag++];
				int cury=q[tag++];
				for(int i=0;i<4;i++)
				{
					int nx=curx+dx[i];
					int ny=cury+dy[i];
					if(nx<0||nx>=m||ny<0||ny>=n||p[nx][ny]||map[nx][ny]==false)
						continue;
					q[size++]=nx;
					q[size++]=ny;
					p[nx][ny]=true;
				}
			}
			System.out.println(res);
		}
		
	}
}

