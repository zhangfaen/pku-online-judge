import java.util.Scanner;

public class Main
{
	public static void main(String[] args) throws Exception
	{
//		BufferedReader cin = new BufferedReader(
//			new InputStreamReader(System.in));
		Scanner cin=new Scanner(System.in);
		while (cin.hasNextInt())
		{
			int n=cin.nextInt();
			int [] p=new int[n];
			for(int i=0;i<n;i++)
				p[i]=cin.nextInt();
			int xor=0;
			for(int d:p)
				xor^=d;
			if(xor==0)
				System.out.println("No");
			else
				System.out.println("Yes");
		}
	}
}
