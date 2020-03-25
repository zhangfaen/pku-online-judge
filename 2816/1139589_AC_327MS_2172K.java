import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Main
{
	static int [][] dx={{0,-1,0,1},{1,0,-1,0},{0,1,0,-1},{-1,0,1,0}};
	static int [][] dy={{1,0,-1,0},{0,1,0,-1},{-1,0,1,0},{0,-1,0,1}};
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner cin = new Scanner(System.in);
		while (true)
		{
			int m, n;
			n = cin.nextInt();
			m = cin.nextInt();
			if (m < 3 || n < 3)
				break;
			cin.nextLine();
			int[][] map = new int[m][n];
			int gx=-1, gy=-1;
			List<Integer> li = new ArrayList<Integer>();
			for (int i = 0; i < m; i++)
			{
				String s = cin.nextLine();
				if (s.length() > n)
					s = s.substring(0, n);
				if (s.length() < n)
					while (s.length() < n)
						s += "X";
				for (int j = 0; j < n; j++)
					if (s.charAt(j) == 'X')
						map[i][j] = -1;
					else if (s.charAt(j) == 'E')
					{
						map[i][j] = 1;
						li.add(i);
						li.add(j);
					} else if (s.charAt(j) == 'G')
					{
						map[i][j] = 2;
						gx = i;
						gy = j;
					} else
						map[i][j] = 0;
			}
			for(int i=gx;i<m;i++)
				if(map[i][gy]==-1)
					break;
				else map[i][gy]=2;
			for(int i=gx;i>=0;i--)
				if(map[i][gy]==-1)
					break;
				else map[i][gy]=2;
			for(int i=gy;i<n;i++)
				if(map[gx][i]==-1)
					break;
				else map[gx][i]=2;
			for(int i=gy;i>=0;i--)
				if(map[gx][i]==-1)
					break;
				else map[gx][i]=2;
			int sum=0;
			int totale=li.size() / 2;
			while(li.size()>0)
			{
				int curx=li.remove(0);
				int cury=li.remove(0);
				int cdir=-1;
				if(curx==0)
					cdir=2;
				if(curx==m-1)
					cdir=0;
				if(cury==0)
					cdir=1;
				if(cury==n-1)
					cdir=3;
				int newx=curx+dx[cdir][1];
				int newy=cury+dy[cdir][1];
				if(map[newx][newy]==-1)
					continue;
				curx=newx;cury=newy;
				while(true)
				{
					if(map[curx][cury]==2)
					{
						sum++;
						break;
					}
					if(map[curx][cury]==1)
						break;
					for(int i=0;i<4;i++)
					{
						newx=curx+dx[cdir][i];
						newy=cury+dy[cdir][i];
						if(map[newx][newy]!=-1)
						{
							curx=newx;
							cury=newy;
							switch(i){
							case 0:
								cdir = (cdir + 1) % 4;
								break;
							case 1:
								break;
							case 2:
								cdir = (cdir + 3) % 4;
								break;
							case 3:
								cdir = (cdir + 2) % 4;
								break;
							}
							break;
						}
					}
				}
			}
			System.out.println("The goal would be found from " + sum + " out of " + totale + " entrances.");
		}
	}
}
