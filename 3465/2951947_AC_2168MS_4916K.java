import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(cin.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int h1 = Integer.parseInt(st.nextToken());
		int h2 = Integer.parseInt(st.nextToken());
		int[] as = new int[n];
		for (int i = 0; i < n; i++) {
			as[i] = Integer.parseInt(cin.readLine());
		}
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(n, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				if (o1 < o2)
					return 1;
				if (o1 > o2)
					return -1;
				return 0;
			}
		});
		int best = 0;
		int h22 = h2;
		for (int i = 0; i < n; i++) {
			h1 -= as[i];
			h2 -= x;
			if (h2 <= 0) {
				out.println("Win\n" + (i + 1));
				out.close();
				return;
			}
			best = Math.max(best, h22 - h2);
			q.add(as[i]);
			while (h1 <= 0) {
				int t = q.poll();
				h1 += Math.max(y, t);
				h2 += x;
			}
		}
		out.println("Lose");
		out.println(best);
		out.close();
	}
}
