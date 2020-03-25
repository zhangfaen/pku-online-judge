import java.io.*;
import java.util.*;
import java.math.*;
public class Main
{
	public static void main(String[] args) throws Exception
	{
		Scanner cin = new Scanner(new BufferedInputStream(System.in));		
		int t,n;
		t=cin.nextInt();
		n=cin.nextInt();
		int [][] map=new int[n][n];
		int BIG=Integer.MAX_VALUE/2;
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				map[i][j]=BIG;
		for(int i=0;i<t;i++)
		{
			int sn,tn,len;
			sn=cin.nextInt()-1;
			tn=cin.nextInt()-1;
			len=cin.nextInt();
			map[sn][tn]=Math.min(map[sn][tn],len);
			map[tn][sn]=Math.min(map[tn][sn],len);
		}
		Dijkstra dij=new Dijkstra(n,map);
		int re=dij.get(0,n-1);
		System.out.println(re);
	}
} 
class Dijkstra
{
	private int n;
	private int[][]map;
	public Dijkstra(int n,int [][] map)
	{
		this.n=n;
		this.map=map;
	}
	public int get(int s,int t)
	{
		int [] p=new int[n];
		boolean [] tag=new boolean[n];
		for(int i=0;i<n;i++)
			p[i]=map[s][i];
		tag[s]=true;
		while(true)
		{
			int tmin=Integer.MAX_VALUE;
			int ci=-1;
			for(int i=0;i<n;i++)
			{
				if(tag[i]==false&&p[i]<tmin)
				{
					tmin=p[i];
					ci=i;
				}
			}
			tag[ci]=true;
			if(ci==t)
				return p[ci];
			for(int i=0;i<n;i++)
			{
				if(tag[i]==false)
				{
					p[i]=Math.min(p[i],p[ci]+map[ci][i]);
				}
			}
		}
		
		
	}
}
