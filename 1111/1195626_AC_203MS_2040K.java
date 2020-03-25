import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class Main
{
	static int [] dx={1,1,-1,-1,0,0,1,-1};
	static int [] dy={1,-1,1,-1,1,-1,0,0};
	public static void main(String[] args) throws Exception
	{
		Scanner cin = new Scanner(System.in);
		while(true)
		{
			int m,n,sx,sy;
			m=cin.nextInt();n=cin.nextInt();sx=cin.nextInt();sy=cin.nextInt();
			if(m+n+sx+sy==0)
				break;
			char [][] map=new char[m+2][n+2];
			for(int i=1;i<=m;i++)
			{
				String ts=cin.next();
				ts="."+ts+".";
				for(int j=0;j<n+2;j++)
					map[i][j]=ts.charAt(j);
			}
			for(int j=0;j<n+2;j++)
				map[0][j]=map[m+1][j]='.';
			boolean [][] tag=new boolean[m+2][n+2];
			List<Cor> q=new LinkedList<Cor>();
			q.add(new Cor(sx,sy));
			tag[sx][sy]=true;
			Cor [] all=new Cor[m*n];
			int size=0;
			while(q.size()>0)
			{
				Cor c=q.remove(0);
				all[size++]=c;
				for(int i=0;i<8;i++)
				{
					int nx=c.x+dx[i];
					int ny=c.y+dy[i];
					if(tag[nx][ny]==false&&map[nx][ny]=='X')
					{
						tag[nx][ny]=true;
						q.add(new Cor(nx,ny));
					}
				}
				
			}
			int sum=0;
			for(int i=0;i<size;i++)
			{
				for(int j=4;j<8;j++)
				{
					if(map[all[i].x+dx[j]][all[i].y+dy[j]]=='.')
						sum++;
				}
			}
			System.out.println(sum);
			
		}
		
	}		
}
class Cor
{
	int x,y;
	public Cor(int a,int b)
	{
		x=a;y=b;
	}
}



