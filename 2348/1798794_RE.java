import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner cin = new Scanner(System.in);
		while(true)
		{
			int m=cin.nextInt();
			int n=cin.nextInt();
			if(m+n==0)break;
			int re=dp(m,n);
			if(re==1)
				System.out.println("Stan wins");
			else
				System.out.println("Ollie wins");
		}
	}
	public static int dp(int m,int n)
	{
		if(m<n)
		{
			int t=m;m=n;n=t;
		}
		if(n==0)
			return -1;
		int fac=1;
		while(true)
		{
			int d=(fac++)*n;
			if(m<d)break;
			int tr=dp(m-d,n);
			if(tr==-1)
				return 1;
		}
		return -1;
	}
}
