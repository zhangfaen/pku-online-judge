import java.io.*;
import java.util.*;
import java.math.*;
public class Main
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter cout = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean [] isPrime=new boolean[10000];
		Arrays.fill(isPrime, true);
		for(int i=2;i<10000;i++)
			if(isPrime[i])
			{
				for(int j=i*i;j<10000;j+=i)
				{
					isPrime[j]=false;
				}
			}
		while (true)
		{
			int n, c;
			String s=cin.readLine();
			if(s==null)break;
			String[] t = s.split(" ");
			n = Integer.parseInt(t[0]);
			c = Integer.parseInt(t[1]);
			List<Integer>li=new ArrayList<Integer>();
			for(int i=2;i<=n;i++)
				if(isPrime[i])
					li.add(i);
			if(li.size()%2==1)
			{
				int start=li.size()/2-c;
				System.out.print(n+" "+c+":");
				for(int i=Math.max(0, start),j=0;i<li.size()&&j<2*c;j++,i++)
				{
					System.out.print(" "+li.get(i));
				}
			}
			else
			{
				int start=li.size()/2-1-(c-1-1);
				System.out.print(n+" "+c+":");
				for(int i=Math.max(0, start),j=0;i<li.size()&&j<2*c-1;j++,i++)
				{
					System.out.print(" "+li.get(i));
				}
			}
			System.out.println();
		}
	}
}