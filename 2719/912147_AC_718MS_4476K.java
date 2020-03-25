import java.util.*;
public class Main
{
	public static void main(String [] args)
	{
		Scanner cin=new Scanner(System.in);
		while(true)
		{
			String s=cin.next();
			if(s.equals("0"))break;
			String t="";
			for(int i=0;i<s.length();i++)
			{
				if(s.charAt(i)>='5')
					t+=(char)(s.charAt(i)-1);
				else
					t+=s.charAt(i);
			}
			long r=Long.parseLong(t,9);
			System.out.println(s+": "+r);
		}		
	}
}