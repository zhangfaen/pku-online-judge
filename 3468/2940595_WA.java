import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static long[] vs;
	static long[] delta;
	static long[] sum;
	static boolean[] valid;

	static long query(int cn, int left, int right, int a, int b, long tmpDelta) {
		if (left == right) {
			return vs[left] + delta[cn] + tmpDelta;
		}
		if (left == a && right == b) {
			if (valid[cn])
				return sum[cn];
			else {
				int mid = (left + right) / 2;
				sum[cn] = query(cn * 2, left, mid, left, mid, tmpDelta + delta[cn])
					+ query(cn * 2 + 1, mid + 1, right, mid + 1, right, tmpDelta + delta[cn]);
				valid[cn] = true;
				return sum[cn];
			}
		} else {
			int mid = (left + right) / 2;
			if (a >= mid + 1)
				return query(cn * 2 + 1, mid + 1, right, a, b, tmpDelta + delta[cn]);
			else if (b <= mid)
				return query(cn * 2, left, mid, a, b, tmpDelta + delta[cn]);
			else {
				return query(cn * 2, left, mid, a, mid, tmpDelta + delta[cn])
					+ query(cn * 2 + 1, mid + 1, right, mid + 1, b, tmpDelta + delta[cn]);
			}
		}
	}

	static void add(int cn, int left, int right, int a, int b, int c) {
		if (left == right) {
			delta[cn] += c;
			return;
		}
		if (left == a && right == b) {
			delta[cn] += c;
			sum[cn] += (long) c * (b - a + 1);
			return;
		}
		valid[cn] = false;
		int mid = (left + right) / 2;
		if (a >= mid + 1) {
			add(cn * 2 + 1, mid + 1, right, a, b, c);
		} else if (b <= mid) {
			add(cn * 2, left, mid, a, b, c);
		} else {
			add(cn * 2, left, mid, a, mid, c);
			add(cn * 2 + 1, mid + 1, right, mid + 1, b, c);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(cin.readLine());
		n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		vs = new long[n + 1];
		st = new StringTokenizer(cin.readLine());
		for (int i = 1; i <= n; i++)
			vs[i] = Integer.parseInt(st.nextToken());
		delta = new long[4 * n];
		sum = new long[4 * n];
		valid = new boolean[4 * n];
		while (q-- > 0) {
			st = new StringTokenizer(cin.readLine());
			String op = st.nextToken();
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (op.equals("C")) {
				int c = Integer.parseInt(st.nextToken());
				if (c == 0)
					continue;
				add(1, 1, n, a, b, c);
			} else {
				long t = query(1, 1, n, a, b, 0);
				out.println(t);
			}
		}
		out.flush();
	}
}
