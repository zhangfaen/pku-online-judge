import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main
{
	static String pre;
	static String post;
	public static void main(String[] args) throws IOException
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String ts=cin.readLine();
		int testcase=Integer.parseInt(ts);
		while (testcase-->0)
		{
			String s = cin.readLine();
			s=prefix(s);
			out.println(s);
		}
		out.flush();
		out.close();
	}
	public static String prefix(String s)
	{
		String t="";
		if(s.indexOf("anti")==0)
		{
			t=s.substring(4);
			t="against "+postfix(t);
			return t;
		}
		else if(s.indexOf("post")==0)
		{
			t=s.substring(4);
			t="after "+postfix(t);
			return t;
		}
		else if(s.indexOf("pre")==0)
		{
			t=s.substring(3);
			t="before "+postfix(t);
			return t;
		}
		else if(s.indexOf("re")==0)
		{
			t=s.substring(2);
			t=postfix(t)+" again";
			return t;
		}
		else if(s.indexOf("un")==0)
		{
			t=s.substring(2);
			t="not "+postfix(t);
			return t;
		}
		else
		{
			t=postfix(s);
			return t;
		}
		
	}
	public static String postfix(String s)
	{
		String t="";
		if(isSuffix(s,"er"))
		{
			t=s.substring(0, s.length()-2);
			t="one who "+t+"s";
			return t;
		}
		else if(isSuffix(s,"ing"))
		{
			t=s.substring(0, s.length()-3);
			t="to actively "+t;
			return t;
		}
		else  if(isSuffix(s,"ize"))
		{
			t=s.substring(0, s.length()-3);
			t="change into "+t;
			return t;
		}else if(isSuffix(s,"s"))
		{
			t=s.substring(0, s.length()-1);
			t="multiple instances of "+t;
			return t;
		}else if(isSuffix(s,"tion"))
		{
			t=s.substring(0, s.length()-4);
			t="the process of "+t+"ing";
			return t;
		}else
		{
			return s;
		}
	}
	public static boolean isSuffix(String s,String sf)
	{
		if(s.length()<sf.length())return false;
		for(int i=sf.length()-1,j=s.length()-1;i>=0&&j>=0;i--,j--)
		{
			if(sf.charAt(i)!=s.charAt(j))
				return false;
		}
		return true;
	}
	
}