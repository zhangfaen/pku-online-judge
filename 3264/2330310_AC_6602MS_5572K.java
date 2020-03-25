import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main
{
	static class MaxMin
	{
		int max,min;
		public MaxMin(int a,int b)
		{
			max=a;
			min=b;
		}
	}
	static BufferedReader cin = null;
	static PrintWriter out = new PrintWriter(System.out);
	static int n;
	static MaxMin [] mm;
	static int [] p;
	public static void main(String[] args) throws Exception
	{
		cin = new BufferedReader(new InputStreamReader(System.in));
		String s = cin.readLine();
		StringTokenizer st=new StringTokenizer(s);
		n=Integer.parseInt(st.nextToken());
		int q=Integer.parseInt(st.nextToken());
		p=new int[n];
		for(int i=0;i<n;i++)
		{
			s=cin.readLine();
			p[i]=Integer.parseInt(s);
		}
		mm=new MaxMin[4*n];
		for(int i=0;i<q;i++)
		{
			s=cin.readLine();
			st=new StringTokenizer(s);
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			MaxMin re=calc(1,0,n-1,x-1,y-1);
			out.println(re.max-re.min);
		}
		out.flush();
	}
	public static MaxMin calc(int ci,int left,int right,int x,int y)
	{
		if(left==x&&right==y)
		{
			if(mm[ci]!=null)
				return mm[ci];
			if(left==right)
			{
				return new MaxMin(p[left],p[left]);
			}
			int mid=(left+right)/2;
			MaxMin mm1=calc(2*ci,left,mid,left,mid	);
			MaxMin mm2=calc(2*ci+1,mid+1,right,mid+1,right);
			mm[ci]=new MaxMin(Math.max(mm1.max, mm2.max),Math.min(mm1.min, mm2.min));
			return mm[ci];
		}
		int mid=(left+right)/2;
		if(x>=mid+1)
			return calc(ci*2+1,mid+1,right,x,y);
		else if(y<=mid)
			return calc(ci*2,left,mid,x,y);
		else
		{
			MaxMin mm1=calc(2*ci,left,mid,x,mid	);
			MaxMin mm2=calc(2*ci+1,mid+1,right,mid+1,y);
			return new MaxMin(Math.max(mm1.max, mm2.max),Math.min(mm1.min, mm2.min));
		}
	}
}
