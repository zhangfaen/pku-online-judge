import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class Main
{
	public static void main(String [] args)throws Exception
	{
		BufferedReader cin=new BufferedReader(new InputStreamReader(System.in));
		out:while(true)
		{
			String s=cin.readLine().trim();
			int n=Integer.parseInt(s);
			if(n==0)break;
			int [] p=new int[n];
			for(int i=0;i<n;i++)
				p[i]=Integer.parseInt(cin.readLine().trim());
			Arrays.sort(p);
			Set<Integer> pool=new HashSet<Integer>();
			for(int i=0;i<n;i++)
				for(int j=i+1;j<n;j++)
					pool.add(p[i]+p[j]);
			for(int i=n-1;i>=0;i--)
			{
				for(int j=i-1;j>=0;j--)
				{
					if(pool.contains(p[i]-p[j]))
					{
						System.out.println(p[i]);
						continue out;
					}
				}
			}
			System.out.println("no solution");
		}
	}
}
