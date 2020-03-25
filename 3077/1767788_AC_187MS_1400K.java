import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner cin=new Scanner(System.in);
		int ts=cin.nextInt();
		while(ts-->0)
		{
			int n=cin.nextInt();
			int res=0;
			while(n>=10)
			{
				res++;
				if(n%10==0)
				{
					n/=10;
				}
				else
				{
					int fac=n%10;
					n/=10;
					if(fac>=5)
					{
						n++;
					}
				}
			}
			System.out.print(n);
			for(int i=0;i<res;i++)
				System.out.print(0);
			System.out.println();
		}
	}
}
