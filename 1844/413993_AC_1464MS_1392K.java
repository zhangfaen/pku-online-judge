import java.io.*;
import java.util.*;
import java.math.*;
public class Main
{
	public static void main(String args[]) throws Exception
	{
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt();
		int d=0;
		for(int i=1;;i++)
		{
			if(i*(i+1)/2>=n)
			{
				d=i;
				break;
			}
		}
		
		int s=d*(d+1)/2;
		if((s-n)%2==0)
		{
			System.out.println(d);
			return ;
		}
		if((d+1)%2==0)
		{
			System.out.println(d+2);
		}
		else
			System.out.println(d+1);
		
	
		
	}
}
