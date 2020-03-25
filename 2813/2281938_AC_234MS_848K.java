import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class Main
{

    static BufferedReader cin = null;
    static PrintWriter out = new PrintWriter(System.out);
    static class Token
    {
	String tag;
	boolean isopen;

	public Token(String tag, boolean isopen)
	{
	    this.tag = tag;
	    this.isopen = isopen;
	}
    }

    public static void main(String[] args) throws Exception
    {
	cin = new BufferedReader(new InputStreamReader(System.in));
	while (true)
	{
	    String s = cin.readLine();
	    if (s.trim().equals("-1 -1"))
		break;
	    int sper = s.indexOf(' ', s.indexOf(' ') + 1);
	    String content = s.substring(sper + 1);
	    s = s.substring(0, sper);
	    String[] sa = s.split(" ");
	    int start = Integer.parseInt(sa[0]);
	    int end = Integer.parseInt(sa[1]);
	    String res = content.substring(start, end);
	    List<Token> stack = new LinkedList<Token>();
	    String regexOpen = "<[a-zA-Z0-9\\-]+>";
	    String regexClose = "</[a-zA-Z0-9\\-]+>";
	    int ci = start - 1;
	    while (ci >= 0)
	    {
		char c = content.charAt(ci--);
		if (c == '>')
		{
		    String sb = ">";
		    boolean find = false;
		    while (ci >= 0)
		    {
			char d = content.charAt(ci--);
			if (d == '<')
			{
			    sb = d + sb;
			    find = true;
			    break;
			}
			else if (d == '>')
			{
			    sb = ">";
			}
			else
			    sb = d + sb;
		    }
		    if (find)
		    {

			if (sb.matches(regexClose))
			{
			    stack.add(new Token(sb, false));
			}
			else if (sb.matches(regexOpen))
			{
			    if (stack.size() > 0)
				stack.remove(stack.size() - 1);
			    else
				res = sb.toString() + res;
			}
		    }
		}
	    }
	    stack.clear();
	    ci = end;
	    while (ci < content.length())
	    {
		char c = content.charAt(ci++);
		if (c == '<')
		{
		    String sb = "<";
		    boolean find = false;
		    while (ci < content.length())
		    {
			char d = content.charAt(ci++);
			if (d == '>')
			{
			    sb += d;
			    find = true;
			    break;
			}
			if (d == '<')
			{
			    sb = "<";
			}
			else
			    sb += d;
		    }
		    if (find)
		    {
			if (sb.matches(regexClose))
			{
			    if (stack.size() > 0)
				stack.remove(stack.size() - 1);
			    else
				res += sb.toString();
			}
			else if (sb.matches(regexOpen))
			{
			    stack.add(new Token(sb, false));
			}
		    }

		}
	    }
	    System.out.println(res);
	}
    }
}
