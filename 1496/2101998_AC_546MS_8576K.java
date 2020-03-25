import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main
{
    
    static Map<String,Integer>msi=new HashMap<String,Integer>();
    static int end;
    static int cnt=1;
    static StringBuilder sb;
    public static void dfs(char pc,int d)
    {
	if(d==end)
	{
	    msi.put(sb.toString(), cnt++);
	    return;
	}
	for(char c=(char)Math.max('a', pc+1);c<='z';c++)
	{
	    sb.append(c);
	    dfs(c,d+1);
	    sb.deleteCharAt(sb.length()-1);
	}
	
    }
    public static void main(String[] args) throws Exception
    {
	BufferedReader cin = new BufferedReader(
		new InputStreamReader(System.in));
	for(int i=1;i<=5;i++)
	{
	    sb=new StringBuilder();
	    end=i;
	    dfs((char)('a'-1),0);
	}
	while(true)
	{
	    String s = cin.readLine();
	    if(s==null)break;
	    Integer re=msi.get(s);
	    if(re==null)
		System.out.println("0");
	    else System.out.println(re);
	}
    }
    

}