import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Main
{
    

    public static void main(String[] args) throws Exception
    {
	BufferedReader cin = new BufferedReader(
		new InputStreamReader(System.in));
	String s = cin.readLine();
	int testcase=Integer.parseInt(s);
	for(int i=1;i<=testcase;i++)
	{
	    s=cin.readLine();
	    String [] sa=s.split(" ");
	    int t=Integer.parseInt(sa[0])*Integer.parseInt(sa[1]);
	    System.out.println("Scenario #"+i+":");
	    if(t%2==0)
	    {
		System.out.println(t+".00");
		
	    }
	    else
	    {
		System.out.println(t+".41");
	    }
	    System.out.println();
	    
	}

    }

}