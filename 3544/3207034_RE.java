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

    static class KM {
        public KM(long[][] map) {
            this.weight = map;
            this.n = map.length;
            lx = new long[n];
            ly = new long[n]; // 标号
            sx = new boolean[n];
            sy = new boolean[n]; // 是否被搜索过
            match = new int[n]; // Y(i) 与 X(match [i]) 匹配
        }

        int n; // X 的大小

        long weight[][]; // X 到 Y 的映射（权重）

        long[] lx;

        long[] ly; // 标号

        boolean[] sx;

        boolean[] sy; // 是否被搜索过

        int[] match; // Y(i) 与 X(match [i]) 匹配

        // 从 X(u) 寻找增广道路，找到则返回 true
        boolean path(int u) {
            sx[u] = true;
            for (int v = 0; v < n; v++)
                if (!sy[v] && lx[u] + ly[v] == weight[u][v]) {
                    sy[v] = true;
                    if (match[v] == -1 || path(match[v])) {
                        match[v] = u;
                        return true;
                    }
                }
            return false;
        }

        // 参数 maxsum 为 true ，返回最大权匹配，否则最小权匹配
        long bestmatch(boolean maxsum) {
            int i, j;
            if (!maxsum) {
                for (i = 0; i < n; i++)
                    for (j = 0; j < n; j++)
                        weight[i][j] = -weight[i][j];
            }
            // 初始化标号
            for (i = 0; i < n; i++) {
                lx[i] = Long.MIN_VALUE;
                ly[i] = 0;
                for (j = 0; j < n; j++)
                    if (lx[i] < weight[i][j])
                        lx[i] = weight[i][j];
            }
            Arrays.fill(match, -1);
            for (int u = 0; u < n; u++)
                while (true) {
                    Arrays.fill(sx, false);
                    Arrays.fill(sy, false);
                    if (path(u))
                        break;
                    // 修改标号
                    long dx = Long.MAX_VALUE;
                    for (i = 0; i < n; i++)
                        if (sx[i])
                            for (j = 0; j < n; j++)
                                if (!sy[j])
                                    dx = Math.min(lx[i] + ly[j] - weight[i][j], dx);
                    for (i = 0; i < n; i++) {
                        if (sx[i])
                            lx[i] -= dx;
                        if (sy[i])
                            ly[i] += dx;
                    }
                }
            long sum = 0;
            for (i = 0; i < n; i++)
                sum += weight[match[i]][i];
            if (!maxsum) {
                sum = -sum;
                for (i = 0; i < n; i++)
                    for (j = 0; j < n; j++)
                        weight[i][j] = -weight[i][j]; // 如果需要保持 weight [ ] [ ] 原来的值，这里需要将其还原
            }
            return sum;

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
        long[][] cap = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cap[i][j] = (w[i] * p[j] - d[j] * w[i] * t);
            }
        }
        KM km = new KM(cap);
        try {

            long re = km.bestmatch(true);
            for (int j = 0; j < n; j++) {
                out.print((km.match[j] + 1) + " ");
            }
        } catch (Throwable e) {
        }

        out.flush();
    }
}
