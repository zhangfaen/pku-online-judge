import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader cin = new BufferedReader(
			new InputStreamReader(System.in));
		String s = cin.readLine();
		int ts = Integer.parseInt(s);
		while (ts-- != 0)
		{
			int n = Integer.parseInt(cin.readLine());
			int[] p;
			s = cin.readLine();
			String[] sa = s.split(" ");
			if (n % 2 == 0)
			{
				p = new int[n];
				for (int i = 0; i < n; i++)
					p[i] = Integer.parseInt(sa[i]);
			} else
			{
				p = new int[n + 1];
				for(int i=0;i<n;i++)
					p[i+1]=Integer.parseInt(sa[i]);
				n++;
			}
			int [] q=new int[n/2];
			for(int i=0;i<n-1;i+=2)
			{
				q[i/2]=p[i+1]-p[i];
			}
			int xor=0;
			for(int d:q)
				xor^=d;
			if(xor==0)
			{
				System.out.println("Bob will win");
			}
			else
			{
				System.out.println("Georgia will win");
			}
		}
	}
}
