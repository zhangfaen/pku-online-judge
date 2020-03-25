import java.util.*;
import java.io.*;
public class Main
{
	private static long [] p;
	public static void main(String [] args)throws Exception
	{
	
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		while(true)
		{
			String s=cin.next();
			if(s.equals("0"))
				break;
			int length=s.length();
			p=new long[length];
			p[0]=1;
			if(s.charAt(1)=='0')
				p[1]=1;
			else
			{
				if((s.charAt(0)-'0')*10+s.charAt(1)-'0'<=26)
					p[1]=2;
				else
					p[1]=1;
				
			}
			for(int i=2;i<length;i++)
			{
				if(s.charAt(i)=='0')
					p[i]=p[i-2];
				else
				{
					if(s.charAt(i-1)!='0'&&(s.charAt(i-1)-'0')*10+s.charAt(i)-'0'<=26)
						p[i]=p[i-2]+p[i-1];
					if(s.charAt(i-1)!='0'&&(s.charAt(i-1)-'0')*10+s.charAt(i)-'0'>26)
						p[i]=p[i-1];
					if(s.charAt(i-1)=='0')
						p[i]=p[i-1];
				}
			}
			System.out.println(p[length-1]);
		}
	}

	
	
}


