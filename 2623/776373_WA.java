import java.io.*;
public class Main
{
	public static void main(String [] args) throws Exception
	{
		BufferedReader cin=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(cin.readLine());
		int [] p=new int[n];
		for(int i=0;i<n;i++)
			p[i]=Integer.parseInt(cin.readLine());
		if(n%2==1)
			System.out.println(select(p,n/2,0,n-1));
		else
		{
			int s=select(p,(n-2)/2,0,n-1);
			int t=select(p,(n)/2,0,n-1);
			System.out.printf("%.1f",(s+t+0.0)/2);
		}
		
		
	}
	public static int select(int [] p,int k,int i,int j)
	{
		int m=partion(p,i,j);
		if(m==k)
			return p[m];
		if(m>k)
			return select(p,k,i,m-1);
		else
			return select(p,k-m,m+1,j);
	}
	public static int partion(int [] p,int i,int j)
	{
		if(i==j)
			return i;
		int m=i++;
		int q=j;
		while(true)
		{
			while(i<=q&&p[i]<p[m])i++;
			while(p[j]>p[m])j--;
			if(i>=j)
				break;
			int t=p[i];p[i]=p[j];p[j]=t;
			
		}
		int t=p[m];p[m]=p[j];p[j]=t;
		return j;
	}
	
}