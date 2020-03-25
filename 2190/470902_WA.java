import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		String s=cin.next();
		int index=-1;
		int sum=0;
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)=='?')
				index=i;
			else
			{
				int t;
				if(s.charAt(i)=='X')
					t=10;
				else t=s.charAt(i)-'0';
				sum+=(10-i)*(t);
			}
		}
		int d=10-index;
		for(int i=0;i<=9;i++)	
		{
			if((sum+i*d)%11==0)
			{
				System.out.println(i);
				return;
			}
		}
		System.out.println('X');	
	}
	

	
}
