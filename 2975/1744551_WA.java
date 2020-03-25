import java.util.*;
import java.io.*;

public class Main
{
	
	public static void main(String[] args) throws Exception
	{
		//Scanner cin = new Scanner(System.in);
		BufferedReader cin=new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String s=cin.readLine();
			int n=Integer.parseInt(s);
			if(n==0)
				break;
			if(n==1)
			{
				System.out.println(1);
				cin.readLine();
				continue;
			}
		
			int [] p=new int[n];
			s=cin.readLine();
			String [] sa=s.split(" ");
			int xor=0;
			for(int i=0;i<n;i++)
			{
				p[i]=Integer.parseInt(sa[i]);
				xor^=p[i];
			}
			if(n==2)
			{
				if(p[0]==p[1])
				{
					System.out.println(0);
				}
				else
				{
					System.out.println(1);
				}
				continue;
			}
			if(xor==0)
			{
				System.out.println(0);
				continue;
			}
			int re=0;
			for(int i=0;i<n;i++)
			{
				if(p[i]>=xor)
				{
					re++;
				}
			}
			System.out.println(re);
		}
	}
	
	
}