import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n;

    static char[] map;

    static boolean[][][] memo1;

    static boolean[][][] vst1;

    static int[] memo2;

    static boolean[] vst2;

    public static void main(String[] args) throws IOException {
        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
        String s = cin.readLine().trim();
        n = s.length();
        map = s.toCharArray();
        memo1 = new boolean[n][n][2];
        memo2 = new int[n];
        vst1 = new boolean[n][n][2];
        Arrays.fill(memo2, 1000000);
        memo2[0] = 1;
        if (n > 1)
            memo2[1] = 2;
        for (int i = 2; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                boolean bok = dp1(j, i, 'b');
                boolean aok = dp1(j, i, 'a');
                if (aok || bok) {
                    if (j == 0) {
                        memo2[i] = 1;
                        break;
                    } else {
                        memo2[i] = Math.min(memo2[i], 1 + memo2[j - 1]);
                    }
                }
            }
        }
        System.out.println(memo2[n - 1]);
    }

    public static boolean dp1(int i, int j, char c) {
        if (vst1[i][j][c - 'a'])
            return memo1[i][j][c - 'a'];
        vst1[i][j][c - 'a'] = true;
        if (i == j) {

            if (map[i] == c) {
                return memo1[i][j][c - 'a'] = true;
            }
            return memo1[i][j][c - 'a'] = false;
        }
        if (j == i + 1) {
            return memo1[i][j][c - 'a'] = false;
        }
        for (int k = i + 1; k < j; k++) {
            for (int x = k; x < j; x++) {
                if (dp1(k, x, c)) {
                    boolean l = dp1(i, k - 1, 'a');
                    boolean r = dp1(x + 1, j, 'a');
                    boolean ll = dp1(i, k - 1, 'b');
                    boolean rr = dp1(x + 1, j, 'b');
                    if (l && r || ll && rr) {
                        memo1[i][j][c - 'a'] = true;
                    }
                    if (memo1[i][j][0] && memo1[i][j][1])
                        break;
                }
            }
        }
        return memo1[i][j][c - 'a'];
    }

}
