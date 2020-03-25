import java.util.*;
public class Main
{
	public static void main(String [] args)
	{
		Scanner cin=new Scanner(System.in);
		while(true)
		{
			int n=cin.nextInt();
			if(n==0)break;
			Hotel [] p=new Hotel[n];
			for(int i=0;i<n;i++)
			{
				p[i]=new Hotel(cin.nextInt(),cin.nextInt());
			}
			Arrays.sort(p);
			int sum=1;
			int cur=p[0].c;
			for(int i=1;i<n;i++)
			{
				if(p[i].c<=cur)
				{
					sum++;
					cur=p[i].c;
				}
			}
			System.out.println(sum);
			
		}		
	}
}
class Hotel implements Comparable
{
	public int d;
	public int c;
	public Hotel(int d,int c)
	{
		this.d=d;
		this.c=c;
	}
	public int compareTo(Object o)
	{
		Hotel t=(Hotel)o;
		if(d<t.d)
			return -1;
		if(d>t.d)
			return 1;
		if(c>t.c)
			return -1;
		if(c<t.c)
			return 1;
		return 0;
	}
}