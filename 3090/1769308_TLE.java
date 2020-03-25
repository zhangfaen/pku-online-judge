import java.util.Scanner;


public class Main
{

	public static void main(String[] args)
	{
		Scanner cin= new Scanner(System.in);
		int ts=cin.nextInt();
		int tag=0;
		while(ts-->0)
		{
			tag++;
			int n=cin.nextInt();
			int re=0;
			for(int i=1;i<=n;i++)
				for(int j=1;j<=n;j++)
				{
					int fac=gcd(i,j);
					if(fac==1)
						re++;
				}
			re+=2;
			System.out.println(tag+" "+n+" "+re);
		}
	}
	public static int gcd(int a,int b)
	{
		if(a==0)
			return b;
		return gcd(b%a,a);
	}
}
