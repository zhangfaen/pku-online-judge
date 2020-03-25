import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader cin = new BufferedReader(
                new InputStreamReader(System.in));

        PrintWriter out = new PrintWriter(System.out);
        String [] sa=cin.readLine().split(",");
        int a=Integer.parseInt(sa[0],16);
        int x=Integer.parseInt(sa[1]);
        int y=Integer.parseInt(sa[2]);
        int m=~(1<<x);
        a&=m;
        a|=(1<<(y));
        a|=(1<<(y-1));
        a&=~(1<<(y-2));
        
        out.println(Integer.toHexString(a));
        out.close();
    }

}
