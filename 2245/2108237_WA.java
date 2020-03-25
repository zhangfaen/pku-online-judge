import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main
{

    static BufferedReader cin;
    static List<List<Integer>> map;

    public static void main(String[] args) throws IOException
    {
	cin = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);

	while (true)
	{
	    String s = cin.readLine();
	    String [] sa=s.split(" ");
	    int n=Integer.parseInt(sa[0]);
	    if(n==0)break;
	    int [] p=new int[n];
	    for(int i=0;i<n;i++)
		p[i]=Integer.parseInt(sa[i+1]);
	    for(int i=0;i<(1<<n);i++)
	    {
		if(Integer.bitCount(i)==6)
		{
		    for(int j=0;j<n;j++)
		    {
			if(((1<<j)&i)!=0)
			{
			    out.print(p[j]+" ");
			}
		    }
		    out.println();
		}
	    }
	    out.println();
	}
	out.close();
    }

}
