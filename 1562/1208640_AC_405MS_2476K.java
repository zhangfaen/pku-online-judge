import java.io.*;
import java.util.*;
public class Main
{
	static int [] dx={1,1,-1,-1,0,0,-1,1};
	static int [] dy={1,-1,1,-1,1,-1,0,0};
	public static void main(String[] args) throws Exception
	{
		Scanner cin = new Scanner(System.in);
		while(true)
		{
			int m,n;
			m=cin.nextInt();n=cin.nextInt();
			if(m+n==0)break;
			char [][] map=new char[m][n];
			for(int i=0;i<m;i++)
			{
				String s=cin.next();
				for(int j=0;j<s.length();j++)
				{
					map[i][j]=s.charAt(j);
				}
			}
			int re=0;
			for(int i=0;i<m;i++)
				for(int j=0;j<n;j++)
				{
					if(map[i][j]=='@')
					{
						re++;
						List<Integer> q=new LinkedList<Integer>();
						map[i][j]='*';
						q.add(i);
						q.add(j);
						while(q.size()>0)
						{
							int x=q.remove(0);
							int y=q.remove(0);
							for(int k=0;k<8;k++)
							{
								if(x+dx[k]>=0&&x+dx[k]<m&&y+dy[k]>=0&&y+dy[k]<n&&map[x+dx[k]][y+dy[k]]=='@')
								{
									map[x+dx[k]][y+dy[k]]='*';
									q.add(x+dx[k]);
									q.add(y+dy[k]);
								}
							}
						}
					}
				}
			System.out.println(re);
			
		}
	}
	
	
}

