import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    static int[] p;

    static int[] r;

    static int findRelationToRoot(int x) {
        int cur = x;
        int re = 0;
        while (cur != p[cur]) {
            int f = r[cur];
            re += f;
            if (re == 2)
                re = -1;
            else if (re == -2)
                re = 1;
            cur = p[cur];
        }
        return re;
    }

    static int find(int x) {
        if (x == p[x])
            return x;
        int rf = findRelationToRoot(x);
        r[x] = rf;
        int root = find(p[x]);
        p[x] = root;
        return root;
    }

    static void union(int fx, int fy) {
        p[fy] = fx;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(cin.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int res = 0;
        p = new int[n];
        r = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        while (k-- > 0) {
            st = new StringTokenizer(cin.readLine());
            int cmmd = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (x > n || y > n) {
                res++;
                continue;
            }
            x--;
            y--;
            if (cmmd == 1) {
                if (x == y)
                    continue;
                int fx = find(x), fy = find(y);
                if (fx == fy) {
                    if (r[x] != r[y])
                        res++;
                } else {
                    int nr = r[x] - r[y];
                    if (nr == -2)
                        nr = 1;
                    else if (nr == 2)
                        nr = -1;
                    r[fy] = nr;
                    union(fx, fy);
                }
            } else {
                if (x == y) {
                    res++;
                    continue;
                }
                int fx = find(x), fy = find(y);
                if (fx == fy) {
                    int nr = r[x] - r[y];
                    if (nr != 1)
                        res++;
                } else {
                    if (r[x] == r[y]) {
                        r[fy] = -1;
                        union(fx, fy);
                    } else {
                        int nr = r[x] - r[y] - 1;
                        if (nr < -1)
                            nr += 3;
                        else if (nr > 1)
                            nr -= 3;
                        r[fy] = nr;
                        union(fx, fy);
                    }
                }
            }
        }
        out.println(res);
        out.flush();
    }
}
