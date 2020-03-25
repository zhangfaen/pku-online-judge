import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	static int[] dx = {0,0,-1,1,-1,1};
	static int[] dy = {-2,2,-1,-1,1,1};
	static int[][][] memo = new int[200][200][20];
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		for(int num = 1; num <= n; num++){
			for(int i = 0; i < 200; i++){
				for(int j = 0; j < 200; j++){
					for(int k = 0; k < 20; k++){
						memo[i][j][k] = -1;
						if(k == 0 && i == 100 && j == 100){
							memo[i][j][k] = 1;
						}
						else if(k == 0){
							memo[i][j][k] = 0;
						}
					}
				}
			}
			int v = Integer.parseInt(in.readLine());
			System.out.println(dp(100,100, v));
		}
	}
	public static int dp(int x, int y, int left){
		if(memo[x][y][left] >= 0)
			return memo[x][y][left];
		int res = 0;
		for(int i = 0; i < 6; i++){
			int tx = x + dx[i];
			int ty = y + dy[i];
			res += dp(tx, ty, left - 1);
		}
		return memo[x][y][left] = res;
	}
}