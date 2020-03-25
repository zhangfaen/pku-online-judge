import java.io.*;
import java.util.*;
public class Main
{

	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		while(cin.hasNextInt())
		{
			int n=cin.nextInt();
			int r=1;
			if(n==0)
			{
				System.out.printf("%5d -> %d\n",n,1);
				continue;
			}
			for(int i=1;i<=n;i++)
			{
				r=r*i;
				while(r%10==0)
					r/=10;
				r%=10;
			}
			System.out.printf("%5d -> %d\n",n,r);
		}
	}
}