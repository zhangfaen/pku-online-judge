import java.io.*;
import java.util.*;
import java.math.*;
public class Main
{
	static int [] dx={1,-1,0,0};
	static int [] dy={0,0,1,-1};
	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s="";
		int ts=Integer.parseInt(in.readLine());
		while(ts--!=0)
		{
			int m,n;
			s=in.readLine();
			String [] sa=s.split(" ");
			m=Integer.parseInt(sa[1]);
			n=Integer.parseInt(sa[0]);
			char [][] map=new char[m][n];
			for(int i=0;i<m;i++)
			{
				s=in.readLine();
				for(int j=0;j<n;j++)
				{
					map[i][j]=s.charAt(j);
				}
			}
			int res=0;
			int [][] len=new int[m][n];
			for(int i=0;i<m;i++)
				Arrays.fill(len[i], -1);
			out:for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
				{
					if(map[i][j]=='#')
						continue;
					List<Integer> q=new LinkedList<Integer>();
					q.add(i);
					q.add(j);
					len[i][j]=0;
					while(q.size()>0)
					{
						int ci=q.remove(0);
						int cj=q.remove(0);
						int clen=len[ci][cj];
						for(int k=0;k<4;k++)
						{
							int ni=ci+dx[k];
							int nj=cj+dy[k];
							if(map[ni][nj]=='.'&&len[ni][nj]==-1)
							{
								len[ni][nj]=clen+1;
								res=Math.max(res, len[ni][nj]);
								q.add(ni);q.add(nj);
							}
						}
					}
					
					break out;
				}
			System.out.println("Maximum rope length is "+res+".");
			System.gc();
		}
		
	}
}