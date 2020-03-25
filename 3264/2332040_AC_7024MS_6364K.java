import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.StringTokenizer;

public class Main
{
    static class RangeMinMaxQuery
    {
	public static class MaxMin
	{
	    public int max_index, min_index;

	    public MaxMin(int a, int b)
	    {
		max_index = a;
		min_index = b;
	    }

	    public String toString()
	    {
		String re = "";
		re += "max_index:" + max_index + " min_index:" + min_index;
		return re;
	    }
	}
	private int[] p;
	private MaxMin[] mm;

	public RangeMinMaxQuery(int[] p)
	{
	    this.p = p;
	    mm = new MaxMin[4 * p.length];
	}

	/**
	 * 更改数组中某个元素的值
	 * 
	 * @param index
	 * @param value
	 */

	public void update(int index, int value)
	{
	    p[index] = value;
	    update(1, 0, p.length, index);
	}

	/**
	 * 
	 * 把牵涉到的点赋值null，以后用的时候会重新计算
	 * 
	 * 
	 * 
	 * @param ci
	 * 
	 * @param left
	 * 
	 * @param right
	 * 
	 * @param index
	 * 
	 */

	private void update(int ci, int left, int right, int index)
	{
	    if (left == right)
		return;
	    mm[ci] = null;
	    int mid = (left + right) / 2;
	    if (index <= mid)
		update(ci * 2, left, mid, index);
	    else
		update(ci * 2 + 1, mid + 1, right, index);
	}

	/**
	 * 
	 * query
	 * 
	 * @param x
	 * @param y
	 * @return
	 * 
	 */
	public MaxMin calc(int x, int y)
	{
	    if (x < 0 || y >= p.length || x > y)
		return null;
	    return calc(1, 0, p.length - 1, x, y);
	}

	/**
	 * 
	 * 一次计算得到区间中最大和最小值的下标
	 * 
	 * @param ci
	 * @param left
	 * @param right
	 * @param x
	 * @param y
	 * @return
	 * 
	 */

	private MaxMin calc(int ci, int left, int right, int x, int y)
	{
	    if (left == x && right == y)
	    {
		if (mm[ci] != null)
		    return mm[ci];
		if (left == right)
		{
		    return mm[ci] = new MaxMin(left, left);
		}
		int mid = (left + right) / 2;
		MaxMin mm1 = calc(2 * ci, left, mid, left, mid);
		MaxMin mm2 = calc(2 * ci + 1, mid + 1, right, mid + 1, right);
		int a, b;
		if (p[mm1.max_index] < p[mm2.max_index])
		    a = mm2.max_index;
		else
		    a = mm1.max_index;
		if (p[mm1.min_index] > p[mm2.min_index])
		    b = mm2.min_index;
		else
		    b = mm1.min_index;
		mm[ci] = new MaxMin(a, b);
		return mm[ci];
	    }
	    int mid = (left + right) / 2;
	    if (x >= mid + 1)
		return calc(ci * 2 + 1, mid + 1, right, x, y);
	    else if (y <= mid)
		return calc(ci * 2, left, mid, x, y);
	    else
	    {
		MaxMin mm1 = calc(2 * ci, left, mid, x, mid);
		MaxMin mm2 = calc(2 * ci + 1, mid + 1, right, mid + 1, y);
		int a, b;
		if (p[mm1.max_index] < p[mm2.max_index])
		    a = mm2.max_index;
		else
		    a = mm1.max_index;
		if (p[mm1.min_index] > p[mm2.min_index])
		    b = mm2.min_index;
		else
		    b = mm1.min_index;
		return new MaxMin(a, b);
	    }
	}
    }
    static BufferedReader cin = null;
    static PrintWriter out = new PrintWriter(System.out);
    static int n;
    static int[] p;

    public static void main(String[] args) throws Exception
    {
	cin = new BufferedReader(new InputStreamReader(System.in));
	String s = cin.readLine();
	StringTokenizer st = new StringTokenizer(s);
	n = Integer.parseInt(st.nextToken());
	int q = Integer.parseInt(st.nextToken());
	p = new int[n];
	for (int i = 0; i < n; i++)
	{
	    s = cin.readLine();
	    p[i] = Integer.parseInt(s);
	}
	RangeMinMaxQuery rmq = new RangeMinMaxQuery(p);
	for (int i = 0; i < q; i++)
	{
	    s = cin.readLine();
	    st = new StringTokenizer(s);
	    int x = Integer.parseInt(st.nextToken());
	    int y = Integer.parseInt(st.nextToken());
	    RangeMinMaxQuery.MaxMin mm = rmq.calc(x - 1, y - 1);
	    out.println(p[mm.max_index] - p[mm.min_index]);
	}
	out.flush();
    }
}
