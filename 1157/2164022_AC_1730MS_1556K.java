import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main
{


    static int [][] memo;
    static int f,v;
    static int [][] map;
    public static void main(String[] args) throws IOException
    {
	BufferedReader cin = new BufferedReader(
		new InputStreamReader(System.in));
	String s = cin.readLine().trim();
	String [] sa=s.split(" ");
	f=Integer.parseInt(sa[0]);
	v=Integer.parseInt(sa[1]);
	memo=new int[f][v];
	for(int i=0;i<f;i++)
	    for(int j=0;j<v;j++)
		memo[i][j]=Integer.MIN_VALUE;
	map=new int[f][v];
	for(int i=0;i<f;i++)
	{
	    s=cin.readLine().trim();
	    sa=s.split(" ");
	    for(int j=0;j<v;j++)
		map[i][j]=Integer.parseInt(sa[j]);
	}
	int res=dp(0,0);
	System.out.println(res);
		
    }
    public static int dp(int cf,int cv)
    {
	if(cf==f)
	{
	    return 0;
	}
	if(memo[cf][cv]!=Integer.MIN_VALUE)
	    return memo[cf][cv];
	int re=Integer.MIN_VALUE/2;
	for(int i=cv;i<v&&v-i>=f-cf;i++)
	{
	    int d=map[cf][i]+dp(cf+1,i+1);
	    re=Math.max(d, re);
	}
	memo[cf][cv]=re;
	return re;
    }

}
