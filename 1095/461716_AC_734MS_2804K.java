import java.io.*;
import java.util.*;
public class Main
{
	private static int[]p=new int[50];
	private static int[]sum=new int[50];
	private static String r="";
	public static void main(String [] args)throws Exception
	{
		Scanner cin=new Scanner(System.in);
		p[0]=1;p[1]=1;
		sum[0]=sum[1]=p[1];
		for(int i=2;i<20;i++)
		{
			for(int j=0;j<i;j++)
			{
				p[i]+=p[j]*p[i-j-1];
				
			}
			sum[i]=p[i]+sum[i-1];
		}

			
		while(true)
		{
			int n;
			n=cin.nextInt();
			if(n==0)break;
			r="";
			f(n);
			r=r.replaceAll("\\(\\)","");
			System.out.println(r);
		
		}
		
		
		

		
	
	}
	private static void f(int n)throws Exception
	{
		if(n<=-1)throw new IOException("-1");
		if(n==0)return ;
		if(n==1)
		{
			r+="X";
			return;
		}
		int t=0;
		int nodes=-1;
		for(int i=1;i<20;i++)
		{
			t+=p[i];
			if(t>=n)	
			{
				nodes=i;
				break;
			}
		}
		t-=p[nodes];
		int leftn;
		int rightn=-1;
		int rights=-1;
		int lefts=-1;
		int ls=0;
		wfor:for(leftn=0;leftn<nodes;leftn++)
		{
			rightn=nodes-1-leftn;
			for(lefts=0;lefts<p[leftn];lefts++)
			{
				t+=p[rightn];
				ls++;
				if(t>=n)
				{
					t-=p[rightn];
					break wfor;
				}
			}	
		}
		r+="(";
		if(leftn<=1)
			f(leftn);
		else
			f(ls-1);
		r+=")X(";
		if(rightn<=1)
			f(rightn);
		else
			f(n-t+sum[rightn-1]);
		r+=")";
	
	}
}