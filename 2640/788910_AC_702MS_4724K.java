import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args) throws Exception
	{
		Scanner cin=new Scanner(System.in);
		ww:while(true)
		{
			int n=cin.nextInt();
			if(n==0)
				break;
			double [] p=new double[n];
			for(int i=0;i<n;i++)
				p[i]=cin.nextDouble();
			Arrays.sort(p);
			double sum=p[0];
			for(int i=1;i<n;i++)
			{
				if(p[i]<=sum)
				{
					System.out.println("YES");
					continue ww ;
				}
				sum+=p[i];
			}
			System.out.println("NO");
		}
	}
}