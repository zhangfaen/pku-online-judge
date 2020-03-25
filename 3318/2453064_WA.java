import java.io.*;
import java.util.*;
import java.math.*;
public class Main
{
    public static void main(String[] args) throws Exception
    {
	BufferedReader cin = new BufferedReader(
		new InputStreamReader(System.in));
	String s = cin.readLine();
	int n = Integer.parseInt(s);
	int[][] a = new int[n][n];
	int[][] b = new int[n][n];
	int[][] c = new int[n][n];
	StringTokenizer st = null;
	for (int i = 0; i < n; i++)
	{
	    st = new StringTokenizer(cin.readLine());
	    for (int j = 0; j < n; j++)
		a[i][j] = Integer.parseInt(st.nextToken());
	}
	for (int i = 0; i < n; i++)
	{
	    st = new StringTokenizer(cin.readLine());
	    for (int j = 0; j < n; j++)
		b[i][j] = Integer.parseInt(st.nextToken());
	}
	for (int i = 0; i < n; i++)
	{
	    st = new StringTokenizer(cin.readLine());
	    for (int j = 0; j < n; j++)
		c[i][j] = Integer.parseInt(st.nextToken());
	}
	Random rand = new Random();
	int[] vector = new int[n];
	for (int i = 0; i < n; i++)
	    vector[i] = rand.nextInt(2);
	int[] cv = new int[n];
	int[] bv = new int[n];
	int[] abv = new int[n];
	calc(c, vector, cv, n);
	calc(b, vector, bv, n);
	calc(a, bv, abv, n);
	for(int i=0;i<n;i++)
	{
	    if(abv[i]!=cv[i])
	    {
		System.out.println("NO");
		return;
	    }
	}
	System.out.println("YES");
    }
    public static void calc(int[][] p, int[] v, int[] r, int n)
    {
	for (int i = 0; i < n; i++)
	{
	    int d = 0;
	    for (int j = 0; j < n; j++)
	    {
		d += p[i][j] * v[j];
	    }
	    r[i] = d;
	}
    }
}
