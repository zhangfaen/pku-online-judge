import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args) throws Exception
	{
		Scanner cin=new Scanner(System.in);
		Map<String,String> dic=new HashMap<String,String>();
		while(cin.hasNextLine())
		{
			String s=cin.nextLine();
			String [] t=s.split(" ");
			if(t.length>1)
			{
				dic.put(t[1],t[0]);
			}
			else
			if(s.length()>0)
			{
				if(dic.containsKey(s))
					System.out.println(dic.get(s));
				else
					System.out.println("eh");
			}
		}
	}
}
