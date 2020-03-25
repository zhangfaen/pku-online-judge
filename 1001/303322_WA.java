import java.io.*;
import java.util.Scanner;
import java.math.*;
public class Main
{
	public static void main(String [] args)throws Exception 
	{
	//	Scanner cin=new Scanner(new FileInputStream("c:\\fafa.txt"));
		Scanner cin=new Scanner(System.in);
		BigDecimal bd,re;
		int n;
		while(cin.hasNext())
		{
			bd=cin.nextBigDecimal();
			n=cin.nextInt();
			bd=bd.pow(n).stripTrailingZeros();	
			System.out.println(bd.toPlainString());
		}
	}
}