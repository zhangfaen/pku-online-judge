import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		while(true)
		{
			String start=cin.nextLine();
			if(start.equals("ENDOFINPUT"))
				break;
			String text=cin.nextLine();
			String end=cin.nextLine();
			String t="";
			for(int i=0;i<text.length();i++)
			{
				if(text.charAt(i)>='A'&&text.charAt(i)<='Z')
				{
					if(text.charAt(i)-5<65)
						t+=(char)(text.charAt(i)-5+26);
					else
						t+=(char)(text.charAt(i)-5);
				}
				else
					t+=text.charAt(i);
			}
			System.out.println(t);
		}
	}
}