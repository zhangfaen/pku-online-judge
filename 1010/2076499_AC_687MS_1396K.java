import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main
{
	static int [] stamps;
	static int [] customers;
	static int [] used;
	public static void main(String [] args)throws Exception
	{
		BufferedReader cin=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		while(true)
		{
			String s=cin.readLine();
			if(s==null)break;
			String [] sa=s.trim().split(" +");
			stamps=new int[sa.length-1];
			for(int i=0;i<stamps.length;i++)
				stamps[i]=Integer.parseInt(sa[i]);
			s=cin.readLine().trim();
			sa=s.split(" +");
			customers=new int[sa.length-1];
			for(int i=0;i<customers.length;i++)
				customers[i]=Integer.parseInt(sa[i]);
			for(int i=0;i<customers.length;i++)
			{
				used=new int[stamps.length];
				ok=false;
				tie=false;
				retypes=0;
				recnts=100;
				rehighest=0;
				dfs(customers[i],0,0,0,0);
				if(tie)
				{
					System.out.printf("%d (%d): tie\n",customers[i],retypes);
				}
				else
				{
					if(ok)
					{
						System.out.printf("%d (%d):", customers[i],retypes);
						for(int j=0;j<best.length;j++)
						{
							if(best[j]>0)
							{
								while(best[j]-->0)
									System.out.print(" "+stamps[j]);
							}
						}
						System.out.println();
					}
					else
					{
						System.out.println(customers[i]+" ---- none");
					}
				}
			}
		}
	}
	static boolean ok;
	static boolean tie;
	static int retypes;
	static int recnts;
	static int rehighest;
	static int [] best;
	public static void dfs(int need,int types,int cnts,int highest,int ci)
	{
		if(need==0)
		{
			ok=true;
			if(types>retypes)
			{
				retypes=types;
				tie=false;
				recnts=cnts;
				rehighest=highest;
				best=copy(used);
			}
			else if(types==retypes)
			{
				if(cnts<recnts)
				{
					recnts=cnts;
					tie=false;
					rehighest=highest;
					best=copy(used);
					
				}
				else if(cnts==recnts)
				{
					if(highest>rehighest)
					{
						rehighest=highest;
						tie=false;
						best=copy(used);
					}
					else if(highest==rehighest)
					{
						tie=true;
					}
				}
			}
			return;
		}
		if(ci==stamps.length)return;
		dfs(need,types,cnts,highest,ci+1);
		for(int i=1;;i++)
		{
			int t=stamps[ci]*i;
			if(t>need)break;
			if(i+cnts>4)break;
			used[ci]+=i;
			dfs(need-t,types+1,cnts+i,Math.max(highest, stamps[ci]),ci+1);
			used[ci]-=i;
		}
		
	}
	public static int [] copy(int []a)
	{
		int []b=new int[a.length];
		for(int i=0;i<a.length;i++)
			b[i]=a[i];
		return b;
	}
	
}