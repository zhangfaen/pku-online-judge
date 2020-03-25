import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
	BufferedReader cin = new BufferedReader(
		new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	while (true) {
	    String s = cin.readLine();
	    if (s == null)
		break;
	    StringTokenizer st = new StringTokenizer(s);
	    int a = Integer.parseInt(st.nextToken());
	    int b = Integer.parseInt(st.nextToken());
	    int c = Integer.parseInt(st.nextToken());
	    int d = Integer.parseInt(st.nextToken());
	    int res = 0;
	    while (true) {
		if (a > b) {
		    int t = a;
		    a = b;
		    b = t;
		}
		if (c > d) {
		    int t = c;
		    c = d;
		    d = t;
		}
		if (a >= c && b >= d)
		    break;
		if (b < d) {
		    res++;
		    if (d % 2 == 0)
			d = d / 2;
		    else
			d = d / 2 + 1;
		    continue;
		}
		if (a < c) {
		    res++;
		    if (c % 2 == 0)
			c = c / 2;
		    else
			c = c / 2 + 1;
		}
	    }
	    System.out.println(res);
	}
    }
}
