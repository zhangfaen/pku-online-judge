import java.io.*;
import java.util.*;
import java.math.*;
public class Main
{
	static class Pair implements Comparable<Pair>
	{
		int x,y;
		public Pair(int a,int b)
		{
			x=a;y=b;
		}
		public int compareTo(Pair o)
		{
			if(x!=o.x)
				return x-o.x;
			return y-o.y;
		}
	}
	static int M,N;
	static int [] map;
	static int [] pool;
	public static void main(String[] args)throws Exception
	{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		String s=null;
		String [] sa=null;
		int tc=Integer.parseInt(in.readLine());
		for(int go=1;go<=tc;go++)
		{
			s=in.readLine();
			sa=s.split(" ");
			M=Integer.parseInt(sa[0]);
			N=Integer.parseInt(sa[1]);
			int K=Integer.parseInt(sa[2]);
			Pair [] allp=new Pair[K];
			for(int i=0;i<K;i++)
			{
				s=in.readLine();
				sa=s.split(" ");
				int a=Integer.parseInt(sa[0]);
				int b=Integer.parseInt(sa[1]);
				allp[i]=new Pair(a,b);
			}
			Arrays.sort(allp);
			map=new int[K];
			pool=new int[K];
			for(int i=0;i<K;i++)
				map[i]=allp[i].y;
			long re=getNiXu(0,K-1);
			System.out.printf("Test case %d: %d\n",go,re);
		}
	}
	public static long getNiXu(int left,int right)
	{
		if(left==right)
			return 0;
		long re=0;
		int mid=(left+right)/2;
		re+=getNiXu(left,mid);
		re+=getNiXu(mid+1,right);
		int cl=left,cr=mid+1;
		int tag=left;
		while(cl<=left&&cr<=right)
		{
			if(map[cl]<=map[cr])
			{
				pool[tag++]=map[cl++];
			}
			else
			{
				re+=(mid-cl+1);
				pool[tag++]=map[cr++];
			}
		}
		while(cl<=left)
			pool[tag++]=map[cl++];
		while(cr<=right)
			pool[tag++]=map[cr++];
		for(int i=left;i<=right;i++)
			map[i]=pool[i];
		return re;
	}
	
	
	
	
	
	
	
	
	
	
}