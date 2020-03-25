import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String s=cin.readLine();
			int n=Integer.parseInt(s);
			if(n==0)break;
			int []p=new int[n];
			for(int i=0;i<n;i++)
			{
				s=cin.readLine();
				p[i]=Integer.parseInt(s);
			}
			long re=MergeSortWithNiXu.sortAndGet(p);
			System.out.println(re);
			
		}
	}
}
class MergeSortWithNiXu
{
	static int [] map;
	static int [] pool;
	public static long sortAndGet(int [] p)
	{
		map=p;
		pool=new int[p.length];
		return getNiXu(0,p.length-1);
	}
	private static long getNiXu(int left,int right)
	{
		if(left==right)
			return 0;
		long re=0;
		int mid=(left+right)/2;
		re+=getNiXu(left,mid);
		re+=getNiXu(mid+1,right);
		int cl=left,cr=mid+1;
		int tag=left;
		while(cl<=mid&&cr<=right)
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
		while(cl<=mid)
			pool[tag++]=map[cl++];
		while(cr<=right)
			pool[tag++]=map[cr++];
		for(int i=left;i<=right;i++)
			map[i]=pool[i];
		return re;
	}
}