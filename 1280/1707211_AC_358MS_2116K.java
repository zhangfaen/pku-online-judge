
import java.io.*;
import java.util.*;
public class Main
{
	static double pa,pb;
	static int K,L;
	static double [][][] memoR;
	static double [][][] memoG;
	public static void main(String []args)
	{
		Scanner cin=new Scanner(System.in);
		int ts=cin.nextInt();
		while(ts--!=0)
		{
			pa=cin.nextInt()/100.0;
			pb=cin.nextInt()/100.0;
			K=cin.nextInt();
			L=cin.nextInt();
			memoR=new double[2][L+1][L+1];
			memoG=new double[2][K+1][K+1];
			for(int i=0;i<L+1;i++)
				for(int j=0;j<L+1;j++)
					memoR[0][i][j]=memoR[1][i][j]=-1;
			for(int i=0;i<K+1;i++)
				for(int j=0;j<K+1;j++)
					memoG[0][i][j]=memoG[1][i][j]=-1;
			double re=0;
			re+=0.5*dpG(0,0,0)+0.5*dpG(1,0,0);
			re*=100;
			System.out.printf("%.1f\n",re);
		}
	}
	public static double dpG(int serve,int aw,int bw)
	{
		if(aw==K&&bw<K)
			return 1;
		if(bw==K&&aw<K)
			return 0;
		if(memoG[serve][aw][bw]!=-1)
			return memoG[serve][aw][bw];
		double re=0;
		if(serve==0)
		{
			double d=dpR(0,0,0);
			re+=d*dpG(1,aw+1,bw)+(1-d)*dpG(1,aw,bw+1);
		}
		else
		{
			double d=dpR(1,0,0);
			re+=d*dpG(0,aw+1,bw)+(1-d)*dpG(0,aw,bw+1);
		}
		return memoG[serve][aw][bw]=re;
	}
	public static double dpR(int serve,int aw,int bw)
	{
		if(aw==L&&bw<L)
			return 1;
		if(bw==L&&aw<L)
			return 0;
		if(memoR[serve][aw][bw]!=-1)
			return memoR[serve][aw][bw];
		double re=0;
		if(serve==0)
			re+=pa*dpR(0,aw+1,bw)+(1-pa)*dpR(1,aw,bw+1);
		else
			re+=pb*dpR(1,aw,bw+1)+(1-pb)*dpR(0,aw+1,bw);
		return memoR[serve][aw][bw]=re;
	}
}
