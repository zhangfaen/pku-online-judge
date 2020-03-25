import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main
{

    static BufferedReader cin = null;
    static PrintWriter out = new PrintWriter(System.out);

    static int n, m;
    static int[][] memo;
    static boolean[][] vst;

    public static void main(String[] args) throws Exception
    {
	cin = new BufferedReader(new InputStreamReader(System.in));
	String s = cin.readLine();
	String[] sa = s.split(" ");
	n = Integer.parseInt(sa[0]);
	m = Integer.parseInt(sa[1]);
	memo = new int[n + 1][m + 1];
	vst = new boolean[n + 1][m + 1];
	int res=dp(n,m);
	System.out.println(res);
    }
    public static int dp(int cn,int cm)
    {
	if(cn==0)
	{
	    if(cm>0)return 0;
	    return 1;
	}
	if(cm==0)return 1;
	if(vst[cn][cm])
	    return memo[cn][cm];
	vst[cn][cm]=true;
	long re=0;
	re+=dp(cn-1,cm);
	if(cm>=cn)
	{
	    re+=dp(cn,cm-cn);
	}
	re%=1000000007;
	memo[cn][cm]=(int)re;
	return (int)re;
    }
}
