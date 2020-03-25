import java.io.*;
import java.util.*;
;
public class Main
{
	public static void main(String[] args) throws Exception
	{
		
		//Scanner cin = new Scanner(new File("c:\\in.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n,w;
		String [] ss=br.readLine().trim().split(" +");
		n=Integer.parseInt(ss[0]);
		w=Integer.parseInt(ss[1]);
		int [] max=new int[n];
		int [] min=new int[n];
		int [] all=new int[n];
		ss=br.readLine().trim().split(" +");
		for(int i=0;i<n;i++)
			all[i]=Integer.parseInt(ss[i]);
		int tag=0;
		PriorityQueue<Integer> minq=new PriorityQueue<Integer>();
		PriorityQueue<MaxEle> maxq=new PriorityQueue<MaxEle>();
		for(int i=0;i<w;i++)
		{
			minq.add(all[i]);
			maxq.add(new MaxEle(all[i]));
		}
		for(int i=w;i<n;i++)
		{
			max[tag]=maxq.element().n;
			min[tag]=minq.element();
			tag++;
			maxq.remove(new MaxEle(all[i-w]));
			minq.remove(all[i-w]);
			maxq.add(new MaxEle(all[i]));
			minq.add(all[i]);
		}
		max[tag]=maxq.element().n;
		min[tag]=minq.element();
		tag++;
		for(int i=0;i<tag;i++)
		{
			System.out.print(min[i]+" ");
		}
		System.out.println();
		for(int i=0;i<tag;i++)
		{
			System.out.print(max[i]+" ");
		}
		
	}
}
class MaxEle implements Comparable<MaxEle>
{
	int n;
	public MaxEle(int t)
	{
		n=t;
	}
	public int compareTo(MaxEle o)
	{
		return o.n-n;
	}
	public boolean equals(Object o)
	{
		MaxEle t=(MaxEle)o;
		return n==t.n;
	}
	
}
