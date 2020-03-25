import java.util.*;
import java.io.*;
public class Main

{
	public static void main(String [] args)
	{
		Scanner cin=new Scanner(System.in);
		
		while(cin.hasNextLong())
		{
			long t=cin.nextLong();
			long left=1,right=9;
			int win=0;
			boolean flag=true;
			while(true)
			{
				if(t>=left&&t<=right)
					break;
				if(flag)
				{
					left=right+1;
					right*=2;
					flag=false;
				}
				else
				{
					left=right+1;
					right*=9;
					flag=true;
				}
				win=(win+1)%2;
			}
			if(win==0)
				System.out.println("Stan wins.");
			else
				System.out.println("Ollie wins.");
		}
		
	}
}