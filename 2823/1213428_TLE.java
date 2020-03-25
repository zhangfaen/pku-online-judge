import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
;
public class Main
{
	public static void main(String[] args) throws Exception
	{
		
		//Scanner cin = new Scanner(new File("c:\\in.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String [] ss=br.readLine().trim().split(" +");
		int n,w;
		n=Integer.parseInt(ss[0]);
		w=Integer.parseInt(ss[1]);
		int [] max=new int[n];
		int [] min=new int[n];
		int [] all=new int[n];
		ss=br.readLine().trim().split(" +");
		for(int i=0;i<n;i++)
			all[i]=Integer.parseInt(ss[i]);
		ss=null;
System.gc();
		int tag=0;
		PriorityQueue<Integer> minq=new PriorityQueue<Integer>(w + 1);
		PriorityQueue<Integer> maxq=new PriorityQueue<Integer>(w + 1);
		for(int i=0;i<w;i++)
		{
			minq.add(all[i]);
			maxq.add(-1 * all[i]);
		}
		for(int i=w;i<n;i++)
		{
			max[tag]= 0 - maxq.element();
			min[tag]=minq.element();
			tag++;
			maxq.remove(0 - all[i - w]);
			minq.remove(all[i-w]);
			maxq.add(0 - all[i]);
			minq.add(all[i]);
		}
		max[tag]=0 - maxq.element();
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
