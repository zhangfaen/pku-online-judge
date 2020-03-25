
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class MinimumCostFlow {
        private int[][] cap;

        private long[][] cost;

        private int n;

        private int[] back;

        private long[] best;

        private int maxFlow = 0;

        public MinimumCostFlow(int[][] cap, long[][] cost) {
            this.cap = cap;
            this.cost = cost;
            this.n = cap.length;
            init();
            back = new int[n];
            best = new long[n];
        }

        private void init() {
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (cap[i][j] > 0)
                        cost[j][i] = -cost[i][j];
            maxFlow = 0;
        }

        public long get(int src, int dest) {
            long re = 0;
            while (true) {
                AugRe ar = aug(src, dest);
                if (ar == null)
                    break;
                re += ar.minCost;
                maxFlow += ar.minCap;
            }
            return re;
        }

        public int getMaxFlow() {
            return maxFlow;
        }

        private AugRe aug(int src, int dest) {
            Arrays.fill(back, -1);
            back[src] = src;
            Arrays.fill(best, Long.MAX_VALUE);
            best[src] = 0;
            LinkedList < Integer > q = new LinkedList < Integer >();
            q.add(src);
            while (!q.isEmpty()) {
                int cur = q.remove(0);
                long cb = best[cur];
                for (int i = 0; i < n; i++)
                    if (cap[cur][i] > 0) {
                        if (cb + cost[cur][i] < best[i]) {
                            best[i] = cb + cost[cur][i];
                            back[i] = cur;
                            q.add(i);
                        }
                    }
            }
            if (best[dest] == Long.MAX_VALUE)
                return null;
            int minCap = Integer.MAX_VALUE;
            int cur = dest;
            while (back[cur] != cur) {
                minCap = Math.min(cap[back[cur]][cur], minCap);
                cur = back[cur];
            }
            cur = dest;
            while (back[cur] != cur) {
                cap[back[cur]][cur] -= minCap;
                cap[cur][back[cur]] += minCap;
                cur = back[cur];
            }
            AugRe augre = new AugRe(best[dest] * minCap, minCap);
            return augre;
        }

        private static class AugRe {
            long minCost, minCap;

            public AugRe(long minCost, long minCap) {
                this.minCost = minCost;
                this.minCap = minCap;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(cin.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        long[] w = new long[n];
        long[] d = new long[n];
        long[] p = new long[n];
        st = new StringTokenizer(cin.readLine());
        for (int i = 0; i < n; i++) {
            w[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(cin.readLine());
        for (int i = 0; i < n; i++) {
            d[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(cin.readLine());
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }
        int[][] cap = new int[2 * n + 2][2 * n + 2];
        long[][] cost = new long[2 * n + 2][2 * n + 2];
        for (int i = 0; i < n; i++) {
            cap[2 * n][i] = 1;
            cap[i + n][2 * n + 1] = 1;
            for (int j = 0; j < n; j++) {
                cap[i][j + n] = 1;
                cost[i][j + n] = -(w[i] * p[j] - d[j] * w[i] * t);
            }
        }
        MinimumCostFlow mcf = new MinimumCostFlow(cap, cost);
        long re = mcf.get(2 * n, 2 * n + 1);
        for (int j = 0; j < n; j++) {

            for (int i = 0; i < n; i++) {

                if (cap[i][n + j] == 0) {
                    out.print((i + 1) + " ");

                }

            }
        }
        out.flush();
    }
}
