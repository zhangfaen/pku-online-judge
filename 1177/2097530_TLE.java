import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main
{
    static class PerimeterOfUnionRectangles
    {
	int[] x0;
	int[] y0;
	int[] x1;
	int[] y1;
	HEndge[] hes;
	VEndge[] ves;

	public PerimeterOfUnionRectangles(int[] x0, int[] y0, int[] x1, int[] y1)
	{
	    this.x0 = x0;
	    this.y0 = y0;
	    this.x1 = x1;
	    this.y1 = y1;
	    init();
	}

	private void init()
	{
	    hes = new HEndge[x0.length * 2];
	    ves = new VEndge[x0.length * 2];
	    int tag = 0;
	    for (int i = 0; i < x0.length; i++)
	    {
		hes[tag] = new HEndge(y1[i], true, i);
		ves[tag] = new VEndge(x0[i], true, i);
		tag++;
		hes[tag] = new HEndge(y0[i], false, i);
		ves[tag] = new VEndge(x1[i], false, i);
		tag++;
	    }
	    Arrays.sort(hes);
	    Arrays.sort(ves);
	}

	public int getH()
	{
	    boolean[] isIn = new boolean[x0.length];
	    isIn[ves[0].index] = true;
	    int res = 0;
	    for (int i = 1; i < ves.length; i++)
	    {
		int cnt = 0;
		for (int j = 0; j < hes.length; j++)
		{
		    if (isIn[hes[j].index] == false)
			continue;
		    if (hes[j].isUp == false)
		    {
			cnt++;
			if (cnt == 1)
			    res += ves[i].x - ves[i - 1].x;
		    }
		    else
		    {
			cnt--;
			if (cnt == 0)
			    res += ves[i].x - ves[i - 1].x;
		    }
		}
		if (ves[i].isLeft)
		    isIn[ves[i].index] = true;
		else
		    isIn[ves[i].index] = false;
	    }
	    return res;
	}

	public int getV()
	{
	    for (int i = 0; i < x0.length; i++)
	    {
		int a = -y1[i], b = x0[i], c = -y0[i], d = x1[i];
		x0[i] = a;
		y0[i] = b;
		x1[i] = c;
		y1[i] = d;
	    }
	    init();
	    return getH();
	}

	public int get()
	{
	    int re = getH() + getV();
	    return re;
	}
	static class HEndge implements Comparable<HEndge>
	{
	    int y;
	    boolean isUp;
	    int index;

	    public HEndge(int y, boolean isUp, int index)
	    {
		this.y = y;
		this.isUp = isUp;
		this.index = index;
	    }

	    public int compareTo(HEndge o)
	    {
		return y - o.y;
	    }

	    public String toString()
	    {
		String re = "y:" + y + " " + (isUp ? "up" : "down") + " index:"
			+ index;
		return re;
	    }
	}
	static class VEndge implements Comparable<VEndge>
	{
	    int x;
	    boolean isLeft;
	    int index;

	    public VEndge(int x, boolean isLeft, int index)
	    {
		this.x = x;
		this.isLeft = isLeft;
		this.index = index;
	    }

	    public int compareTo(VEndge o)
	    {
		return x - o.x;
	    }

	    public String toString()
	    {
		String re = "x:" + x + " " + (isLeft ? "left" : "right")
			+ " index:" + index;
		return re;
	    }
	}
    }

    public static void main(String[] args) throws Exception
    {
	BufferedReader cin = new BufferedReader(
		new InputStreamReader(System.in));
	String s = cin.readLine();
	int n = Integer.parseInt(s);
	int[] x0 = new int[n];
	int[] y0 = new int[n];
	int[] x1 = new int[n];
	int[] y1 = new int[n];
	for (int i = 0; i < n; i++)
	{
	    s = cin.readLine();
	    String[] sa = s.split(" ");
	    x0[i] = Integer.parseInt(sa[0]);
	    y0[i] = Integer.parseInt(sa[1]);
	    x1[i] = Integer.parseInt(sa[2]);
	    y1[i] = Integer.parseInt(sa[3]);
	}
	PerimeterOfUnionRectangles aur = new PerimeterOfUnionRectangles(x0, y0,
		x1, y1);
	System.out.println(aur.get());

    }

}
