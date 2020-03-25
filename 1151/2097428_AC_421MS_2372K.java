import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main
{
    static class AreaOfUnionRectangles
    {
	double[] x0;
	double[] y0;
	double[] x1;
	double[] y1;
	HEndge[] hes;
	VEndge[] ves;

	public AreaOfUnionRectangles(double[] x0, double[] y0, double[] x1,
		double[] y1)
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

	public double get()
	{
	    boolean[] isIn = new boolean[x0.length];
	    isIn[ves[0].index] = true;
	    double res = 0;
	    for (int i = 1; i < ves.length; i++)
	    {
		double lastV = Double.MIN_VALUE;
		double cnt = 0;
		double cutLen = 0;
		for (int j = 0; j < hes.length; j++)
		{
		    if (isIn[hes[j].index] == false)
			continue;
		    if (hes[j].isUp == false)
		    {
			cnt++;
			if (cnt != 1)
			{
			    cutLen += hes[j].y - lastV;
			    lastV = hes[j].y;
			}
			else
			{
			    lastV = hes[j].y;
			}
		    }
		    else
		    {
			cnt--;
			cutLen += hes[j].y - lastV;
			lastV = hes[j].y;
		    }
		}
		res += (ves[i].x - ves[i - 1].x) * cutLen;
		if (ves[i].isLeft)
		    isIn[ves[i].index] = true;
		else
		    isIn[ves[i].index] = false;
	    }
	    return res;
	}
	static class HEndge implements Comparable<HEndge>
	{
	    double y;
	    boolean isUp;
	    int index;

	    public HEndge(double y, boolean isUp, int index)
	    {
		this.y = y;
		this.isUp = isUp;
		this.index = index;
	    }

	    public int compareTo(HEndge o)
	    {
		if (y < o.y)
		    return -1;
		return 1;

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
	    double x;
	    boolean isLeft;
	    int index;

	    public VEndge(double x, boolean isLeft, int index)
	    {
		this.x = x;
		this.isLeft = isLeft;
		this.index = index;
	    }

	    public int compareTo(VEndge o)
	    {
		if (x < o.x)
		    return -1;
		return 1;
	    }

	    public String toString()
	    {
		String re = "x:" + x + " " + (isLeft ? "left" : "right")
			+ " index:" + index;
		return re;
	    }
	}
	static class Rectangele
	{
	    double x0, y0, x1, y1;

	    public Rectangele(double x0, double y0, double x1, double y1)
	    {
		this.x0 = x0;
		this.y0 = y0;
		this.x1 = x1;
		this.y1 = y1;
	    }

	}
    }

    public static void main(String[] args) throws Exception
    {
	BufferedReader cin = new BufferedReader(
		new InputStreamReader(System.in));
	int testcase=0;
	while (true)
	{
	    testcase++;
	    String s = cin.readLine();
	    int n = Integer.parseInt(s);
	    if (n == 0)
		break;
	    double [] x0=new double[n];
	    double [] y0=new double[n];
	    double [] x1=new double[n];
	    double [] y1=new double[n];
	    for (int i = 0; i < n; i++)
	    {
		s=cin.readLine();
		String [] sa=s.split(" ");
		x0[i]=Double.parseDouble(sa[0]);
		y0[i]=Double.parseDouble(sa[1]);
		x1[i]=Double.parseDouble(sa[2]);
		y1[i]=Double.parseDouble(sa[3]);
	    }
	    AreaOfUnionRectangles aur=new AreaOfUnionRectangles(x0,y0,x1,y1);
	    System.out.println("Test case #"+testcase);
	    System.out.printf("Total explored area: %.2f\n\n",aur.get());
	}
    }

}
