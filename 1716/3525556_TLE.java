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
		int n = Integer.parseInt(cin.readLine());
		int nodes = 0;
		int[] as = new int[n];
		int[] bs = new int[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(cin.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken()) + 1;
			if (b + 1 > nodes)
				nodes = b + 1;
			as[i] = a;
			bs[i] = b;
		}
		int[] d = new int[nodes];
		Arrays.fill(d, Integer.MAX_VALUE / 10);
		d[nodes - 1] = 0;
		for (int i = 0; i < nodes - 1; i++) {
			for (int j = 0; j < as.length; j++) {
				if (d[bs[j]] != Integer.MAX_VALUE / 10 && d[bs[j]] - 2 < d[as[j]]) {
					d[as[j]] = d[bs[j]] - 2;
				}
			}
			for (int j = 0; j < nodes - 1; j++) {
				if (d[j] != Integer.MAX_VALUE / 10 && d[j] + 1 < d[j + 1]) {
					d[j + 1] = d[j] + 1;
				}
				if (d[j + 1] != Integer.MAX_VALUE / 10 && d[j + 1] < d[j]) {
					d[j] = d[j + 1];
				}
			}
			
		}
		System.out.println(-d[0]);
		out.flush();
	}
}
