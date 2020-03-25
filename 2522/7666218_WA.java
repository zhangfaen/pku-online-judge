import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        PrintWriter out = new PrintWriter(System.out);
        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(cin.readLine());
        while (testcase-- > 0) {
            String[] sa = cin.readLine().split(" ");
            int m = Integer.parseInt(sa[0]);
            int n = Integer.parseInt(sa[1]);
            int k = Integer.parseInt(sa[2]);
            memo = new int[m + 1][m + 1][n + 1];
            vst = new boolean[m + 1][m + 1][n + 1];
            int[] result = new int[n];
            dfs(result, 0, m, n, k);
            for (int i = 0; i < result.length; i++) {
                out.println(result[i]);
            }
        }
        out.close();
    }

    private static void dfs(int[] p, int ci, int cm, int n, int ck) {
        if (ci == n) {
            return;
        }
        for (int i = 1; i <= cm; i++) {
            int d = dp(cm - i, i, n - ci - 1);
            if (ck <= d) {
                p[ci] = i;
                dfs(p, ci + 1, cm - i, n, ck);
                break;
            } else {
                ck -= d;
            }
        }

    }

    private static int[][][] memo;
    private static boolean[][][] vst;

    private static int dp(int cm, int cp, int cn) {
        if (cn == 0) {
            if (cm == 0) {
                return 1;
            }
            return 0;
        }
        if (cm < cp) {
            return 0;
        }
        if (vst[cm][cp][cn]) {
            return memo[cm][cp][cn];
        }
        vst[cm][cp][cn] = true;
        int ret = 0;
        for (int i = cp; i <= cm; i++) {
            ret += dp(cm - i, i, cn - 1);
        }
        memo[cm][cp][cn] = ret;
        return ret;
    }

    private static String solve(int x) {
        String ret = "";
        int current = 1;
        HashSet<Integer> si = new HashSet<Integer>();
        while (!si.contains(current) && current != 0) {
            si.add(current);
            if (current < x) {
                current *= 10;
                ret += "0";
            } else {
                ret += (char) (current / x + '0');
                current = current % x;
                current *= 10;
            }
        }
        return ret.substring(1);
    }

}
