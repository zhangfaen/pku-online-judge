import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Main
{

    // static BufferedReader cin;
    static class Fraction implements Comparable<Fraction>
    {
	BigInteger a, b;

	public Fraction(BigInteger a, BigInteger b)
	{
	    this.a = a;
	    this.b = b;
	    if (this.b.signum() < 0)
	    {
		this.a = this.a.negate();
		this.b = this.b.negate();
	    }
	    BigInteger c = this.a.gcd(this.b);
	    this.a = this.a.divide(c);
	    this.b = this.b.divide(c);
	}

	public Fraction add(Fraction x)
	{
	    return new Fraction(a.multiply(x.b).add(b.multiply(x.a)), b
		    .multiply(x.b));
	}

	public Fraction multiply(Fraction x)
	{
	    return new Fraction(a.multiply(x.a), b.multiply(x.b));
	}

	public Fraction multiply(BigInteger x)
	{
	    return new Fraction(a.multiply(x), b);
	}

	public Fraction divide(BigInteger x)
	{
	    return new Fraction(a, b.multiply(x));
	}

	public Fraction divide(Fraction x)
	{
	    Fraction f = new Fraction(x.b, x.a);
	    return multiply(f);
	}

	public Fraction negate()
	{
	    return new Fraction(a.negate(), b);
	}

	public Fraction subtract(Fraction f)
	{
	    return this.add(f.negate());
	}

	public String toString()
	{
	    return a + "/" + b;
	}
	public int compareTo(Fraction o)
	{
	    return a.multiply(o.b).compareTo(b.multiply(o.a));
	}
    }

    public static void main(String[] args) throws IOException
    {
	// cin = new BufferedReader(new InputStreamReader(System.in));
	Scanner cin = new Scanner(System.in);
	int ts = 0;
	while (true)
	{
	    ts++;
	    int n = cin.nextInt();
	    if (n == 0)
		break;
	    BigInteger one = new BigInteger("1");
	    Fraction t = new Fraction(new BigInteger(cin.nextInt() + ""), one);
	    Fraction[] size = new Fraction[n];
	    Fraction[] is = new Fraction[n];
	    Fraction[] ms = new Fraction[n];
	    Fraction[] ft = new Fraction[n];
	    Fraction zero = new Fraction(new BigInteger("0"), one);
	    for (int i = 0; i < n; i++)
	    {
		size[i] = new Fraction(new BigInteger(cin.nextInt() + ""), one);
		is[i] = new Fraction(new BigInteger(cin.nextInt() + ""), one);
		ms[i] = new Fraction(new BigInteger(cin.nextInt() + ""), one);
		ft[i]=zero;
	    }
	    boolean[] fst = new boolean[n];
	    int left = n;
	    while (left-- > 0)
	    {
		int fi = -1;
		Fraction nt = new Fraction(new BigInteger(
			"100000000000000000000"), one);
		for (int i = 0; i < n; i++)
		{
		    if (fst[i])
			continue;
		    Fraction dt = size[i].divide(is[i]);
		    if (dt.compareTo(nt) < 0)
		    {
			nt = dt;
			fi = i;
		    }
		}
		for (int i = 0; i < n; i++)
		{
		    if (fst[i])
			continue;
		    ft[i] = ft[i].add(nt);
		    size[i] = size[i].subtract(nt.multiply(is[i]));
		}
		fst[fi] = true;
		
		Fraction lb = zero;
		for (int i = 0; i < n; i++)
		    if (fst[i] == false)
			lb = lb.add(is[i]);
		lb = t.subtract(lb);
		while (lb.compareTo(zero) > 0)
		{
		    int cnt = 0;
		    for (int i = 0; i < n; i++)
		    {
			if (fst[i])
			    continue;
			if (is[i].compareTo(ms[i]) < 0)
			    cnt++;
		    }
		    if (cnt == 0)
			break;
		    Fraction avg = lb.divide(new BigInteger("" + cnt));
		    lb = zero;
		    for (int i = 0; i < n; i++)
		    {
			if (fst[i])
			    continue;
			if (is[i].compareTo(ms[i]) < 0)
			{
			    if (is[i].add(avg).compareTo(ms[i]) >= 0)
			    {
				is[i] = ms[i];
				lb = lb.add(is[i].add(avg).subtract(ms[i]));
			    }
			    else
			    {
				is[i] = is[i].add(avg);
			    }
			}
		    }
		}
	    }
	    System.out.println("Case " + ts + ":");
	    for (int i = 0; i < n; i++)
	    {
		System.out.printf("NO%d:%.3fs\n", i + 1, ft[i].a.doubleValue()/ft[i].b.doubleValue());
	    }
	}
    }
}
