import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Main
{

    static BufferedReader cin = null;
    static PrintWriter out = new PrintWriter(System.out);
    static int n;
    static int[] p;
    static double b, r, v, e, f;
    static double[][] memo;
    static boolean[][] vst;

    public static void main(String[] args) throws Exception
    {
	cin = new BufferedReader(new InputStreamReader(System.in));
	while (true)
	{
	    String s = cin.readLine();
	    n = Integer.parseInt(s);
	    if (n == 0)
		break;
	    n++;
	    p = new int[n];
	    s = cin.readLine();
	    String[] sa = s.split(" ");
	    for (int i = 0; i < n-1; i++)
		p[i+1] = Integer.parseInt(sa[i]);
	    s = cin.readLine();
	    b = Double.parseDouble(s);
	    s = cin.readLine();
	    sa = s.split(" ");
	    r = Double.parseDouble(sa[0]);
	    v = Double.parseDouble(sa[1]);
	    e = Double.parseDouble(sa[2]);
	    f = Double.parseDouble(sa[3]);
	    memo = new double[n][n];
	    vst = new boolean[n][n];
	    double res=dp(0,0);
	    System.out.println(res);
	}
    }

    public static double dp(int pre, int ci)
    {
	if (ci == n - 1)
	{
	    return 0;
	}
	if (vst[pre][ci])
	    return memo[pre][ci];
	vst[pre][ci] = true;
	double re = 0;
	// 1/(v - e * (x - r)) (if x >= r)
	// 1/(v - f * (r - x)) (if x < r)
	double d1=0,d2=0;
	for (int i = p[ci]; i < p[ci + 1]; i++)
	{
	    int x = i - p[pre];
	    double t = 0;
	    if (x >= r)
		t = 1. / (v - e * (x - r));
	    else
		t = 1. / (v - f * (r - x));
	    d1+=t;
	}
	d1+=dp(pre,ci+1);
	d2=b;
	for (int i = p[ci]; i < p[ci + 1]; i++)
	{
	    int x = i - p[ci];
	    double t = 0;
	    if (x >= r)
		t = 1. / (v - e * (x - r));
	    else
		t = 1. / (v - f * (r - x));
	    d2+=t;
	}
	d2+=dp(ci,ci+1);
	re=Math.min(d1,d2);
	memo[pre][ci]=re;
	return re;
    }
}
