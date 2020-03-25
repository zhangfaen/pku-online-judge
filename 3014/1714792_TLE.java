import java.io.*;

import java.util.*;

import java.math.*;

 

public class Main

{

    static int[][] memo;

    static int k;

    static int n;

 

    public static void main(String[] args)

    {

       Scanner cin = new Scanner(System.in);

       k = cin.nextInt();

       n = cin.nextInt();

       if (k > n)

           k = n;

       memo = new int[n + 1][k + 1];

       for (int i = 0; i < k + 1; i++)

           memo[0][i] = 1;

       for (int i = 1; i < n + 1; i++)

           for (int j = 1; j < k + 1; j++)

           {

              if (i >= j)

                  memo[i][j] += memo[i - j][j];

              memo[i][j] += memo[i][j - 1];

              if (memo[i][j] >= 1000000007)

                  memo[i][j] %= 1000000007;

           }

       int re = memo[n ][k];

       System.out.println(re);

    }

 

    public static int dp(int n, int k)

    {

       if (memo[n][k] != -1)

           return memo[n][k];

       int re = 0;

       re += dp(n - 1, k - 1) + dp(n - k, k);

       return memo[n][k] = re % 1000000007;

    }

}

 
