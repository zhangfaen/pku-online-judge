import java.io.*;
import java.util.*;
import java.math.*;
public class Main
{
    public static void main(String[] args) throws Exception
    {
	BufferedReader cin = new BufferedReader(
		new InputStreamReader(System.in));
	int ts = Integer.parseInt(cin.readLine());
	while (ts-- > 0)
	{
	    StringTokenizer st = new StringTokenizer(cin.readLine());
	    int L = Integer.parseInt(st.nextToken()) * 100;
	    int m = Integer.parseInt(st.nextToken());
	    int[] left = new int[100000];
	    int[] right = new int[100000];
	    int sl = 0, sr = 0;
	    for (int i = 0; i < m; i++)
	    {
		st = new StringTokenizer(cin.readLine());
		int len = Integer.parseInt(st.nextToken());
		String dir = st.nextToken();
		if (dir.equals("left"))
		    left[sl++] = len;
		else
		    right[sr++] = len;
	    }
	    int side=0;
	    int res=0;
	    int cl=0,cr=0;
	    while(cl<sl||cr<sr)
	    {
		if(side==0)
		{
		    int d=0;
		    while(d+left[cl]<=L&&cl<sl)
		    {
			d+=left[cl++];
		    }
		    res++;
		    side=1;
		}
		else
		{
		    int d=0;
		    while(d+right[cr]<=L&&cr<sr)
		    {
			d+=right[cr++];
		    }
		    res++;
		    side=0;
		}
	    }
	    System.out.println(res);
	}
    }
}
