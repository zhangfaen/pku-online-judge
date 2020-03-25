import java.math.BigInteger;
import java.util.Scanner;

public class Main
{
	

	public static void main(String[] args) throws Exception
	{
		Scanner cin = new Scanner(System.in);
		while(cin.hasNextLine())
		{
			String s=cin.nextLine();
			String [] sa=s.trim().split(" +");
			int v=Integer.parseInt(sa[0],Integer.parseInt(sa[1]));
			String re=Integer.toString(v, Integer.parseInt(sa[2]));
			if(re.length()>7)
			{
				System.out.println("  ERROR");
			}
			else
			{
				while(re.length()<7)re=" "+re;
				re=re.toUpperCase();
				System.out.println(re);
			}
		}
		
		
	}

	
}