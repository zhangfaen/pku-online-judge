import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
  static int[][] memo;
  static boolean[][] vst;
  static int m, n;
  static String p, q;

  public static void main(String[] args) throws IOException {

    BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
    while (true) {

      String s = cin.readLine();
      if (s == null) break;
      String[] sa = s.split(" ");
      m = Integer.parseInt(sa[0]);
      p = sa[1];
      s = cin.readLine();
      sa = s.split(" ");
      n = Integer.parseInt(sa[0]);
      q = sa[1];
      memo = new int[m][n];
      vst = new boolean[m][n];
      int res = dp(0, 0);
      System.out.println(res);
    }

  }

  public static int dp(int i, int j) {
    if (i == m) {
      return n - j;
    }
    if (j == n) {
      return m - i;
    }
    if (vst[i][j]) return memo[i][j];
    vst[i][j] = true;
    int re = Integer.MAX_VALUE / 2;
    if (p.charAt(i) == q.charAt(j))
      re = dp(i + 1, j + 1);
    else {
      re = Math.min(re, 1 + dp(i, j + 1));
      re = Math.min(re, 1 + dp(i + 1, j));
      re = Math.min(re, 1 + dp(i + 1, j + 1));
    }
    memo[i][j] = re;
    return re;


  }
}
