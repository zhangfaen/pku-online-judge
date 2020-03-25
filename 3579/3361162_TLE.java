import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        out: while (true) {
            String src = cin.readLine();
            if (src == null)
                break;
            StringTokenizer st = new StringTokenizer(src);
            int n = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(cin.readLine());
            int[] p = new int[n];
            for (int i = 0; i < n; i++) {
                // try {
                if (st.hasMoreTokens())
                    p[i] = Integer.parseInt(st.nextToken());
                else {
                    st = new StringTokenizer(cin.readLine());
                    i--;
                }
                // } catch (IOException e) {
                // continue out;
                // }
            }
            Arrays.sort(p);
            int left = 0, right = Integer.MAX_VALUE;
            long all = (long) n * (n - 1) / 2;
            long target = all / 2;
            if (all % 2 != 0)
                target++;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                long small = 0, large = 0;
                for (int i = 0; i < n - 1; i++) {
                    int ll = i + 1, rr = n - 1;
                    while (ll <= rr) {
                        int mm = (ll + rr) / 2;
                        if (p[mm] - p[i] >= mid) {
                            rr = mm - 1;
                        } else {
                            ll = mm + 1;
                        }
                    }
                    small += rr - i;
                    ll = i + 1;
                    rr = n - 1;
                    while (ll <= rr) {
                        int mm = (ll + rr) / 2;
                        if (p[mm] - p[i] <= mid) {
                            ll = mm + 1;
                        } else {
                            rr = mm - 1;
                        }
                    }
                    large += n - ll;
                }
                long equal = all - small - large;
                if (small < target && small + equal >= target) {
                    out.println(mid);
                    break;
                }
                if (large <= all - target && large + equal > all - target) {
                    out.println(mid);
                    break;
                }
                if (small >= target) {
                    right = mid - 1;
                }
                if (large > all - target) {
                    left = mid + 1;
                }
            }

        }

        out.flush();
    }
}
