import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(cin.readLine());
        int n = Integer.parseInt(st.nextToken());
        long t = Integer.parseInt(st.nextToken());
        long[] w = new long[n];
        long[] d = new long[n];
        long[] p = new long[n];
        int[] pid = new int[n];
        int[] did = new int[n];
        for (int i = 1; i <= n; i++)
            pid[i - 1] = did[i - 1] = i;
        st = new StringTokenizer(cin.readLine());
        for (int i = 0; i < n; i++) {
            w[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(cin.readLine());
        for (int i = 0; i < n; i++) {
            d[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(cin.readLine());
        for (int i = 0; i < n; i++) {
            p[i] = Long.parseLong(st.nextToken());
        }

        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++) {
                if (w[i] < w[j]) {
                    long tmp = w[i];
                    w[i] = w[j];
                    w[j] = tmp;
                    int tt = pid[i];
                    pid[i] = pid[j];
                    pid[j] = tt;
                }
            }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long pi = p[i] - (d[i] * t);
                long pj = p[j] - d[j] * t;
                if (pi < pj) {
                    long tmp = p[i];
                    p[i] = p[j];
                    p[j] = tmp;
                    tmp = d[i];
                    d[i] = d[j];
                    d[j] = tmp;
                    int tt = did[i];
                    did[i] = did[j];
                    did[j] = tt;
                }
            }
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[did[i] - 1] = pid[i];
        }
        for (int i = 0; i < n; i++) {
            out.print(res[i] + " ");
        }
        out.println();
        out.flush();
    }
}
