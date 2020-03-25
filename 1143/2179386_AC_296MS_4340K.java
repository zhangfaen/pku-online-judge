import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main
{

    static BufferedReader cin = new BufferedReader(new InputStreamReader(
	    System.in));
    static int n;
    static int[] v;
    static boolean[] memo;
    static boolean[] vst;
    static int maxv;
    public static void main(String[] args) throws IOException
    {
	int ts = 0;
	while (true)
	{
	    ts++;
	    String s = cin.readLine();
	    StringTokenizer st = new StringTokenizer(s);
	    n = Integer.parseInt(st.nextToken());
	    if (n == 0)
		break;
	    Set<Integer> si = new HashSet<Integer>();
	    for (int i = 0; i < n; i++)
		si.add(Integer.parseInt(st.nextToken()));
	    n = si.size();
	    v = new int[n];
	    int tag = 0;
	    for (int d : si)
	    {
		v[tag++] = d;
		maxv = Math.max(maxv, d);
	    }
	    Arrays.sort(v);
	    n=maxv-1;
	    memo = new boolean[1 << n];
	    vst = new boolean[1 << n];
	    int state = 0;
	    for (int d : v)
		state |= (1 << (d - 2));
	    tag = 0;
	    int[] out = new int[22];
	    for (int d : v)
	    {
		int ns=makeNS(state,d-2);
		boolean re = dp(ns);
		if (re==false)
		    out[tag++] = d;
	    }
	    System.out.println("Test Case #" + ts);
	    if (tag > 0)
	    {
		System.out.print("The winning moves are:");
		for(int i=0;i<tag;i++)
		    System.out.print(" "+out[i]);
		System.out.println();
	    }
	    else
		System.out.println("There's no winning move.");
	    System.out.println();
	}
    }

    public static boolean dp(int state)
    {
	if (state == 0)
	    return false;
	if (vst[state])
	    return memo[state];
	vst[state] = true;
	boolean re = false;
	for (int i = 0; i < n; i++)
	{
	    if (((1 << i) & state) != 0)
	    {
		int ns=makeNS(state,i);
		if (dp(ns) == false)
		    re = true;
	    }
	}
	memo[state] = re;
	return re;
    }
    public static int makeNS(int state,int i)
    {
	int v=2+i;
	int ns=state;
	for (int j = v; j <= maxv; j += v)
	    ns &= ~(1 << (j - 2));
	for (int j = 2; j <= maxv; j++)
	{  
	    if((ns&(1<<(j-2)))!=0)continue;
	    for (int k = j + 1; k + j <= maxv; k++)
	    {
		if((ns&(1<<(k-2)))!=0)continue;
		int t = k + j;
		ns &= ~(1 << (t - 2));
	    }
	}
	return ns;
    }
}
