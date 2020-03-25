import java.io.*;
import java.util.*;
import java.math.*;
public class Main
{
	public static void main(String [] args)throws Exception 
	{
	
	//	Scanner cin=new Scanner(new File("c:\\fafa.txt"));
		Scanner cin=new Scanner(System.in);
		double []set=new double[1000];
		set[1]=0.5;
		for(int i=2;i<1000;i++)
		{
			set[i]=set[i-1]+1.0/(i+1);
		}
		double ask;
		while((ask=cin.nextDouble())!=0.00)
		{
			for(int i=1;i<1000;i++)
			{
				if(set[i]>=ask)
				{
					System.out.printf("%d card(s)\n",i);
					break;
				}
			}
		}
	
		
	}
}