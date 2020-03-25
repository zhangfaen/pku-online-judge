import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		Scanner cin=new Scanner(System.in);
		//Scanner cin=new Scanner(new FileInputStream("c:\\in.txt"));
		int testcase=cin.nextInt();
		while(testcase--!=0){
			int n=cin.nextInt();
			int [] p=new int[n];
			for(int i=0;i<n;i++)
				p[i]=cin.nextInt();
			int [] pre=new int[n];
			int [] pos=new int[n];
			
			f(p,pre);
			g(p,pos);
			
			int max=Integer.MIN_VALUE;
			for(int i=0;i<n-1;i++)
			{
				if(max<pre[i]+pos[i+1])
					max=pre[i]+pos[i+1];
			}
		//	print(pre);
		//	print(pos);
			System.out.println(max);
		}
		
	}
	public static void f(int [] p,int [] pre)
	{
		int max=Integer.MIN_VALUE;
		int b=0;
		for(int i=0;i<p.length-1;i++)
		{
			if(b>0)
				b+=p[i];
			else
				b=p[i];
			if(max<b)
				max=b;
			pre[i]=max;
		}
	}
	public static void g(int [] p,int [] pos)
	{
		int max=Integer.MIN_VALUE;
		int b=0;
		for(int i=p.length-1;i>0;i--)
		{
			if(b>0)
				b+=p[i];
			else
				b=p[i];
			if(max<b)
				max=b;
			pos[i]=max;
		}
	}
	public static void print(int [] p)
	{
		for(int i=0;i<p.length;i++)
			System.out.print(p[i]+" ");
		System.out.println();
	}
}