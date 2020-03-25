import java.io.*;
import java.util.*;
public class Main
{
	static int sum=0;
	public static void main(String[] args) throws Exception
	{
		Scanner cin = new Scanner(System.in);
		while(true)
		{
			String s=cin.next();
			if(s.equals("END"))
				break;
			int [] p=new int[27];
			for(int i=0;i<s.length();i++)
			{
				char c=s.charAt(i);
				if(c=='_')
					p[26]++;
				else
					p[c-'A']++;
			}
			PriorityQueue<Node> pq=new PriorityQueue<Node>();
			for(int i=0;i<27;i++)
			{
				if(p[i]>0)
				{
					pq.add(new Node(p[i]));
				}
			}
			while(pq.size()>=2)
			{
				Node t1=pq.remove();
				Node t2=pq.remove();
				Node tf=new Node(t1.n+t2.n);
				tf.left=t1;
				tf.right=t2;
				pq.add(tf);
			}
			sum=0;
			get(pq.remove(),0);
			if(sum==0)
				sum=s.length();
			int all=8*s.length();
			System.out.printf("%d %d %.1f\n",all,sum,((0.0+all)/sum));
			
			
			
		}
	}
	public static void get(Node cur,int d)
	{
		if(cur.left==null&&cur.right==null)
		{
			sum+=d*cur.n;
			return;
		}
		get(cur.left,d+1);
		get(cur.right,d+1);
	}
	
}
class Node implements Comparable<Node>
{
	int n;
	Node left,right;
	public Node(int t)
	{
		n=t;
	}
	public int compareTo(Node o)
	{
		return n-o.n;
	}
}
