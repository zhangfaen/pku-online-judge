import java.io.*;
import java.util.Arrays;
public class Main
{
	public static void main(String [] args) throws Exception
	{
		BufferedReader cin=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(cin.readLine());
		int [] p=new int[n];
		for(int i=0;i<n;i++)
			p[i]=Integer.parseInt(cin.readLine());
			
		QuickSort.sort(p);
		if(n%2==1)
			System.out.println(p[n/2]+".0");
		else
			System.out.printf("%.1f\n",(0.0+p[n/2-1]+p[n/2])/2);
	
	/*	
		if(n%2==1)
			System.out.printf("%.1f",select(p,n/2,0,n-1)+0.0);
		else
		{
			int s=select(p,(n-2)/2,0,n-1);
			int t=select(p,(n)/2,0,n-1);
			System.out.printf("%.1f",(s+t+0.0)/2);
		}
		*/
		
	}
	public static int select(int [] p,int k,int i,int j)
	{
		int m=partion(p,i,j);
		if(m==k)
			return p[m];
		if(m>k)
			return select(p,k,i,m-1);
		else
			return select(p,k,m+1,j);
	}
	private static int partion(int [] p,int l,int r)
	{
		int t=p[l];
		int i=l+1;
		int j=r;
		while(i<=j)
		{
			while(i<=r&&p[i]<=t)i++;
			while(j>l&&p[j]>=t)j--;
			if(i<j)
			{
				int ex=p[i];p[i]=p[j];p[j]=ex;
			}
		}
		p[l]=p[j];
		p[j]=t;
		return j;
	}
	
	
	
}
 class QuickSort
{
	public static void sort(int [] p)
	{
		qsort(p,0,p.length-1);
	}

	private static void qsort(int [] p,int l,int r)
	{
		if(l<r)
		{
			int mid=partion(p,l,r);
			qsort(p,l,mid-1);
			qsort(p,mid+1,r);
		}
	}

	private static int partion(int [] p,int l,int r)
	{
		int t=p[l];
		int i=l+1;
		int j=r;
		while(i<=j)
		{
			while(i<=r&&p[i]<=t)i++;
			while(j>l&&p[j]>=t)j--;
			if(i<j)
			{
				int ex=p[i];p[i]=p[j];p[j]=ex;
			}
		}
		p[l]=p[j];
		p[j]=t;
		return j;
	}

}