import java.io.*;
import java.util.*;
import java.math.*;
public class Main {

	public static long[][] A = {{1,1},{1,0}};
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		while(true){
			int n = Integer.parseInt(in.readLine());
			if(n == -1)
				break;
			if(n == 0){
				System.out.println(0);
				continue;
			}
			System.out.println(matrix_pow(A,n)[0][1]);
		}
	}
	public static long[][] matrix_pow(long[][] data, int pow) {
		if (pow == 1) {
			return data;
		}
		if (pow % 2 == 0) {
			return matrix_pow(matrix_mul(data, data), pow / 2);
		} else {
			return matrix_mul(data, matrix_pow(data, pow - 1));
		}
	}
	public static long[][] matrix_add(long[][] m1, long[][] m2) {
		int x = m1.length;
		int y = m1[0].length;
		long[][] res = new long[x][y];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				res[i][j] = (m1[i][j] + m2[i][j]) % 10000;
			}
		}
		return res;
	}

	public static long[][] matrix_mul(long[][] m1, long[][] m2) {
		int x = m1.length;
		int y = m1[0].length;
		int z = m2[0].length;
		long[][] res = new long[x][z];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				for (int k = 0; k < z; k++)
					res[i][j] = (res[i][j] + m1[i][k] * m2[k][j]) % 10000;
			}
		}
		return res;
	}
}


