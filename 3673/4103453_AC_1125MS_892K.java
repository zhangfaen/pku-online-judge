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
        StringTokenizer st=new StringTokenizer(cin.readLine());
        String s=st.nextToken();
        String t=st.nextToken();
        int ret=0;
        for(int i=0;i<s.length();i++) {
            for(int j=0;j<t.length();j++) {
                ret+=(s.charAt(i)-'0')*(t.charAt(j)-'0');
            }
        }
        System.out.println(ret);
        out.close();
    }

}
