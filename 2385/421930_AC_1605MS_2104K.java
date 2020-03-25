import java.io.*;
import java.util.*;
public class Main
{
	static int []a;
	static int []b;
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		int t=cin.nextInt(),w=cin.nextInt();
		int [][][]p=new int[2][w+1][t+1];
		a=new int[t];
		b=new int[t];
		for(int i=0;i<t;i++)
		{
			if(cin.nextInt()==1)
				a[i]=1;
			else
				b[i]=1;
		}

			
		for(int i=0;i<2;i++)
			for(int j=0;j<=w;j++)
			{
				p[i][j][t]=0;
			}
		for(int i=0;i<2;i++)
			for(int k=0;k<=t;k++)
			{
				if(i==0)
					p[i][0][k]=sum(a,k);
				else
					p[i][0][k]=sum(b,k);
			//	System.out.println(" "+i+" "+w+" "+k+":"+p[i][0][k]);
			}
		for(int j=1;j<=w;j++)
			for(int k=t-1;k>=0;k--)
			{
				p[0][j][k]=max(p[1][j-1][k+1]+b[k],p[0][j][k+1]+a[k]);
				p[1][j][k]=max(p[0][j-1][k+1]+a[k],p[1][j][k+1]+b[k]);
			//	System.out.println(" 0"+" "+j+" "+k+":"+p[0][j][k]);
			//	System.out.println(" 1"+" "+j+" "+k+":"+p[1][j][k]);
			}
		int res=-1;
		for(int j=0;j<=w;j++)
			if(res<p[0][j][0])
				res=p[0][j][0];
		for(int j=0;j<w;j++)
			if(res<p[1][j][0])
				res=p[1][j][0];
		System.out.println(res);
	}
	public static int sum(int [] c,int index)
	{
		int sum=0;
		for(int i=index;i<c.length;i++)
			sum+=c[i];
		return sum;
	}
	public static int max(int a,int b)
	{
		if(a>b)return a;
		return b;
	}

}