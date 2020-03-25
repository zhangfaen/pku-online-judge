import java.math.BigInteger;
import java.util.Scanner;

public class Main
{
	

	public static void main(String[] args) throws Exception
	{
		Scanner cin = new Scanner(System.in);
		while(cin.hasNextInt())
		{
			int n=cin.nextInt();

			BigInteger p=new BigInteger(cin.next());
			int left=1,right=1000000000;
			while(left<=right)
			{
				int mid=(left+right)/2;
				BigInteger tk=new BigInteger(""+mid);
				BigInteger powtk=tk.pow(n);
				if(powtk.equals(p))
				{
					System.out.println(mid);
					break;
				}
				else if(powtk.compareTo(p)<0)
				{
					left=mid+1;
				}
				else right=mid-1;
			}
		}
		
		
	}

	
}