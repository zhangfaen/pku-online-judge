import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

	static int step;
	static int n;
	static int[][] pos;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// PrintWriter out = new PrintWriter(new
		// OutputStreamWriter(System.out));
		while(true){
			String[] t = in.readLine().split(" ");
			step = Integer.parseInt(t[0]);
			n = Integer.parseInt(t[1]);
			if(step == -1 && n == -1)
				break;
			pos = new int[n + 1][2];
			for(int i = 0; i < n; i++){
				t = in.readLine().split(" ");
				pos[i][0] = Integer.parseInt(t[0]);
				pos[i][1] = Integer.parseInt(t[1]);
			}
	
		pos[n][0] = 2 * pos[0][0] - pos[n - 1][0];
		pos[n][1] = 2 * pos[0][1] - pos[n - 1][1];

			double[][] memo = new double[n + 1][n + 1];
			for(int i = 0; i <= n; i++){
				for(int j = 0; j <=n; j++){
					memo[i][j] = Double.MAX_VALUE / 2;
				}
			}
			double[][] map = new double[n][n];
			for(int i = 0; i < n; i++){
				for(int j = 0; j < n; j++){
					map[i][j] = Math.hypot((pos[i][0] - pos[j][0]), (pos[i][1] - pos[j][1]));
				}
			}
			memo[n][0] = 0;
			int[] q = new int[1000000];
			int top = 0;
			int bottom = 0;
			q[top++] = n;
			q[top++] = 0;
			while(bottom < top){
				int from = q[bottom++];
				int now = q[bottom++];
				double dis = memo[from][now];
				for(int i = 0; i < n; i++){
					if(now != i && map[now][i] <= step){
						double tt = Math.abs(angle(pos[from][0], pos[from][1], pos[now][0], pos[now][1], pos[i][0], pos[i][1]));
						if(dis + map[now][i] +  tt < memo[now][i]){
							memo[now][i] = dis + map[now][i] +  tt;
							q[top++] = now;
							q[top++] = i;
						}
					}
				}
			}
			double res = Double.MAX_VALUE / 2;
			for(int i = 0; i < n - 1; i++){
				res = Math.min(res, memo[i][n - 1]);
			}
			if(res >= Double.MAX_VALUE / 2){
				System.out.println("impossible");
			}
			else{
				System.out.println(Math.round(res));
			}
		}
	}
	public static double angle(int x1, int y1, int x2, int y2, int x3, int y3){
		int vec1x = x2 - x1;
		int vec1y = y2 - y1;
		int vec2x = x3 - x2;
		int vec2y = y3 - y2;
		double a1 = Math.atan2( vec1y,vec1x);
		double a2 = Math.atan2( vec2y,vec2x);
		double res = Math.abs(a1 - a2);
		if(res >= Math.PI)
			res = Math.PI * 2 - res;
		return res * 180.0 / Math.PI;
	}
}