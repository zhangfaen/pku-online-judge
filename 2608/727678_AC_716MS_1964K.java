import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args)
	{
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext())
		{
			String s=cin.next();
			String r="#";
			for(int i=0;i<s.length();i++)
			{
				char c=s.charAt(i);
				if(c=='B'||c=='F'||c=='P'||c=='V')
				{
					if(r.charAt(r.length()-1)!='1')
						r+='1';
				}
				else
				if(c=='C'||c=='G'||c=='J'||c=='K'||c=='Q'||c=='S'||c=='X'||c=='Z')
				{
					if(r.charAt(r.length()-1)!='2')
						r+='2';
				}
				else
				if(c=='D'||c=='T')
				{
					if(r.charAt(r.length()-1)!='3')
						r+='3';
				}
				else
				if(c=='L')
				{
					if(r.charAt(r.length()-1)!='4')
						r+='4';
				}
				else
				if(c=='M'||c=='N')
				{
					if(r.charAt(r.length()-1)!='5')
						r+='5';
				}
				else
				if(c=='R')
				{
					if(r.charAt(r.length()-1)!='6')
						r+='6';
				}
				else
				{
					r+='#';
				}
			}
			System.out.println(r.replaceAll("#",""));
		}
	}
}