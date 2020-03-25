import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main
{
    public static void main(String[] args) throws Exception
    {
	BufferedReader cin = new BufferedReader(
		new InputStreamReader(System.in));
	while (true)
	{
	    String s = cin.readLine();
	    String[] sa = s.split(" ");
	    StringBuilder sb1=new StringBuilder(sa[0]);
	    StringBuilder sb2=new StringBuilder(sa[1]);
	    int i;
	    for(i=0;i<sb1.length();i++)
	    {
		char c=sb1.charAt(i);
		int ni=sb2.indexOf(""+c);
		if(ni>=0)
		{
		    sb2.delete(0, ni+1);
		}else break;
	    }
	    if(i==sb1.length())
	    {
		System.out.println("Yes");
	    }
	    else
	    {
		System.out.println("No");
	    }
	}
    }
   
    

}
