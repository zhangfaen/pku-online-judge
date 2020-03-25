import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		String s = cin.readLine();
		int n = Integer.parseInt(s);
		int[][] map = new int[n][n];
		int ci = 0, cj = 0;
		int res = Integer.MIN_VALUE;
		while (true) {
			s = cin.readLine();
			if (s == null)
				break;
			StringTokenizer st = new StringTokenizer(s);
			while (st.hasMoreTokens()) {
				int next = Integer.parseInt(st.nextToken());
				map[ci][cj++] = next;
				res = Math.max(res, next);
				if (cj == n) {
					ci++;
					cj = 0;
				}
			}
		}
		int[][] psum = new int[n][n];
		for (int j = 0; j < n; j++)
			psum[j][0] = map[j][0];
		for (int j = 1; j < n; j++)
			for (int i = 0; i < n; i++)
				psum[i][j] = map[i][j] + psum[i][j - 1];
		for(int i=0;i<n;i++)
			for(int j=i;j<n;j++)
			{
				int tb=0;
				for(int k=0;k<n;k++)
				{
					int tmp=psum[k][j]-psum[k][i]+map[k][i];
					if(tb+tmp>=0)
					{
						res=Math.max(res, tb+tmp);
						tb+=tmp;
					}
					else
					{
						tmp=0;
					}
				}
			}
		System.out.println(res);
	}

}
