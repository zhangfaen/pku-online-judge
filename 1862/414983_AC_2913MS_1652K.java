import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String [] args)
	{
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt();
		LinkedList<Double>lld=new LinkedList<Double>();
		for(int i=0;i<n;i++)
			lld.add((double)cin.nextInt());
		lld.add(Double.MAX_VALUE);
		lld.add(Double.MIN_VALUE);
		Collections.sort(lld);
		while(lld.size()>3)
		{
			double a=lld.remove(lld.size()-2);
			double b=lld.remove(lld.size()-2);
			double c=2*Math.sqrt(a*b);
			for(int i=lld.size()-1;i>=0;i--)
			{
				double t=lld.get(i);
				if(c>=t)
				{
					lld.add(i+1,c);
					break;
				}
			}
		}
		System.out.printf("%.3f",lld.get(1));
	}
}