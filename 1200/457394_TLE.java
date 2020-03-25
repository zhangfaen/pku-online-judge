import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt();
		int nc=cin.nextInt();
		String s=cin.next();
		int length=s.length()-n+1;
		Set<String> hs=new TreeSet<String>();
		for(int i=0;i<length;i++)
		{
			String t=s.substring(i,i+n);
			hs.add(t);
		}
		System.out.println(hs.size());
	
	
	}

}