import java.io.*;
import java.util.*;
import java.math.*;
public class Main
{
	public static void main(String args[]) throws Exception
	{
	//	InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		while(cin.hasNextInt())
		{
		
			int n=cin.nextInt();
			int a=0;
			for(int i=1;;i++)
			{
				a+=i;
				if(a>=n)
				{
					if(i%2!=0)
						System.out.println("TERM "+n+" IS "+(a-n+1)+"/"+(i-a+n));
					else
						System.out.println("TERM "+n+" IS "+(i-a+n)+"/"+(a-n+1));
					break;
				}
			}
		}
		
	}
}
