import java.io.*;
import java.util.*;
import java.math.*;
public class Main
{
	public static void main(String args[]) throws Exception
	{
		InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(in);
		int n=cin.nextInt();
		int a,b;
		int sum=0;
		a=cin.nextInt();
		for(int i=1;i<n;i++)
		{
			b=cin.nextInt();
			if(a-b>0)
				sum+=a-b;
			else
				sum+=b-a;
			a=b;
		}
		System.out.println(sum);
		
	}
}
