import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(cin.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][2 * n];
        int[] sizes = new int[n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(cin.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int t = Integer.parseInt(st.nextToken());

            map[x][sizes[x]++] = y;
            map[x][sizes[x]++] = t;

        }
        st = new StringTokenizer(cin.readLine());
        int s = Integer.parseInt(st.nextToken()) - 1, t = Integer.parseInt(st.nextToken()) - 1, k = Integer.parseInt(st
                .nextToken());
        int[][] memo = new int[n][k];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], Integer.MAX_VALUE / 2);
        }
        memo[s][0] = 0;
        List < Integer > q = new LinkedList < Integer >();
        q.add(s);

        while (q.size() > 0) {
            int cur = q.remove(0);
            Set < Integer > heap = new TreeSet < Integer >();
            for (int j = 0; j < sizes[cur]; j += 2) {
                int next = map[cur][j], len = map[cur][j + 1];
                for (int i = 0; i < k; i++) {
                    heap.add(memo[cur][i] + len);
                    heap.add(memo[next][i]);
                }
                boolean find = false;
                int tag = 0;
                for (int d : heap) {
                    if (d < memo[next][tag]) {
                        find = true;
                        memo[next][tag] = d;
                    }
                    tag++;
                    if(tag==k)break;
                }
                if (find) {
                    q.add(next);
                }
            }
        }
        System.out.println(memo[t][k - 1]);
    }

}
