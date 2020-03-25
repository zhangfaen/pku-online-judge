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
		while (true) {
			String src = cin.readLine();
			if (src == null)
				break;
			StringTokenizer st = new StringTokenizer(src);
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] disks = new int[n + 1];
			st = new StringTokenizer(cin.readLine());
			for (int i = 0; i < n; i++) {
				disks[i] = Integer.parseInt(st.nextToken());
			}
			if (disks[n - 1] != 1) {
				disks[n - 1]--;
				disks[n] = 1;
				n++;
			}
			long res=0;
			for(int i=0;i<n;i++) {
				int pow=n-1-i;
				long tmp=1;
				for(int j=0;j<pow;j++) {
					tmp*=2;
					tmp%=m;
				}
				tmp*=disks[i];
				tmp%=m;
				res+=tmp;
			}
			res%=m;
			System.out.println(res);
		}

		out.flush();
	}
}
