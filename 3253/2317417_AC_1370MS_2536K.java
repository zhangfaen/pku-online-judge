import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Main
{
	static BufferedReader cin = null;
	static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) throws Exception
	{
		cin = new BufferedReader(new InputStreamReader(System.in));
		String s=cin.readLine();
		int n=Integer.parseInt(s);
		int [] p=new int[n];
		long res=0;
		PriorityQueue<Integer> q=new PriorityQueue<Integer>();
		for(int i=0;i<n;i++)
		{
			s=cin.readLine();
			p[i]=Integer.parseInt(s);
			q.add(p[i]);
		}
		while(q.size()>1)
		{
			int d1=q.poll();
			int d2=q.poll();
			res+=d1+d2;
			q.add(d1+d2);
		}
		System.out.println(res);
	}
	
}
