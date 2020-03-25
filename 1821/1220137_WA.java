import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
public class Main
{
	static int [][]p;
	static Tr [] tra;
	static int n,k;
	public static void main(String[] args) throws Exception
	{
		Scanner cin = new Scanner(System.in);
		n=cin.nextInt();
		k=cin.nextInt();
		tra=new Tr[k];
		for(int i=0;i<k;i++)
		{
			int a,b,c;
			a=cin.nextInt();b=cin.nextInt();c=cin.nextInt();
			c--;
			tra[i]=new Tr(c,a,b);
		}
		Arrays.sort(tra);
		p=new int[k][n];
		for(int i=0;i<k;i++)
			for(int j=0;j<n;j++)
				p[i][j]=-1;
		try
		{
			System.out.println(get(0,0));
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			
		}
		
		System.out.println();
	}
	public static int get(int i,int j)
	{
		if(i>=k-1)
		{
			if(tra[i].cen<j)
				return 0;
			int tm=Math.min(n-j,tra[i].rag);
			return p[i][j]=tm*tra[i].prc;
		}
		if(j>=n)
			return 0;
		if(p[i][j]!=-1)
			return p[i][j];
		if(tra[i].cen<j)
			return p[i][j]=get(i+1,j);
		
		int max=Integer.MIN_VALUE;
		max=Math.max(max,get(i+1,j));
		int mm=Math.max(tra[i].cen-tra[i].rag+1,j);
		for(int tag=1;mm+tag-1<n&&tag<=tra[i].rag;tag++)
		{
			max=Math.max(max,tra[i].prc*(tag)+get(i+1,mm+tag));
			
		}
		return p[i][j]=max;
	}
	
}
class Tr implements Comparable<Tr>
{
	int cen,rag,prc;

	public Tr(int c, int a, int b)
	{
		cen=c;
		rag=a;
		prc=b;
	}

	public int compareTo(Tr o)
	{
		
		return cen-o.cen;
	}
}