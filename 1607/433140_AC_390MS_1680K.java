import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		System.out.println("Cards  Overhang");
		while(cin.hasNextInt())
		{
			int a=cin.nextInt();
			System.out.printf("%5d     %.3f\n",a,suan(a));
		}
	}
	private static double suan(int a)
	{
		double r=0;
		int t=2;
		for(int i=0;i<a;i++)
		{
			r+=1.0/t;
			t+=2;
		}
		int rs=(int)(r*10000);
		if(rs%10>=5)
			rs+=10;
		rs/=10;
		return ((double)rs)/1000;
	}
}