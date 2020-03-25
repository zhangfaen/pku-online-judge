import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String args[]) throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		String key=cin.next();
		HashMap<Character,Character>keyMap=new HashMap<Character,Character>();
		for(int i='a';i<='z';i++)
		{
			keyMap.put((char)i,key.charAt(i-'a'));
		}
		cin.nextLine();
		String text=cin.nextLine();
		for(int i=0;i<text.length();i++)
		{
			if(text.charAt(i)<='z'&&text.charAt(i)>='a')
			{
				char c=keyMap.get(text.charAt(i));
				System.out.print(c);
			}
			else
				if(text.charAt(i)>='A'&&text.charAt(i)<='Z')
				{
					char c=keyMap.get((char)(text.charAt(i)+32));
					System.out.print((char)(c-32));
				}
				else
					System.out.print(text.charAt(i));
			
		}
		System.out.println();
	}
}
