import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader cin = new BufferedReader(
                new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        while (true) {
            String s = cin.readLine();
            if (s == null || s.length() == 0)
                break;
            int n = Integer.parseInt(s);
            int a = 1, b = 1, c = n;
            long max = a * b + a * c + b * c;
            for (int i = 1; i <= (int) Math.sqrt(n) + 1; i++) {
                if (n % i != 0)
                    continue;
                int d = n / i;
                for (int j = 1; j <= (int) Math.sqrt(d) + 1; j++) {
                    if (d % j != 0)
                        continue;
                    long tmp = 0;
                    tmp += (long) i * j + (long) i * (d / j) + (long) j
                            * (d / j);
                    if (tmp < max) {
                        max = tmp;
                        a = i;
                        b = j;
                        c = d / j;
                    }
                }
            }
            System.out.println(a + " " + b + " " + c);
        }
    }
}
