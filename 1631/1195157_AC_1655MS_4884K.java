import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
public class Main
{
	static int [][] p;
	static int [] map;
	public static void main(String[] args) throws Exception
	{
		Scanner cin = new Scanner(System.in);
		int cs=cin.nextInt();
		while(cs--!=0)
		{
			int n=cin.nextInt();
			int [] p=new int[n];
			p[0]=cin.nextInt();
			int tag=1;
			for(int i=1;i<n;i++)
			{
				int t=cin.nextInt();
				int index=bs(0,tag-1,p,t);
				if(index==tag)
					p[tag++]=t;
				else
					p[index]=t;
			}
			System.out.println(tag);
		}
	}
	public static int bs(int a,int b,int [] p,int tar)
	{
		while(a<=b)
		{
			int mid=(a+b)/2;
			if(p[mid]==tar)
				return mid;
			if(tar>p[mid])
				a=mid+1;
			if(tar<p[mid])
				b=mid-1;
		}
		return a;
	}
	
	
}



