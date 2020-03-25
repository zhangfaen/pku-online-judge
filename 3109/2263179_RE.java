import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main
{

    static BufferedReader cin = null;
    static PrintWriter out = new PrintWriter(System.out);
    static class Pair
    {
	int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

	public String toString()
	{
	    String re = "min:" + min + "max:" + max;
	    return re;
	}
    }
    static class Seg implements Comparable<Seg>
    {
	// h right x :1 v x :2 h left x: 3
	int type;
	int x, yu, yd;

	public Seg(int type, int x, int yu, int yd)
	{
	    this.type = type;
	    this.x = x;
	    this.yu = yu;
	    this.yd = yd;
	}

	public String toString()
	{
	    String re = "";
	    re += "type:" + type + " x:" + x + " yu:" + yu + " yd:" + yd;
	    return re;
	}

	public int compareTo(Seg o)
	{
	    if (this.x != o.x)
		return this.x - o.x;
	    if (this.type == 2 || o.type == 2)
		return this.type - o.type;
	    return o.type - this.type;
	}
    }
    static int n;
    static int[] xs;
    static int[] ys;
    static boolean[] used;
    static Map<Integer, Pair> xmap = new HashMap<Integer, Pair>();
    static Map<Integer, Pair> ymap = new HashMap<Integer, Pair>();
    static int YMAX = 0;
    static Seg[] segs;

    public static void main(String[] args) throws Exception
    {
	cin = new BufferedReader(new InputStreamReader(System.in));
	String s = cin.readLine();
	n = Integer.parseInt(s);
	xs = new int[n];
	ys = new int[n];
	used = new boolean[n];
	Arrays.fill(used, true);
	int xmin = 0;
	int ymin = 0;
	for (int i = 0; i < n; i++)
	{
	    s = cin.readLine();
	    String[] sa = s.split(" ");
	    int x = Integer.parseInt(sa[0]);
	    int y = Integer.parseInt(sa[1]);
	    xs[i] = x;
	    ys[i] = y;
	    xmin = Math.min(xmin, x);
	    ymin = Math.min(ymin, y);
	}
	for (int i = 0; i < n; i++)
	{
	    xs[i] -= xmin;
	    ys[i] -= ymin;
	    YMAX = Math.max(YMAX, ys[i]);
	    Pair xp = xmap.get(xs[i]);
	    if (xp == null)
	    {
		xp = new Pair();
		xmap.put(xs[i], xp);
	    }
	    Pair yp = ymap.get(ys[i]);
	    if (yp == null)
	    {
		yp = new Pair();
		ymap.put(ys[i], yp);
	    }
	    xp.max = Math.max(xp.max, ys[i]);
	    xp.min = Math.min(xp.min, ys[i]);
	    yp.max = Math.max(yp.max, xs[i]);
	    yp.min = Math.min(yp.min, xs[i]);
	}
	for (int i = 0; i < n; i++)
	{
	    Pair xp = xmap.get(xs[i]);
	    Pair yp = ymap.get(ys[i]);
	    if (ys[i] < xp.max && ys[i] > xp.min && xs[i] < yp.max
		    && xs[i] > yp.min)
		used[i] = false;
	}
	segs = new Seg[xmap.size() + 2 * ymap.size()];
	int tag = 0;
	for (int key : xmap.keySet())
	{
	    Pair p = xmap.get(key);
	    Seg seg = new Seg(2, key, p.max, p.min);
	    segs[tag++] = seg;
	}
	for (int key : ymap.keySet())
	{
	    Pair p = ymap.get(key);
	    Seg seg = new Seg(3, p.min, key, key);
	    segs[tag++] = seg;
	    seg = new Seg(1, p.max, key, key);
	    segs[tag++] = seg;
	}
	Arrays.sort(segs);

	root = new Node(0, YMAX);
	long res = 0;
	for (int i = 0; i < segs.length; i++)
	{
	    Seg seg = segs[i];
	    if (seg.type == 1)
	    {
		remove(root, seg.yd);
	    }
	    else if (seg.type == 2)
	    {
		try
		{
		    if (seg.yu > seg.yd)
		    {
			int d1 = getNumOfValueSmallerThanV(root, seg.yu);
			int d2 = getNumOfValueSmallerThanV(root, seg.yd + 1);
			res += d1 - d2;
		    }
		}
		catch (Exception e)
		{
		    System.out.println(0);
		    return;
		}
	    }
	    else
	    {
		insert(root, seg.yd);
	    }
	}
	for (int i = 0; i < n; i++)
	    if (used[i])
		res++;
	System.out.println(res);

    }
    static class Node
    {
	int x, y;
	int size;
	Node left, right;

	public Node(int x, int y)
	{
	    this.x = x;
	    this.y = y;
	}
    }
    static Node root;

    static void insert(Node cn, int v)
    {
	if (cn.x == cn.y)
	{
	    cn.size++;
	    return;
	}
	int mid = cn.x + (cn.y - cn.x) / 2;
	cn.size++;
	if (v <= mid)
	{
	    if (cn.left == null)
		cn.left = new Node(cn.x, mid);
	    insert(cn.left, v);
	}
	else
	{
	    if (cn.right == null)
		cn.right = new Node(mid + 1, cn.y);
	    insert(cn.right, v);
	}
    }

    static int getNumOfValueSmallerThanV(Node cn, int v)
    {
	if (cn.x == cn.y)
	    return 0;
	int mid = cn.x + (cn.y - cn.x) / 2;
	int re = 0;
	if (v > mid)
	{
	    if (cn.left != null)
		re += cn.left.size;
	    if (cn.right != null)
		re += getNumOfValueSmallerThanV(cn.right, v);
	}
	else if (cn.left != null)
	    re = getNumOfValueSmallerThanV(cn.left, v);
	return re;
    }

    static void remove(Node cn, int v)
    {
	if (cn.x == cn.y)
	{
	    cn.size--;
	    return;
	}
	cn.size--;
	int mid = cn.x + (cn.y - cn.x) / 2;
	if (v <= mid)
	    remove(cn.left, v);
	else
	    remove(cn.right, v);
    }
}
