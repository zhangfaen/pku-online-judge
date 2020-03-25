import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main
{
    
   
    public static void main(String[] args) throws Exception
    {
	BufferedReader cin = new BufferedReader(
		new InputStreamReader(System.in));
	while(true)
	{
	    String s=cin.readLine();
	    int n=Integer.parseInt(s);
	    if(n==0)break;
	    String [] map=new String[n];
	    for(int i=0;i<n;i++)
		map[i]=cin.readLine();
	    int max=0;
	    for(String t:map)
	    {
		int cnt=0;
		for(int j=0;j<t.length();j++)
		    if(t.charAt(j)!=' ')
			cnt++;
		max=Math.max(max, cnt);
	    }
	    int re=0;
	    for(String t:map)
	    {
		int cnt=0;
		for(int j=0;j<t.length();j++)
		    if(t.charAt(j)!=' ')
			cnt++;
		re+=max-cnt;
	    }
	    System.out.println(re);
	}
    }
    

}