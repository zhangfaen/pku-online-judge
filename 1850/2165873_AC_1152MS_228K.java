import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Main
{

    static BufferedReader cin = new BufferedReader(new InputStreamReader(
	    System.in));

    public static void main(String[] args) throws IOException
    {
	String s = cin.readLine();
	if (s.length() == 0 || s.matches("[a-z]+") == false)
	{
	    System.out.println(0);
	    return;
	}
	for (int i = 0; i < s.length(); i++)
	    for (int j = i + 1; j < s.length(); j++)
		if (s.charAt(i) == s.charAt(j))
		{
		    System.out.println(0);
		    return;
		}
	for(int i=0;i<s.length()-1;i++)
	    if(s.charAt(i)>=s.charAt(i+1))
	    {
		System.out.println(0);
		return;
	    }
	long res = 0;
	for (int i = 1; i < s.length(); i++)
	    res += get(i, 26);
	char pre=(char)('a'-1);
	for (int i = 0; i < s.length(); i++)
	{
	    char end = (char) (s.charAt(i) - 1);
	    if (i == s.length() - 1)
		end++;
	    for (char c = (char)(pre+1); c <= end; c++)
	    {
		res += get(s.length() - i - 1, 'z'-c);
	    }
	    pre=s.charAt(i);	
	}

	System.out.println(res);

    }

    public static long get(int len, int max)
    {
	long re = 1;
	for (int i = 0; i < len; i++)
	    re *= max--;
	while(len>0)
	    re/=len--;
	return re;
    }
}
