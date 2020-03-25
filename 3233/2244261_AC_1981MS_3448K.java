import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main
{

    static BufferedReader cin = new BufferedReader(new InputStreamReader(
	    System.in));
    static PrintWriter out = new PrintWriter(System.out);

    static int n, k, m;
    static int[][] matrix;
    static int[][] result;
    static int[][] temp;

    static int[][] calc(int lk)
    {
	if (lk == 1)
	    return copy(matrix);
	int mid = lk / 2;
	if (lk % 2 == 1)
	    mid++;
	int[][] re1 = calc(lk / 2);
	int[][] fac = powm(mid);
	int[][] re = mul(fac, re1);
	add(re, re1);
	if (lk % 2 == 1)
	    add(re, fac);
	return re;
    }

    static int[][] copy(int[][] a)
    {
	int[][] re = new int[n][n];
	for (int i = 0; i < n; i++)
	    for (int j = 0; j < n; j++)
		re[i][j] = a[i][j];
	return re;
    }

    static void add(int[][] a, int[][] b)
    {
	for (int i = 0; i < n; i++)
	    for (int j = 0; j < n; j++)
	    {
		a[i][j] += b[i][j];
		a[i][j] %= m;
	    }
    }

    static int[][] powm(int p)
    {
	if (p == 1)
	    return matrix;
	int[][] re = powm(p / 2);
	re=mul(re,re);
	if (p % 2 == 1)
	    re = mul(re, matrix);
	return re;
    }

    static int[][] mul(int[][] a, int[][] b)
    {
	int[][] re = new int[n][n];
	for (int i = 0; i < n; i++)
	    for (int j = 0; j < n; j++)
	    {
		long t = 0;
		for (int k = 0; k < n; k++)
		{
		    t += 1L*a[i][k] * b[k][j];
		}
		re[i][j] = (int) (t % m);
	    }
	return re;
    }

    public static void main(String[] args) throws Exception
    {
	String s = cin.readLine();
	String[] sa = s.split(" ");
	n = Integer.parseInt(sa[0]);
	k = Integer.parseInt(sa[1]);
	m = Integer.parseInt(sa[2]);
	matrix = new int[n][n];
	result = new int[n][n];

	for (int i = 0; i < n; i++)
	{
	    s = cin.readLine().trim();
	    sa = s.split(" ");
	    for (int j = 0; j < n; j++)
		matrix[i][j] = Integer.parseInt(sa[j]);
	}
	int[][] re = calc(k);
	for (int i = 0; i < n; i++)
	{
	    for (int j = 0; j < n; j++)
	    {
		out.print(re[i][j] + " ");
	    }
	    out.println();
	}
	out.flush();
	out.close();
    }

}
