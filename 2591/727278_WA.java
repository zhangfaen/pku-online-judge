import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args)
	{
		Scanner cin=new Scanner(System.in);
		
		int [] p=new int[10000001];
		p[0]=1;p[1]=3;p[2]=4;p[3]=7;
		int num=4;
		int tag=1;
		while(num<10000000)
		{
			int s=p[tag]*3+1;
			int t=p[tag+1]*2+1;
			if(s>t)
			{
				p[num++]=t;
				p[num++]=s;
			}
			else
			if(s<t)
			{
				p[num++]=s;
				p[num++]=t;
			}
			else
			{
				p[num++]=s;
			}
			tag++;
			
			
		}
		while(cin.hasNext())
		{
			int n=cin.nextInt();
			System.out.println(p[n-1]);
			
		}
	}
}