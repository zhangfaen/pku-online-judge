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
        vst1 = new boolean[n][n][2];
        for (int i = 0; i < n; i++)
            memo1[i][i][map[i] - 'a'] = true;
        for (int i = 0; i < n - 1; i++) {
            memo1[i][i + 1][0] = false;
            memo1[i][i + 1][1] = false;
        }
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                for (int x = i + 1; x < j; x++) {
                    boolean la = memo1[i][x - 1][0];
                    boolean lb = memo1[i][x - 1][1];
                    if (la == false && lb == false)
                        continue;
                    for (int y = x; y < j; y++) {
                        boolean aok = memo1[x][y][0];
                        boolean bok = memo1[x][y][1];
                        if (aok == false && bok == false)
                            continue;
                        boolean ra = memo1[y + 1][j][0];
                        boolean rb = memo1[y + 1][j][1];
                        if (aok && (la && ra || lb && rb))
                            memo1[i][j][0] = true;
                        if (bok && (la && ra || lb && rb))
                            memo1[i][j][1] = true;

                    }
                }
            }
        }
        memo2 = new int[n];
        Arrays.fill(memo2, 1000000);
        memo2[0] = 1;
        if (n > 1)
            memo2[1] = 2;
        for (int i = 2; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                boolean bok = memo1[j][i][1];
                boolean aok = memo1[j][i][0];
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
}
