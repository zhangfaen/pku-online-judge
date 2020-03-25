import java.util.*;
import java.io.*;
public class Main
{
	static int [] sum=new int[6];
	static int [] p=new int[6];
	static short [][]q=new short[6][12001];
	static boolean ok=false;
	public static void main(String [] args) throws Exception
	{
		Scanner cin=new Scanner(System.in);
		int tag=0;
		while(true)
		{
			int bre=0;
			for(int i=0;i<6;i++)
			{
				int t=cin.nextInt();
				bre+=t;
				p[i]=t;
				if(i>0)
					sum[i]=(i+1)*t+sum[i-1];
				else
					sum[i]=(i+1)*t;
			}
			if(bre==0)
				break;
			for(int i=0;i<6;i++)
				for(int j=0;j<12001;j++)
					q[i][j]=0;
			tag++;
			if(sum[5]%2!=0)
			{
				System.out.println("Collection #"+tag+":\nCan't be divided.");
			}
			else
			{
				int t=f(5,sum[5]/2);
				if(t==1)
					System.out.println("Collection #"+tag+":\nCan be divided.");
				else
					System.out.println("Collection #"+tag+":\nCan't be divided.");
			}
		}
	}
	public static short f(int d,int num)
	{
		if(num==0)
			return 1;
		if(q[d][num]==-1)
			return -1;
		if(q[d][num]==1)
			return 1;
		if(d==0)
		{
			if(p[d]>=num)
				return q[d][num]=1;
			else
				return q[d][num]=-1;
		}
		if(sum[d]<num)
			return -1;
		short t=-1;
		for(int i=0;i<=p[d];i++)
		{
			if(num>=i*(d+1))
				t=f(d-1,num-i*(d+1));
		}
		return q[d][num]=t;
	}
}
