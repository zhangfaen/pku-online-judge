import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Main
{
	public static void main(String [] args)
	{
		Scanner cin=new Scanner(System.in);
		BigInteger [] map=new BigInteger[251];
		BigInteger b3=new BigInteger("2");
		map[0]=new BigInteger("0");
		map[1]=new BigInteger("1");
		map[2]=new BigInteger("3");
		for(int i=3;i<=250;i++)
			map[i]=map[i-1].add(map[i-2].multiply(b3));
		while(cin.hasNextInt())
		{
			System.out.println(map[cin.nextInt()]);
		}		
	}
}