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
		int[] xs = new int[1000000];
		int[] ys = new int[1000000];
		int[] ls = new int[1000000];
		while (true) {
			String s = cin.readLine();
			if (s == null || s.trim().length() == 0)
				break;
			int n, m;
			StringTokenizer st = new StringTokenizer(s.trim());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			int[] d = new int[n + 1];
			int tag = 0;
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(cin.readLine().trim());
				String op = st.nextToken();
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				if (op.equals("P")) {
					int t = Integer.parseInt(st.nextToken());
					xs[tag] = b;
					ys[tag] = a;
					ls[tag++] = t;
					xs[tag] = a;
					ys[tag] = b;
					ls[tag++] = -t;
				} else {
					xs[tag] = a;
					ys[tag] = b;
					ls[tag++] = -1;
				}
			}
			for (int i = 0; i < n; i++) {
				xs[tag] = n;
				ys[tag] = i;
				ls[tag++] = 0;
			}
			Arrays.fill(d, Integer.MAX_VALUE / 10);
			d[n] = 0;
			for (int i = 0; i < n; i++) {
				boolean goon = false;
				for (int j = 0; j < tag; j++) {
					if (d[xs[j]] != Integer.MAX_VALUE / 10 && d[xs[j]] + ls[j] < d[ys[j]]) {
						d[ys[j]] = d[xs[j]] + ls[j];
						goon = true;

					}

				}
				if (goon == false)
					break;
			}
			boolean ok = true;

			for (int j = 0; j < tag; j++) {
				if (d[xs[j]] != Integer.MAX_VALUE / 10 && d[xs[j]] + ls[j] < d[ys[j]]) {

					ok = false;
					break;
				}
			}
			if (ok) {
				System.out.println("Reliable");
			} else {

				System.out.println("Unreliable");
			}
		}
		out.flush();
	}
}
