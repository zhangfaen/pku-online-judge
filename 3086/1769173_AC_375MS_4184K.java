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
			long re=0;
			for(int i=1;i<=n;i++)
			{
				re+=i*(i+2)*(i+1)/2;
			}
			System.out.printf("%d %d %d\n", tsi,n,re);
		}
	}
}
