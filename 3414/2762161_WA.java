import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
public class Main
{
    static int c;
    static int ra = -1, rb = -1;
    public static void main(String[] args) throws Exception
    {
	BufferedReader cin = new BufferedReader(
		new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	StringTokenizer st = new StringTokenizer(cin.readLine());
	int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st
		.nextToken());
	c = Integer.parseInt(st.nextToken());
	int[][] memo = new int[a + 1][b + 1];
	for (int i = 0; i < memo.length; i++)
	    Arrays.fill(memo[i], -1);
	int[][] back = new int[a + 1][b + 1];
	memo[0][0] = 0;
	List<Integer> q = new LinkedList<Integer>();
	q.add(0);
	q.add(0);
	while (!q.isEmpty())
	{
	    int ca = q.remove(0);
	    int cb = q.remove(0);
	    int na = 0, nb = 0;
	    int cs = memo[ca][cb];
	    // type 1 fill a, 2 fill b, 3 empty a, 4 empty b, 5 pour 1 2, 6 pour
	    // 2 1
	    if (ca < a)
	    {
		na = a;
		nb = cb;
		if(process(1, memo, back, q, na, nb, cs, ca, cb))break;;
	    }
	    if (cb < b)
	    {
		na = ca;
		nb = b;
		if(process(2, memo, back, q, na, nb, cs, ca, cb))break;
	    }
	    if (ca > 0)
	    {
		na = 0;
		nb = cb;
		if(process(3, memo, back, q, na, nb, cs, ca, cb))break;
	    }
	    if (cb > 0)
	    {
		na = ca;
		nb = 0;
		if(process(4, memo, back, q, na, nb, cs, ca, cb))break;
	    }
	    if (ca > 0 && cb < b)
	    {
		if (ca + cb <= b)
		{
		    na = 0;
		    nb = ca + cb;
		}
		else
		{
		    na = ca + cb - b;
		    nb = b;
		}
		if(process(5, memo, back, q, na, nb, cs, ca, cb))break;
	    }
	    if (ca < a && cb > 0)
	    {
		if (ca + cb <= a)
		{
		    na = ca + cb;
		    nb = 0;
		}
		else
		{
		    na = a;
		    nb = ca + cb - a;
		}
		if(process(6, memo, back, q, na, nb, cs, ca, cb))break;
	    }
	}
	if (ra == -1 && rb == -1)
	    out.println("impossible");
	else
	{
	    List<String> ls = new ArrayList<String>();
	    int ba = ra, bb = rb;
	    while (!(ba == 0 && bb == 0))
	    {
		int next = back[ba][bb];
		int type = next % 1000;
		ba = next / 1000 % 1000;
		bb = next / 1000000;
		if (type == 1)
		    ls.add("FILL(1)");
		if (type == 2)
		    ls.add("FILL(2)");
		if (type == 3)
		    ls.add("EMPTY(1)");
		if (type == 4)
		    ls.add("EMPTY(2)");
		if (type == 5)
		    ls.add("POUR(1,2)");
		if (type == 6)
		    ls.add("POUR(2,1)");
	    }
	    for (int i = ls.size() - 1; i >= 0; i--)
		out.println(ls.get(i));
	}
	out.flush();
    }
    public static boolean process(int type, int[][] memo, int[][] back,
	    List<Integer> q, int na, int nb, int cs, int ca, int cb)
    {
	if (memo[na][nb] != -1)
	    return false;
	memo[na][nb] = cs + 1;
	back[na][nb] = type + 1000 * ca + 1000000 * cb;
	if (na == c || nb == c)
	{
	    ra = na;
	    rb = nb;
	    return true;
	}
	q.add(na);
	q.add(nb);
	return false;
    }
}
