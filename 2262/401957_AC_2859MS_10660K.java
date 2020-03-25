import java.util.*;
import java.math.*;
public class Main
{
	public static void main(String [] args)
	{
		Scanner cin=new Scanner(System.in);
		HashSet<Integer> hs=new HashSet<Integer>();
		ArrayList<Integer>al=new ArrayList<Integer>();
		hs.add(2);
		hs.add(3);
		al.add(2);
		al.add(3);
		for(int i=4;i<1000000;i++)
			if(isPrime(i))
			{
				hs.add(i);
				al.add(i);
			}
		int n;
		while((n=cin.nextInt())!=0)
		{
			for(int i=0;i<al.size();i++)
			{
				int t=al.get(i);
				if(n>t)
				{
					if(hs.contains(n-t))
					{
						System.out.println(n+" = "+al.get(i)+" + "+(n-t));
						break;
					}
				}
				else
					break;
			}
		}
	}
	public static boolean isPrime(int x)
	{
		int t=(int)Math.sqrt(x);
		for(int i=2;i<=t+1;i++)
		{
			if(x%i==0)
				return false;
		}
		return true;
	}
	
}