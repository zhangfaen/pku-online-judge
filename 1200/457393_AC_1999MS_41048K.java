import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt();
		int nc=cin.nextInt();
		String s=cin.next();
		int length=s.length()-n+1;
		HashSet<String> hs=new HashSet<String>();
		for(int i=0;i<length;i++)
		{
			String t=s.substring(i,i+n);
			hs.add(t);
		}
		System.out.println(hs.size());
	
	
	}

}