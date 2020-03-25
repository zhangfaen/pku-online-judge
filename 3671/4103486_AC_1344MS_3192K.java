import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader cin = new BufferedReader(
                new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.parseInt(cin.readLine());
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(cin.readLine());
        }
        int[] c1 = new int[n];
        int[] c2 = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (p[i] == 1) {
                    c1[0] = 1;
                } else {
                    c2[0] = 1;
                }
            } else {
                c1[i]=c1[i-1];
                c2[i]=c2[i-1];
                if (p[i] == 1) {
                    c1[i] ++;
                } else {
                    c2[i] ++;
                }
            }
        }
        int ret=Integer.MAX_VALUE;
        for(int i=1;i<n;i++) {
            int t=c2[i-1]+c1[n-1]-c1[i-1];
            ret=Math.min(ret, t);
        }
        ret=Math.min(ret,c1[n-1]);
        ret=Math.min(ret,c2[n-1]);
        System.out.println(ret);
        out.close();
    }

}
