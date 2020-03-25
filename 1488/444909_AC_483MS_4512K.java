import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		int tag=0;
		while(cin.hasNext())
		{
			String s=cin.nextLine();
			for(int i=0;i<s.length();i++)
			{
				if(s.charAt(i)=='"')
				{
					if(tag==0)
					{
						System.out.print("``");
						tag=(tag+1)%2;
					}
					else
					{
						System.out.print("''");
						tag=(tag+1)%2;
					}
				}
				else
					System.out.print(s.charAt(i));
			}
			System.out.println();
		}
			
	}

	
}
