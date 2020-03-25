import java.util.*;
import java.io.*;
public class Main1316
{
	public static void main(String [] args)throws Exception
	{
		for(int i=1;i<10000;i++)
		{
			if(d(i)==1)
				System.out.println(i);
		}
	}
	public static int d(int n)
	{
		for(int i=1;i<36;i++)
		{
			if(n-i>0)
			{
				if(n-i+fen(n-i)==n)
					return -1;
			}
		}
		return 1;
	}
	public static int fen(int n)
	{
		int sum=0;
		while(n>0)
		{
			sum+=n%10;
			n/=10;
		}
		return sum;
	}
}
