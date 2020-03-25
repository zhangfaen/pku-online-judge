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

    public static void main(String[] args) throws Exception
    {
	cin = new BufferedReader(new InputStreamReader(System.in));
	while (true)
	{
	    String s = cin.readLine().trim();
	    int n = Integer.parseInt(s);
	    if (n == 0)
		break;
	    double[] xs = new double[n];
	    double[] ys = new double[n];
	    double[] zs = new double[n];
	    for (int i = 0; i < n; i++)
	    {
		s = cin.readLine().trim();
		String[] sa = s.split(" ");
		xs[i] = Double.parseDouble(sa[0]);
		ys[i] = Double.parseDouble(sa[1]);
		zs[i] = Double.parseDouble(sa[2]);
	    }
	    s = cin.readLine().trim();
	    int m = Integer.parseInt(s);
	    double[] txs = new double[m];
	    double[] tys = new double[m];
	    double[] tzs = new double[m];
	    double[] angle = new double[m];
	    for (int i = 0; i < m; i++)
	    {
		s = cin.readLine().trim();
		String[] sa = s.split(" ");
		txs[i] = Double.parseDouble(sa[0]);
		tys[i] = Double.parseDouble(sa[1]);
		tzs[i] = Double.parseDouble(sa[2]);
		angle[i] = Double.parseDouble(sa[3]);
	    }
	    boolean[] vst = new boolean[n];
	    for (int i = 0; i < n; i++)
	    {
		for (int j = 0; j < m; j++)
		{
		    double cos = dot(xs[i], ys[i], zs[i], txs[j], tys[j],
			    tzs[j])
			    / len(xs[i], ys[i], zs[i])
			    / len(txs[j], tys[j], tzs[j]);
		    double ta=Math.acos(cos);
		    if(ta<=angle[j])
		    {
			vst[i]=true;
			break;
		    }
		}
	    }
	    int res=0;
	    for(boolean b:vst)
		if(b)res++;
	    out.println(res);	    
	    out.flush();
	}
    }

    public static double dot(double x1, double y1, double z1, double x2,
	    double y2, double z2)
    {
	return x1 * x2 + y1 * y2 + z1 * z2;
    }

    public static double len(double x1, double y1, double z1)
    {
	return Math.sqrt(x1 * x1 + y1 * y1 + z1 * z1);
    }
}
