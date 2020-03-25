import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static int[] x,y;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
				System.out));
		
		while (true) {
			String s = in.readLine();
			if(s == null || s.equals(""))
				break;
			int n = Integer.parseInt(s);
			x = new int[n];
			y = new int[n];
			for(int i = 0; i < n; i++){
				String[] t = in.readLine().split(" ");
				x[i] = Integer.parseInt(t[0]);
				y[i] = Integer.parseInt(t[1]);
			}
			int res = 1;
			for(int i = 0; i < n; i++){
				int[] vector1 = new int[1010000];
		int[] vector2 = new int[1010000];
				for(int j = 0; j < n; j++){
					if(i != j){
						if(x[i] > x[j]){
							if(y[i] > y[j]){
								int g = gcd(x[i] - x[j], y[i] - y[j]);
								res = Math.max(res, ++vector1[1001 * ((x[i] - x[j]) / g) + (y[i] - y[j] / g)]);
							}
							else{
								int g = gcd(x[i] - x[j], y[j] - y[i]);
								res = Math.max(res, ++vector2[1001 * ((x[i] - x[j]) / g) + (y[j] - y[i] / g)]);
							}
						}
						else{
							if(y[i] > y[j]){
								int g = gcd(x[j] - x[i], y[i] - y[j]);
								res = Math.max(res, ++vector2[1001 * ((x[j] - x[i]) / g) + (y[i] - y[j] / g)]);
							}
							else{
								int g = gcd(x[j] - x[i], y[j] - y[i]);
								res = Math.max(res, ++vector1[1001 * ((x[j] - x[i]) / g) + (y[j] - y[i] / g)]);
							}
						}
					}
				}
			}
			res++;
			out.write(res + "\n");
		}
		out.flush();
	}
	public static int gcd(int m, int n){
    	if(m == 0)
    		return n;
    	return gcd(n % m, m);
    }
}