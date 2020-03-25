import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader cin = new BufferedReader(
                new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        while (true) {
            int n = Integer.parseInt(cin.readLine());
            if (n == 0) {
                break;
            }
            int m=Integer.parseInt(cin.readLine());
            int [][] map=new int[n][n];
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++)
                    map[i][j]=Integer.MAX_VALUE/10;
            }
            for(int i=0;i<m;i++) {
                String [] sa=cin.readLine().split(" ");
                int a=Integer.parseInt(sa[0]);
                int b=Integer.parseInt(sa[1]);
                int cost=Integer.parseInt(sa[2]);
                map[a-1][b-1]=map[b-1][a-1]=cost;
            }
            String [] sa=cin.readLine().split(" ");
            int [] support=new int[n];
            for(int i=0;i<n;i++) {
                support[i]=Integer.parseInt(sa[i]);
            }
            
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    if(support[i]==2 && support[j]==1) {
                        map[i][j]=Integer.MAX_VALUE/10;
                    }
                }
            }
            
            for(int k=0;k<n;k++) {
                for(int i=0;i<n;i++) {
                    for(int j=0;j<n;j++) {
                        if(map[i][k]+map[k][j]<map[i][j]) {
                            map[i][j]=map[i][k]+map[k][j];
                        }
                    }
                }
            }
            
            if(map[0][1]>=Integer.MAX_VALUE/10) {
                out.println(-1);
            }else {
                out.println(map[0][1]);
            }
            
        }

        out.close();
    }

}
