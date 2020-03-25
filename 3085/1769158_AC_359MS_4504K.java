import java.util.Scanner;


public class Main
{

	public static void main(String[] args)
	{
		Scanner cin= new Scanner(System.in);
		int ts=cin.nextInt();
		for(int tsi=1;tsi<=ts;tsi++)
		{
			int n=cin.nextInt();
			int a=0,b=0,c=0,d=0;
			while(n>=25)
			{
				a++;n-=25;
			}
			while(n>=10)
			{
				b++;n-=10;
			}
			while(n>=5)
			{
				c++;n-=5;
			}
			d=n;
			System.out.printf("%d %d QUARTER(S), %d DIME(S), %d NICKEL(S), %d PENNY(S)\n", tsi,a,b,c,d);
		}
	}
}
