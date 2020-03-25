import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        PrintWriter out = new PrintWriter(System.out);
        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));

        String[] ps = new String[101];
        for (int i = 2; i <= 100; i++) {
            ps[i] = solve(i);
        }
        while (true) {
            String s = cin.readLine();
            if (s == null) {
                break;
            }
            String[] sa = s.split(" ");
            int n = Integer.parseInt(sa[0]);
            int k = Integer.parseInt(sa[1]);
            int count = 0;
            for (int i = 2; i <= n; i++) {
                if (ps[i].indexOf((char) (k + '0')) >= 0) {
                    count++;
                }
            }
            out.println(count);
            out.flush();
        }

        out.close();
    }

    private static String solve(int x) {
        String ret = "";
        int current = 1;
        while (current != 0) {
            current *= 10;
            char c = (char) ('0' + current / x);
            current %= 10;
            if (ret.indexOf(c) >= 0) {
                return ret;
            }
            ret += c;

        }
        return ret;
    }

}
