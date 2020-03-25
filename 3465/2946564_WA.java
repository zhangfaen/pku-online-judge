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
		q.add(0);
		int best = h2;
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (h2 - x <= 0) {
				out.println("Win");
				out.println(i + 1);
				out.close();
				return;
			}
	
			int b = Math.max(y - as[i], 0);
			if (h1 > as[i]) {
				h2 -= x;
				h1 -= as[i];
				q.add(b + as[i]);
			} else {
				if (as[i] + b < q.peek()) {
					h1 += q.poll() - as[i] - b;
					q.add(as[i] + b);
				} else
					h1 += b;
			}
		}
		out.println("Lose");
		out.println(best - h2);
		out.close();
	}
}
