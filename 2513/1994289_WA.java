import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader cin = new BufferedReader(
				new InputStreamReader(System.in));
		Map<String, Integer> pool = new HashMap<String, Integer>();
		int re = 0;
		while (true) {
			String s = cin.readLine();
			if (s == null)
				break;
			String[] sa = s.split(" ");
			Integer ti = pool.get(sa[0]);
			if (ti == null) {
				pool.put(sa[0], 1);
				re++;
			} else {
				if (ti % 2 == 0)
					re++;
				else
					re--;
				pool.put(sa[0], ti + 1);
			}
			ti = pool.get(sa[1]);
			if (ti == null) {
				pool.put(sa[1], 1);
				re++;
			} else {
				if (ti % 2 == 0)
					re++;
				else
					re--;
				pool.put(sa[1], ti + 1);
			}
		}
		if(re>2)
			System.out.println("Impossible");
		else
			System.out.println("Possible");
	}
}
