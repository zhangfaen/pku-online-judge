import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
	static boolean[][] map;

	static int[] match1;

	static int[] match2;

	static int m;

	static int n;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			m = in.nextInt();
			n = in.nextInt();
			map = new boolean[m + 1][n + 1];
			match1 = new int[m + 1];
			match2 = new int[n + 1];
			for (int i = 1; i <= m; i++) {
				int t = in.nextInt();
				for (int j = 0; j < t; j++) {
					map[i][in.nextInt()] = true;
				}
			}
			int res = 0;
			for (int i = 1; i <= m; i++)
				res += find(i);
			System.out.println(res);
		}
	}

	public static int find(int k) {
		int[] par = new int[n + 1];
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(k);
		while (!q.isEmpty()) {
			int cur = q.removeFirst();
			for (int i = 1; i <= n; i++) {
				if (map[cur][i] && par[i] == 0) {
					if (match2[i] > 0) {
						par[i] = cur;
						q.add(match2[i]);
					} else {
						int j = cur;
						while (true) {
							int t = match1[j];
							match1[j] = i;
							match2[i] = j;
							if (t == 0)
								break;
							i = t;
							j = par[t];
						}
						return 1;
					}
				}
			}
		}
		return 0;
	}
}

