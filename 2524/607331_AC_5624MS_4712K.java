import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args) throws Exception
	{
		Scanner cin=new Scanner(System.in);
		int cases=0;
		while(true)
		{
			int n=cin.nextInt();
			int m=cin.nextInt();
			if(n+m==0)
				break;
			cases++;
			
			int [] p=new int[n+1];
			boolean [] q=new boolean[n+1];
			for(int i=1;i<=n;i++)
				p[i]=i;
			for(int i=1;i<=m;i++)
			{
				int a=cin.nextInt();
				int b=cin.nextInt();
				int t=a;
				while(q[t])
				{
					t=p[t];
				}
				int s=b;
				while(q[s])
				{
					s=p[s];
				}
				p[s]=t;
				if(t!=s)q[s]=true;
			}
			int sum=0;
			for(int i=1;i<=n;i++)
				if(q[i]==false)
					sum++;		
			System.out.printf("Case %d: %d\n",cases,sum);
		}
	}
}