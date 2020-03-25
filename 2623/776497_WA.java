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
			
			
			
		Arrays.sort(p);
		if(n%2==1)
			System.out.println(p[n/2]+".0");
		else
			System.out.printf("%.1f\n",(p[n/2-1]+p[n/2]+0.0)/2);
		
		/*
		if(n%2==1)
			System.out.printf("%.1f",select(p,n/2,0,n-1)+0.0);
		else
		{
			int s=select(p,(n-2)/2,0,n-1);
			int t=select(p,(n)/2,0,n-1);
		//	System.out.println(s+"  "+t);
			System.out.printf("%.1f",(s+t+0.0)/2);
		}*/
		
		
	}
	public static int select(int [] p,int k,int i,int j)
	{
		int m=partion(p,i,j);
		if(m==k)
			return p[m];
		if(m>k)
			return select(p,k,i,m-1);
		else
			return select(p,k-m+i,m+1,j);
	}
	public static int partion(int [] p,int i,int j)
	{
		if(i==j)
			return i;
		int tmp=p[i];
		int m=i-1;
		int q=j+1;
		while(m<q)
		{
			while(p[++m]>tmp);
			while(p[--q]>tmp);
			if(m<q)
			{
				int t=p[m];p[m]=p[q];p[m]=t;

			}		
			
		}
		
		return j;
	}
	
}