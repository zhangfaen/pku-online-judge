import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String [] args)	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(Ssytem.in);
		int T=cin.nextInt();
		while(T--!=0)
		{
			int N=cin.nextInt();
			int M=cin.nextInt();
			int [] a=new int[N+1];
			while(M--!=0)
			{
				String c=cin.next();
				int p=cin.nextInt();
				int q=cin.nextInt();
				if(p>q)
				{
					int t=p;p=q;q=t;
				}
				if(c.charAt(0)=='A')
				{
					if(p==q)
						System.out.println("In the same gang.");
					else
					if(a[p]==0&&a[q]==0)
					{
						System.out.println("Not sure yet.");
					}
					else
					{
						int pd=deep(a,p);
						int qd=deep(a,q);
						int pf=father(a,p);
						int qf=father(a,q);
						if(pf!=qf)
							System.out.println("Not sure yet.");
						else
							if((pd-qd)%2==0)
								System.out.println("In the same gang.");
							else
								System.out.println("In different gangs.");
					}
				}
				else
				{
					a[q]=p;
				}
			}
		}
	}
	private static int deep(int [] a,int b)
	{
		int level=0;
		while(a[b]!=0)
		{
			level++;
			b=a[b];
			
		}
		return level;
	}
	private static int father(int [] a,int b)
	{
		while(a[b]!=0)
			b=a[b];
		return b;
	}
	
}