import java.io.*;
import java.util.*;
import java.math.*;
public class Main
{
	public static void main(String args[]) throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		String beg=cin.next();
		int[]fin=new int[beg.length()];
		for(int i=0;i<beg.length();i++)
		{
			fin[i]=beg.charAt(i)-'0';
		}
		while(cin.hasNext())
		{
			String next=cin.next();
			for(int i=0;i<next.length();i++)
			{
				fin[i]+=next.charAt(i)-'0';
			}
		}
		for(int i=0;i<fin.length;i++)
		{
			System.out.print(fin[i]%10);
		}
		System.out.println();
	
	}
}
