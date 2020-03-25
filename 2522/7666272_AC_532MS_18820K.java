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

    private static int m, n, k;
    private static int[] result;

    public static void main(String[] args) throws Exception {
        PrintWriter out = new PrintWriter(System.out);
        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(cin.readLine());
        while (testcase-- > 0) {
            String[] sa = cin.readLine().split(" ");
            m = Integer.parseInt(sa[0]);
            n = Integer.parseInt(sa[1]);
            k = Integer.parseInt(sa[2]);
            memo = new int[m + 1][m + 1][n + 1];
            vst = new boolean[m + 1][m + 1][n + 1];
            result = new int[n];
            dfs(1, 0, m, k);
            for (int i = 0; i < result.length; i++) {
                out.println(result[i]);
            }
        }
        out.close();
    }

    private static void dfs(int base, int currentIndex, int remainingSum, int remainingKth) {
        if (currentIndex == n) {
            return;
        }
        for (int i = base; i <= remainingSum; i++) {
            int d = dp(remainingSum - i, i, n - currentIndex - 1);
            if (remainingKth <= d) {
                result[currentIndex] = i;
                dfs(i, currentIndex + 1, remainingSum - i, remainingKth);
                break;
            } else {
                remainingKth -= d;
            }
        }

    }

    private static int[][][] memo;
    private static boolean[][][] vst;

    private static int dp(int remainingSum, int base, int numberOfParts) {
        if (numberOfParts == 0) {
            if (remainingSum == 0) {
                return 1;
            }
            return 0;
        }
        if (remainingSum < base) {
            return 0;
        }
        if (vst[remainingSum][base][numberOfParts]) {
            return memo[remainingSum][base][numberOfParts];
        }
        vst[remainingSum][base][numberOfParts] = true;
        int ret = 0;
        for (int i = base; i <= remainingSum; i++) {
            ret += dp(remainingSum - i, i, numberOfParts - 1);
        }
        memo[remainingSum][base][numberOfParts] = ret;
        return ret;
    }
}
