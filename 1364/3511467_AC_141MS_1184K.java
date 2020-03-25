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
			StringTokenizer st = new StringTokenizer(cin.readLine());
			int n = Integer.parseInt(st.nextToken());
			if (n == 0)
				break;
			int m = Integer.parseInt(st.nextToken());
			int[] ex = new int[m + n + 1];
			int[] ey = new int[m + n + 1];
			int[] lxy = new int[m + n + 1];
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(cin.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				String op = st.nextToken();
				int v = Integer.parseInt(st.nextToken());
				int a = x - 1, b = x + y;
				if (op.equals("lt")) {
					ex[i] = b;
					ey[i] = a;
					lxy[i] = -v + 1;
				} else {
					ex[i] = a;
					ey[i] = b;
					lxy[i] = v + 1;
				}
			}
			for (int i = m; i < ex.length; i++) {
				ex[i] = n + 1;
				ey[i] = i - m;
				lxy[i] = 0;
			}
			int [] d=new int[n+2];
			Arrays.fill(d, -Integer.MAX_VALUE/2);
			d[n+1]=0;
			for(int i=0;i<n+1;i++) {
				for(int j=0;j<ex.length;j++) {
					if(d[ey[j]]<d[ex[j]]+lxy[j]) {
						d[ey[j]]=d[ex[j]]+lxy[j];
					}
				}
			}
			boolean ok=true;
			for(int j=0;j<ex.length;j++) {
				if(d[ey[j]]<d[ex[j]]+lxy[j]) {
					ok=false;
					break;
				}
			}
			if(ok)
				out.println("lamentable kingdom");
			else
				out.println("successful conspiracy");

		}
		out.flush();
	}
}
