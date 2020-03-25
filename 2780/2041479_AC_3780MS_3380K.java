import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;

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
		HashMap<Pair, Integer> map = new HashMap<Pair, Integer>();
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
				map.clear();
				for(int j = 0; j < n; j++){
					if(i != j){
						int a = x[j] - x[i];
						int b = y[j] - y[i];
						if(a < 0){
							a = -a;
							b = -b;
						}
						Pair pt = new Pair(a, b);
						Integer t = map.get(pt);
						if(t == null){
							map.put(pt, 1);
						}
						else{
							map.put(pt, t + 1);
							if(res < t + 1)
								res = t + 1;
						}
					}
				}
			}
			res++;
			out.write(res + "\n");
		}
		out.flush();
	}
}
class Pair{
	int a,b;
	public Pair(int c, int d){
		a = c;
		b = d;
	}
	public boolean equals(Object o){
		Pair other = (Pair)o;
		return this.a * other.b == this.b * other.a;
	}
	public int hashCode(){
		return (int)(100000.0 * b / a);
	}
}