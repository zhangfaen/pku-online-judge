import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main
{

    static int ca, cb, target;
    static boolean [][] vst;
    public static void main(String[] args) throws Exception
    {
	BufferedReader cin = new BufferedReader(
		new InputStreamReader(System.in));
	while (true)
	{
	    String s = cin.readLine();
	    String[] sa = s.split(" ");
	    ca = Integer.parseInt(sa[0]);
	    cb = Integer.parseInt(sa[1]);
	    target = Integer.parseInt(sa[2]);
	    vst=new boolean[ca+1][cb+1];
	    result=new LinkedList<String>();
	    try
	    {
		dfs(0,0);
	    }
	    catch(Exception e)
	    {
		for(String t:result)
		{
		    System.out.println(t);
		}
	    }
	}
    }
    static LinkedList<String>result;
    public static void dfs(int a,int b)throws Exception
    {
	if(a==target||b==target)
	{
	    result.add("success");
	    throw new Exception();
	}
	if(vst[a][b])
	    return;
	vst[a][b]=true;
	if(a<ca)
	{
	    result.add("fill A");
	    dfs(ca,b);
	    result.removeLast();
	}
	if(b<cb)
	{
	    result.add("fill B");
	    dfs(a,cb);
	    result.removeLast();
	}
	if(a>0)
	{
	    result.add("empty A");
	    dfs(0,cb);
	    result.removeLast();
	}
	if(b>0)
	{
	    result.add("empty B");
	    dfs(a,0);
	    result.removeLast();
	}
	if(a<ca&&b>0)
	{
	    result.add("pour B A");
	    if(a+b<=ca)
		dfs(a+b,0);
	    else dfs(ca,a+b-ca);
	    result.removeLast();
	}
	if(b<cb&&a>0)
	{
	    result.add("pour A B");
	    if(a+b<=cb)
		dfs(0,a+b);
	    else dfs(a+b-cb,cb);
	    result.removeLast();
	}
    }
    

}
