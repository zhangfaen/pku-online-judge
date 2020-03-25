import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt();
		int m=cin.nextInt();
		int [] p=new int[n+1];
		for(int i=0;i<n;i++)
			p[i+1]=cin.nextInt();
		while(m--!=0)
		{
			int i,j,k;
			i=cin.nextInt();
			j=cin.nextInt();
			k=cin.nextInt();
			int length=j-i+1;
			int [] t=new int[length];
			for(int x=0;x<length;x++)
			{
				t[x]=p[x+i];
			}
			
			System.out.println(f(t,0,length-1,k-1));
		}
			
	}
	private static int f(int [] p,int i,int j,int k)
	{
		if(i==j)
			return p[i];
		int t=partion(p,i,j);
		if(t-i==k)
			return p[t];
		if(t-i>k)
			return f(p,i,t-1,k);
		if(t<k)
			return f(p,t+1,j,k-t-1);
		return -1;
	}
	private static int partion(int [] p,int i,int j)
	{
		int left=i+1;
		int right=j;
		while(left<right)
		{
			while(p[left]<=p[i]&&left<j)left++;
			while(p[right]>=p[i]&&right>i)right--;
			if(left>=right)
				break;
			int swap=p[left];
			p[left]=p[right];
			p[right]=swap;
		}
		int swap=p[right];
		p[right]=p[i];
		p[i]=swap;
		return right;
		
	}

	
}
