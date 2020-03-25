import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class Main {
    static class MinimumCostFlow {
        private int[][] cap;
        private BigInteger[][] cost;
        private int n;
        private int[] back;
        private BigInteger[] best;
        private int maxFlow = 0;
        public MinimumCostFlow(int[][] cap, BigInteger[][] cost) {
            this.cap = cap;
            this.cost = cost;
            this.n = cap.length;
            init();
            back = new int[n];
            best = new BigInteger[n];
        }
        private void init() {
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (cap[i][j] > 0)
                        cost[j][i] = cost[i][j].negate();
            maxFlow = 0;
        }
        public BigInteger get(int src, int dest) {
            BigInteger re = new BigInteger("0");
            while (true) {
                AugRe ar = aug(src, dest);
                if (ar == null)
                    break;
                re = re.add(ar.minCost);
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
            for (int i = 0; i < best.length; i++)
                best[i] = new BigInteger("99999999999999999999999999999");
            best[src] = new BigInteger("0");
            LinkedList<Integer> q = new LinkedList<Integer>();
            q.add(src);
            while (!q.isEmpty()) {
                int cur = q.remove(0);
                BigInteger cb = best[cur];
                for (int i = 0; i < n; i++)
                    if (cap[cur][i] > 0) {
                        if (cb.add(cost[cur][i]).compareTo(best[i]) < 0) {
                            best[i] = cb.add(cost[cur][i]);
                            back[i] = cur;
                            q.add(i);
                        }
                    }
            }
            if (best[dest].equals(new BigInteger(
                    "99999999999999999999999999999")))
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
            AugRe augre = new AugRe(best[dest].multiply(new BigInteger(minCap
                    + "")), minCap);
            return augre;
        }
        private static class AugRe {
            BigInteger minCost;
            int minCap;
            public AugRe(BigInteger minCost, int minCap) {
                this.minCost = minCost;
                this.minCap = minCap;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader cin = new BufferedReader(
                new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(cin.readLine());
        int n = Integer.parseInt(st.nextToken());
        BigInteger t = new BigInteger(st.nextToken());
        BigInteger[] w = new BigInteger[n];
        BigInteger[] d = new BigInteger[n];
        BigInteger[] p = new BigInteger[n];
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
        int[][] cap = new int[2 * n + 2][2 * n + 2];
        BigInteger[][] cost = new BigInteger[2 * n + 2][2 * n + 2];
        for (int i = 0; i < 2 * n + 2; i++)
            for (int j = 0; j < 2 * n + 2; j++)
                cost[i][j] = BigInteger.ZERO;
        for (int i = 0; i < n; i++) {
            cap[2 * n][i] = 1;
            cap[i + n][2 * n + 1] = 1;
            for (int j = 0; j < n; j++) {
                cap[i][j + n] = 1;
                cost[i][j + n] = (w[i].multiply(p[j]).subtract((d[j]
                        .multiply(w[i]).multiply(t)))).negate();
            }
        }
        MinimumCostFlow mcf = new MinimumCostFlow(cap, cost);
        BigInteger re = mcf.get(2 * n, 2 * n + 1);
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (cap[i][n + j] == 0) {
                    out.print((j + 1) + " ");
                    // break;
                }
            }
        out.println();
        out.flush();
    }
}
