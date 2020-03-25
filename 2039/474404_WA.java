import java.util.*;
import java.io.*;
public class Main
{
	private static Scanner cin;
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		cin=new Scanner(System.in);
		
		while(true)
		{
			int n=cin.nextInt();
			if(n==0)break;
			String [] sa=new String[n];
			for(int i=0;i<n;i++)
				sa[i]="";
			String s=cin.next();
			int direc=0;
			for(int i=0;i<s.length();i++)
			{
				if(direc==0)
					sa[i%n]+=s.charAt(i);
				else
					sa[n-i%n-1]+=s.charAt(i);
				direc=(direc+1)%2;
			}
			for(int i=0;i<n;i++)
				System.out.print(sa[i]);
			System.out.println();
		}
	}
	
}

