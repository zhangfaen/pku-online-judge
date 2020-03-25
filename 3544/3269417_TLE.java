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
        int t = Integer.parseInt(st.nextToken());
        BigInteger bit = new BigInteger("" + t);
        BigInteger[] w = new BigInteger[n];
        BigInteger[] d = new BigInteger[n];
        BigInteger[] p = new BigInteger[n];
        int[] pid = new int[n];
        int[] did = new int[n];
        for (int i = 1; i <= n; i++)
            pid[i-1] = did[i-1] = i;
        st = new StringTokenizer(cin.readLine());
        for (int i = 0; i < n; i++) {
            w[i] = new BigInteger(st.nextToken());
        }
        st = new StringTokenizer(cin.readLine());
        for (int i = 0; i < n; i++) {
            d[i] = new BigInteger(st.nextToken());
        }
        st = new StringTokenizer(cin.readLine());
        for (int i = 0; i < n; i++) {
            p[i] = new BigInteger(st.nextToken());
        }

        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++) {
                if (w[i].compareTo(w[j]) < 0) {
                    BigInteger tmp = w[i];
                    w[i] = w[j];
                    w[j] = tmp;
                    int tt = pid[i];
                    pid[i] = pid[j];
                    pid[j] = tt;
                }
            }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                BigInteger pi = p[i].subtract(d[i].multiply(bit));
                BigInteger pj = p[j].subtract(d[j].multiply(bit));
                if (pi.compareTo(pj) < 0) {
                    BigInteger tmp = p[i];
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
            res[did[i]-1] = pid[i];
        }
        for (int i = 0; i < n; i++) {
            out.print(res[i] + " ");
        }
        out.println();
        out.flush();
    }
}
