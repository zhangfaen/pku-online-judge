import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main
{
	public static void main(String []args)throws Exception
	{
		BufferedReader cin=new BufferedReader(new InputStreamReader(System.in));
		String s=cin.readLine();
		if(Character.isUpperCase(s.charAt(0))||s.indexOf("__")>=0)
		{
			System.out.println("Error!");
			return;
		}
		if(isC(s)==false&&isJ(s)==false)
		{
			System.out.println(s);
			return;
		}
		if(isC(s)&&isJ(s))
		{
			System.out.println("Error!");
			return;
		}
		if(isC(s))
		{
			String t="";
			for(int i=0;i<s.length();i++)
				if(s.charAt(i)=='_')
				{
					t+=Character.toUpperCase(s.charAt(i+1));
					i++;
				}
				else
					t+=s.charAt(i);
			System.out.println(t);
			return;
		}
		if(isJ(s))
		{
			String t="";
			for(int i=0;i<s.length();i++)
			{
				char c=s.charAt(i);
				if(Character.isUpperCase(c))
				{
					t+="_"+Character.toLowerCase(c);
				}
				else
					t+=c;
			}
			System.out.println(t);
			return;
		}
		
	}
	public static boolean isC(String s)
	{
		for(int i=0;i<s.length();i++)
			if(s.charAt(i)=='_')
				return true;
		return false;
	}
	public static boolean isJ(String s)
	{
		for(int i=0;i<s.length();i++)
			if(Character.isUpperCase(s.charAt(i)))
				return true;
		return false;
	}
}
