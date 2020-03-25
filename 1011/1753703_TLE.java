import java.io.*;
import java.util.*;
public class Main
{
	static int [] p;
	static boolean [] usd;
	static int n;
	static int s,len;
	public static void main(String [] args)throws Exception
	{
		BufferedReader cin=new BufferedReader(new InputStreamReader(System.in));
		out:while(true)
		{
			String cs=cin.readLine();
			n=Integer.parseInt(cs);
			if(n==0)break;
			p=new int[n];
			usd=new boolean[n];
			cs=cin.readLine().trim();
			String [] sa=cs.split(" +");
			int sum=0,sl=0;
			for(int i=0;i<n;i++)
			{
				p[i]=Integer.parseInt(sa[i]);
				sum+=p[i];
				sl=Math.max(sl, p[i]);
			}
			Arrays.sort(p);
			for(int i=sl;i<sum;i++)
			{
				if(sum%i==0)
				{
					len=i;
					s=sum/i;
					Arrays.fill(usd, false);
					try
					{
						usd[0]=true;
						dfs(p[0],0,1);
					}
					catch(Exception e)
					{
						System.out.println(len);
						continue out;
					}
					
				}
			}
			System.out.println(sum);
		}
	}
	public static void dfs(int clen,int num,int ci)throws Exception
	{
		if(num==s-1&&clen==len)
		{
			throw new Exception("");
		}
		if(clen==len)
		{
			for(int i=0;i<n;i++)
			{
				if(usd[i]==false)
				{
					usd[i]=true;
					dfs(p[i],num+1,i+1);
					usd[i]=false;
					return;
				}
				
			}
		}
		for(int i=ci;i<n;i++)
		{
			if(clen+p[i]<=len&&usd[i]==false)
			{
				usd[i]=true;
				dfs(clen+p[i],num,i+1);
				usd[i]=false;
				dfs(clen,num,i+1);
			}
			else
				break;
		}
		
	}
	
}
