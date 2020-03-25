import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main
{

    static BufferedReader cin = new BufferedReader(new InputStreamReader(
	    System.in));

    public static void main(String[] args) throws IOException
    {
	String s=cin.readLine();
	int n=Integer.parseInt(s);
	for(int i=0;i<n;i++)
	{
	    s=cin.readLine();
	    String t=cin.readLine();
	    for(int j=s.length()-1;j>=0;j--)
	    {
		char c=s.charAt(j);
		if(c=='J')
		    t=J(t);
		if(c=='C')
		    t=C(t);
		if(c=='E')
		    t=E(t);
		if(c=='A')
		    t=A(t);
		if(c=='P')
		    t=P(t);
		if(c=='M')
		    t=M(t);
	    }
	    System.out.println(t);
	}
    }
    public static String J(String s)
    {
	String re="";
	re+=s.charAt(s.length()-1);
	for(int i=0;i<s.length()-1;i++)
	    re+=s.charAt(i);
	return re;
    }
    public static String C(String s)
    {
	String re="";
	for(int i=1;i<s.length();i++)
	    re+=s.charAt(i);
	re+=s.charAt(0);
	return re;
    }
    public static String E(String s)
    {
	if(s.length()%2==0)
	{
	    String re="";
	    re+=s.substring(s.length()/2)+s.substring(0,s.length()/2);
	    return re;
	}
	else
	{
	    String re="";
	    re+=s.substring(s.length()/2+1)+s.charAt(s.length()/2)+s.substring(0,s.length()/2);
	    return re;
	}
    }
    public static String A(String s)
    {
	StringBuilder sb=new StringBuilder(s);
	sb.reverse();
	return sb.toString();
    }
    public static String P(String s)
    {
	String re="";	
	for(int i=0;i<s.length();i++)
	{
	    char c=s.charAt(i);
	    if(Character.isDigit(c))
	    {
		if(c=='0')
		    re+='9';
		else re+=(char)(c-1);
	    }
	    else
	    {
		re+=c;
	    }
	}
	return re;
    }
    public static String M(String s)
    {
	String re="";	
	for(int i=0;i<s.length();i++)
	{
	    char c=s.charAt(i);
	    if(Character.isDigit(c))
	    {
		if(c=='9')
		    re+='0';
		else re+=(char)(c+1);
	    }
	    else
	    {
		re+=c;
	    }
	}
	return re;
    }
}
