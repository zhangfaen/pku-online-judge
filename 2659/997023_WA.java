import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args) throws FileNotFoundException
	{
		Scanner cin=new Scanner(System.in);
		int A,B,K;
		A=cin.nextInt();
		B=cin.nextInt();
		K=cin.nextInt();
		int [][] p=new int[A][B];
		
		for(int i=0;i<K;i++)
		{
			int R,S,P,T;
			R=cin.nextInt();
			S=cin.nextInt();
			P=cin.nextInt();
			T=cin.nextInt();
			P=(P-1)/2;
			int xs,ys,xe,ye;
			xs=R-P;
			ys=S-P;
			xe=R+P;
			ye=S+P;
			if(xs<0)
				xs=0;
			if(ys<0)
				ys=0;
			if(xe>=A)
				xe=A-1;
			if(ye>=B)
				ye=B-1;
			if(T==1)
			{
				for(int m=xs;m<=xe;m++)
					for(int n=ys;n<=ye;n++)
						p[m][n]++;
			}
			else
			{
				for(int m=xs;m<=xe;m++)
					for(int n=ys;n<=ye;n++)
						p[m][n]--;
			}
			
		}
		int max=-10000;
		for(int i=0;i<A;i++)
			for(int j=0;j<B;j++)
				if(p[i][j]>max)
					max=p[i][j];
		int re=0;
		for(int i=0;i<A;i++)
			for(int j=0;j<B;j++)
				if(p[i][j]==max)
					re++;
		System.out.println(re);
		
	}
}