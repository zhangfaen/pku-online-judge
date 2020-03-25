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
			int v = Integer.parseInt(in.readLine());
			int[] res = new int[v];
			int cur = 1;
			int t = 0;
			int index = 0;
			while(cur <= v){
				if(res[index] == 0){
					t++;
				}
				if(t == cur + 1){
					res[index] = cur;
					cur++;
					t = 0;
				}
				index = (index + 1) % v;
			}
			for(int i = 0; i < v; i++)
				System.out.print(res[i] + " ");
			System.out.println();
		}
	}
}