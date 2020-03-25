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
	String s = cin.readLine();
	int N = Integer.parseInt(s);
	map = new ArrayList<List<Integer>>(N);
	for(int i=0;i<N;i++)
	{
	    s=cin.readLine();
	    String []sa=s.split(" ");
	    List<Integer> li=new ArrayList<Integer>(100);
	    for(int j=2;j<sa.length;j++)
		li.add(Integer.parseInt(sa[j]));
	    map.add(li);
	}
	int [] vst=new int[N];
	List<Integer> q=new LinkedList<Integer>();
	s=cin.readLine();
	String [] sa=s.split(" ");
	int from=Integer.parseInt(sa[0]);
	int to=Integer.parseInt(sa[1]);
	vst[from]=1;
	q.add(from);
	while(!q.isEmpty())
	{
	    int cur=q.remove(0);
	    List<Integer> li=map.get(cur);
	    for(int i=0;i<li.size();i++)
	    {
		int next=li.get(i);
		if(next==to)
		{
		    System.out.println(from+" "+to+" "+(vst[cur]-1));
		    return;
		}
		if(vst[next]==0)
		{
		    vst[next]=vst[cur]+1;
		    q.add(next);
		}
	    }
	}
    }

}
