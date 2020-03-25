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
		lld.add(Double.MIN_VALUE);
		Collections.sort(lld);
		while(lld.size()>2)
		{
			double a=lld.removeLast();
			double b=lld.removeLast();
			double c=2*Math.sqrt(a*b);
			lld.add(c);
			Collections.sort(lld);
		}
		System.out.printf("%.3f",lld.get(1));
	}
}