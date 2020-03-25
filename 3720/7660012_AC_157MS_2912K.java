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
                for(int j=0;j<ps[i].length();j++) {
                    if(ps[i].charAt(j)==(char)(k+'0')) {
                        count++;
                    }
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
        HashSet<Integer> si = new HashSet<Integer>();
        while (!si.contains(current) && current != 0) {
            si.add(current);
            if (current < x) {
                current *= 10;
                ret += "0";
            } else {
                ret += (char) (current / x + '0');
                current = current % x;
                current*=10;
            }
        }
        return ret.substring(1);
    }

}
