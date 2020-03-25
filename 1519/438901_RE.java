import java.io.*;
import java.util.*;
public class Main
{

	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		while(true)
		{
			int n=cin.nextInt();
			if(n==0)break;
			while(n>=10)
			{
				String s=Integer.toString(n);
				int t=0;
				for(int i=0;i<s.length();i++)
					t+=s.charAt(i)-'0';
				n=t;
			}
			System.out.println(n);
		}
		
	}
}