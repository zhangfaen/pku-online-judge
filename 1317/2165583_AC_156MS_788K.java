import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main
{

    static BufferedReader cin = new BufferedReader(new InputStreamReader(
	    System.in));

    public static void main(String[] args) throws IOException
    {
	while (true)
	{
	    String s = cin.readLine();
	    if (s.equals("0"))
		break;
	    String[] sa = s.split(" ");
	    int key = Integer.parseInt(sa[0]);
	    String msg = sa[1];
	    char[] cmsg = msg.toCharArray();
	    int[] code = new int[msg.length()];
	    for (int i = 0; i < code.length; i++)
		code[i] = get(cmsg[i]);
	    int[] sode = new int[msg.length()];
	    int n = msg.length();
	    for (int i = 0; i < msg.length(); i++)
	    {
		int kimodn = (key * i) % n;
		if (kimodn < 0)
		    kimodn += n;
		for(int j=1;j<28;j++)
		{
		    int t=(j-i+100*28)%28;
		    if(t==code[i])
		    {
			sode[kimodn]=j;
		    }
		}
	    }
	    String re="";
	    for(int d:sode)
		re+=(char)make(d);
	    System.out.println(re);
	}
    }

    public static int get(char c)
    {
	if (c == '_')
	    return 0;
	if (c == '.')
	    return 27;
	return c - 'a' + 1;
    }

    public static int make(int d)
    {
	if (d == 0)
	    return '_';
	if (d == 27)
	    return '.';
	return (char) (d - 1 + 'a');
    }
}
