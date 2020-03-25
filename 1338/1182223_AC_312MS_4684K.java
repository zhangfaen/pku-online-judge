import java.math.BigInteger;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		Scanner cin=new Scanner(System.in);
		LinkedList<BigInteger> li = new LinkedList<BigInteger>();
		for(int i = 0; i <= 30; i++){
			for(int j = 0; j <= 20; j++){
				for(int k = 0; k <= 15; k++){
					li.add(new BigInteger("" + 2).pow(i).multiply(new BigInteger(""+3).pow(j).multiply(new BigInteger(""+5).pow(k))));
				}
			}
		}
		Collections.sort(li);
		while(true)
		{
			int n=cin.nextInt();	
			if(n==0)
				break;
			System.out.println(li.get(n-1));	
		}
	}
}
