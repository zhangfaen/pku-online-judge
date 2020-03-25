import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main
{

    static BufferedReader cin;
    static int[] primes = getPrimes2(1200);
    static int[][][] memo;

    public static void main(String[] args) throws IOException
    {
	cin = new BufferedReader(new InputStreamReader(System.in));
	while (true)
	{
	    String s = cin.readLine();
	    String[] sa = s.split(" ");
	    int n = Integer.parseInt(sa[0]);
	    int k = Integer.parseInt(sa[1]);

	    if (n == 0)
		break;
	    memo = new int[n + 1][primes.length][k + 1];
	    for (int i = 0; i < n + 1; i++)
		for (int j = 0; j < primes.length; j++)
		    for (int x = 0; x < k + 1; x++)
			memo[i][j][x] = -1;
	    int res = dp(n, 0, k);
	    System.out.println(res);
	}
    }

    public static int dp(int left, int ci, int k)
    {
	if (left == 0 && k == 0)
	    return 1;
	if (left > 0 && k == 0 || left == 0 && k > 0)
	    return 0;
	if (left < primes[ci])
	    return 0;
	if (memo[left][ci][k] != -1)
	    return memo[left][ci][k];
	int re = 0;
	re += dp(left - primes[ci], ci + 1, k - 1);
	re += dp(left, ci + 1, k);
	memo[left][ci][k] = re;
	return re;
    }

    public static int[] getPrimes2(int n)
    {
	boolean[] prime = new boolean[n + 1];
	Arrays.fill(prime, true);
	prime[0] = false;
	prime[1] = false;
	int m = (int) Math.sqrt(n);
	int size = 0;
	for (int i = 2; i <= m; i++)
	{
	    if (prime[i])
	    {
		for (int k = i * i; k <= n; k += i)
		    prime[k] = false;
	    }
	}
	for (boolean bl : prime)
	    if (bl)
		size++;
	int[] re = new int[size];
	int tag = 0;
	for (int i = 0; i < n + 1; i++)
	    if (prime[i])
		re[tag++] = i;
	return re;
    }

}
