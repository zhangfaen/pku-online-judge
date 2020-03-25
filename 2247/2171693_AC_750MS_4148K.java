import java.io.*;
import java.util.*;
import java.math.*;

public class Main
{
	static List[] map;
	static int n;
	static int[][] memo;
	static BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException
	{
		Set<Integer> si=new HashSet<Integer>();
		BigInteger one=new BigInteger("1");
		BigInteger two=new BigInteger("2");
		BigInteger three=new BigInteger("3");
		BigInteger five=new BigInteger("5");
		BigInteger seven=new BigInteger("7");
		BigInteger INF=new BigInteger(""+Integer.MAX_VALUE);
		for(int i=0;i<32;i++)
			for(int j=0;j<21;j++)
				for(int p=0;p<16;p++)
					for(int q=0;q<13;q++)
					{
						BigInteger bi=one;
						bi=bi.multiply(two.pow(i));
						if(bi.compareTo(INF)>=0)break;
						bi=bi.multiply(three.pow(j));
						if(bi.compareTo(INF)>=0)break;;
						bi=bi.multiply(five.pow(p));
						if(bi.compareTo(INF)>=0)break;
						bi=bi.multiply(seven.pow(q));
						if(bi.compareTo(INF)<0)
						{
							Integer t=Integer.parseInt(bi.toString());
							si.add(t);
						}
					}
		int [] p=new int[si.size()];
		int tag=0;
		for(int d:si)
			p[tag++]=d;
		Arrays.sort(p);
		PrintWriter out=new PrintWriter(System.out);
		while(true)
		{
			String s=cin.readLine();
			int n=Integer.parseInt(s);
			if(n==0)break;
			int fac=n%10;
			int tt=n/10%10;
			int v=p[n-1];
			
			if(fac==1&&tt!=1)
			{
				out.println("The "+n+"st humble number is "+v+".");
			}else
			if(fac==2&&tt!=1)
			{
				out.println("The "+n+"nd humble number is "+v+".");
			}else
			if(fac==3&&tt!=1)
			{
				out.println("The "+n+"rd humble number is "+v+".");
			}
			else
			{
				out.println("The "+n+"th humble number is "+v+".");
			}
		}
		out.flush();
	}
}