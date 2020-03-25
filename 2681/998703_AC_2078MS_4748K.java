import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args) throws FileNotFoundException
	{
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt();
		cin.nextLine();
		for(int i=1;i<=n;i++)
		{
			StringBuffer s=new StringBuffer(cin.nextLine());
			StringBuffer t=new StringBuffer(cin.nextLine());
			
			int sum=0;
			for(int j=0;j<s.length();j++)
			{
				char c=s.charAt(j);
				int tag=t.indexOf(""+c);
				if(tag>=0)
				{
					t.deleteCharAt(tag);
				}
				else
					sum++;
			}
			sum+=t.length();
			System.out.println("Case #"+i+":  "+sum);
			
		}
		
		
		
	}
	
}
