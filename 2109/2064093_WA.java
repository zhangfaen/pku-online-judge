import java.math.BigInteger;
import java.util.Scanner;

public class Main
{
	

	public static void main(String[] args) throws Exception
	{
		Scanner cin = new Scanner(System.in);
		out:while(cin.hasNextInt())
		{
			int n=cin.nextInt();

			BigInteger p=cin.nextBigInteger();
			if(n==1)
			{
				System.out.println(p);
				continue;
			}
			int left=1,right=(int)1e9;
			while(left<=right)
			{
				int mid=(left+right)/2;
				BigInteger tk=new BigInteger(""+mid);
				BigInteger powtk=tk.pow(n);
				if(powtk.equals(p))
				{
					System.out.println(mid);
					continue out;
				}
				else if(powtk.compareTo(p)<0)
				{
					left=mid+1;
				}
				else right=mid-1;
			}
			System.out.println(left);
		}
		
		
	}

	
}