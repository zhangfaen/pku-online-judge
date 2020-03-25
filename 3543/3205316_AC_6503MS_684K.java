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
            String [] sa=s.split(" ");
            int b=Integer.parseInt(sa[0]);
            int w=Integer.parseInt(sa[1]);
            if(b==0&&w==0) {
                System.out.println("Impossible");
                continue;
            }
            if(b==0||w==0) {
                System.out.println(1);
                continue;
            }
            int res=1;
            for(int i=2;;i++) {
                if(i*i>b+w)break;
                if(i%2==0) {
                    int t=i*i/2;
                    if(b>=t&&w>=t) {
                        res=i;
                    }else {
                        break;
                    }
                }else {
                    int min=(i*i-1)/2;
                    int max=(i*i+1)/2;
                    if(Math.min(b,w)>=min&&Math.max(b,w)>=max) {
                        res=i;
                    }else {
                        break;
                    }
                }
            }
            System.out.println(res);
        }
    }
}
