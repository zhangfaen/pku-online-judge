import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String[] args) throws Exception
	{
		Scanner cin = new Scanner(System.in);
		int K,n,R;
		K=cin.nextInt();
		n=cin.nextInt();
		R=cin.nextInt();
		List [] map=new LinkedList[n+1];
		for(int i=0;i<=n;i++)
			map[i]=new LinkedList<Node>();
		for(int i=0;i<R;i++)
		{
			int s,t,l,c;
			s=cin.nextInt();t=cin.nextInt();l=cin.nextInt();c=cin.nextInt();
			map[s].add(new Node(t,l,c));
			
		}
		int [][] p=new int[n+1][K+1];
		for(int i=0;i<=n;i++)
			for(int j=0;j<=K;j++)
				p[i][j]=Integer.MAX_VALUE;
		p[1][K]=0;
		int made=1000000;
		int [] q=new int[made];
		int low=0,high=0;
		q[high++]=1;q[high++]=K;
		while(low!=high)
		{
			
			int cc=low+1<made?q[low++]:q[low=0];
			int ck=low+1<made?q[low++]:q[low=0];
			for(int i=0;i<map[cc].size();i++)
			{
				Node cn=(Node)map[cc].get(i);
				int cd=cn.index;
				int len=cn.len;
				int cost=cn.cost;
				if(ck>=cost&&p[cc][ck]+len<p[cd][ck-cost])
				{
					p[cd][ck-cost]=p[cc][ck]+len;
					if(high+1<made)
						q[high++]=cd;
					else
						q[0]=cd;
					if(high+1<made)
						q[high++]=ck-cost;
					else
						q[0]=ck-cost;
				}
			}
			
		}

		int re=Integer.MAX_VALUE;
		for(int i=0;i<=K;i++)
			re=Math.min(p[n][i],re);
		System.out.println(re);
			
		
	}
	
	
}
class Node
{
	int index,len,cost;
	public Node(int a,int b,int c)
	{
		index=a;len=b;cost=c;
	}
}

