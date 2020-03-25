import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
	    List list=new ArrayList(10000);
	    for(int i=0;i<(1<<n);i++)
	    {
		if(Integer.bitCount(i)==6)
		{
		    int [] q=new int[6];
		    int tag=0;
		    for(int j=0;j<n;j++)
		    {
			if(((1<<j)&i)!=0)
			{
			    q[tag++]=p[j];
			}
		    }
		    list.add(q);
		   
		}
	    }
	    Collections.sort(list,new Comparator() {

		public int compare(Object o1, Object o2)
		{
		    int [] a1=(int [])o1;
		    int [] a2=(int [])o2;
		    for(int i=0;i<6;i++)
		    {
			if(a1[i]!=a2[i])
			{
			    return a1[i]-a2[i];
			}
		    }
		    return 0;
		}});
	    for(int i=0;i<list.size();i++)
	    {
		int [] a=(int [])list.get(i);
		for(int j=0;j<6;j++)
		    out.print(a[j]+" ");
		out.println();
	    }
	    out.println();
	}
	out.close();
    }

}
