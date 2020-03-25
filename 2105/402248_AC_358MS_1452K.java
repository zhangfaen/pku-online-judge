import java.util.*;
import java.io.*;
import java.math.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt();
		while(n--!=0)
		{
			String s=cin.next();
			String t="";
			for(int i=0;i<32;i++)
			{
				t+=s.charAt(i);
				if((i+1)%8==0)
				{
					int num=0;
					for(int j=7;j>=0;j--)
					{
						if(t.charAt(j)=='1')
							num+=Math.pow(2,7-j);
							
					}
					t="";
					if(i<24)
						System.out.print(num+".");
					else
						System.out.print(num);
				}
			}
			System.out.println();
		}
		
	}
}