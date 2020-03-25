import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		Scanner cin=new Scanner(System.in);
		while(true)
		{
			int n=cin.nextInt();
			if(n==0)break;
			int day=0;
			int sum=0;
			tag:for(int i=1;i<10000;i++)
				for(int j=1;j<=i;j++)
				{
					sum+=i;
					day++;
					if(day==n)
						break tag;
				}
			System.out.println(n+" "+sum);
		}
	}
}
