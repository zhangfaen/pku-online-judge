import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main
{
	static int [][] p;
	static int [][] re;
	static int n;
	public static void main(String [] args) throws FileNotFoundException
	{
		Scanner cin=new Scanner(System.in);
		while(true)
		{
			n=cin.nextInt();
			if(n==0)
				break;
			p=new int[n][n];
			String [] as=new String[n];
			for(int i=0;i<n;i++)
				as[i]=cin.next();
			calc(as);
			re=new int[n][1<<n];
			for(int i=0;i<n;i++)
				for(int j=0;j<1<<n;j++)
					re[i][j]=-1;
			int remax=0;
			for(int i=0;i<n;i++)
			{
				//System.out.println(i+" "+Integer.toBinaryString();
				int t=f(i,((1<<n)-1)&(~(1<<i)));
				
				if(t>remax)
					remax=t;
			}
			System.out.println(remax);
		}
		
	}
	public static int f(int d,int state)
	{
		if(re[d][state]!=-1)
			return re[d][state];
		if(state==0)
			return 0;
		int max=0;
		for(int i=0;i<n;i++)
		{
			if((1<<i&state)!=0)
			{
				int tmax=f(i,state&~(1<<i))+p[d][i];
				if(max<tmax)
					max=tmax;
			}
		}
		return re[d][state]=max;
	}
	
	public static void calc(String [] as)
	{
		int n=as.length;
		for(int i=0;i<n-1;i++)
			for(int j=i+1;j<n;j++)
			{
				int max=0;
				String s=as[i];
				String t=as[j];
				for(int k=0;k<s.length();k++)
				{
					int tmax=0;
					for(int m=0;m<t.length()&&m+k<s.length();m++)
						if(s.charAt(m+k)==t.charAt(m))
							tmax++;
					if(tmax>max)
						max=tmax;
					
				}
				s=as[j];
				t=as[i];
				for(int k=0;k<s.length();k++)
				{
					int tmax=0;
					for(int m=0;m<t.length()&&m+k<s.length();m++)
						if(s.charAt(m+k)==t.charAt(m))
							tmax++;
					if(tmax>max)
						max=tmax;
				
				}
				p[i][j]=p[j][i]=max;
			}
	}
	
	
}
