import java.io.*;
import java.util.*;
public class Main
{
	private static int sum=0;
	private static int M;
	private static int N;
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		int T=cin.nextInt();
		while(T--!=0)
		{
			sum=0;
			M=cin.nextInt();
			N=cin.nextInt();
			for(int i=1;i<=M;i++)
				f(i,M-i,1);
			System.out.println(sum);
			
		}	
	}
	private static void f(int pre,int remain,int level)
	{
		if(level>N&&remain!=0)return;
		if(remain==0)
		{
			if(level<=N)
				sum++;
			return;
		}
		for(int i=pre;i<=remain;i++)
		{
			f(i,remain-i,level+1);
		
		}
	}
}