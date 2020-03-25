import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Main
{

	static class Box implements Comparable<Box>
	{
		int [] p;
		public Box(String s)
		{
			String [] sa=s.trim().split(" +");
			p=new int[d];
			for(int i=0;i<d;i++)
				p[i]=Integer.parseInt(sa[i]);
			Arrays.sort(p);
		}
		public int compareTo(Box o)
		{
			for(int i=0;i<d;i++)
			{
				if(p[i]!=o.p[i])
					return p[i]-o.p[i];
			}
			return 0;
		}
	}
	public static boolean canC(Box b1,Box b2)
	{
		for(int i=0;i<d;i++)
			if(b1.p[i]>=b2.p[i])
				return false;
		return true;
	}
	static int n,d;
	static Box [] boxs;
	static Box gift;
	static int []memo;
	static boolean [][] contain;
	public static void main(String [] args) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String [] sa=br.readLine().trim().split(" +");
		n=Integer.parseInt(sa[0]);
		d=Integer.parseInt(sa[1]);
		gift=new Box(br.readLine());
		boxs=new Box[n];
		for(int i=0;i<n;i++)
		{
			boxs[i]=new Box(br.readLine());
		}
		Arrays.sort(boxs);
		memo=new int[n];
		Arrays.fill(memo, -1);
		contain=new boolean[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
			{
				contain[i][j]=canC(boxs[i],boxs[j]);
			}
		int re=0;
		for(int i=0;i<n;i++)
		{
			if(canC(gift,boxs[i]))
			{
				re=Math.max(re, 1+dp(i));
			}
		}
		if(re==0)
		{
			System.out.println("Please look for another gift shop!");
			return;
		}
		System.out.println(re-1);
	}
	public static int dp(int index)
	{
		if(memo[index]!=-1)
			return memo[index];
		int re=1;
		for(int i=index+1;i<n;i++)
		{
			if(contain[index][i])
			{
				re=Math.max(re, 1+dp(i));
			}
		}
		return memo[index]=re;
	}
}

