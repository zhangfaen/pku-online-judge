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
        int tst=Integer.parseInt(cin.readLine());
        while(tst-->0) {
            cin.readLine();
            StringTokenizer st=new StringTokenizer(cin.readLine());
            int n=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            int [][] map=new int[n][n];
            int [] id=new int[n];
            for(int i=0;i<m;i++) {
                st=new StringTokenizer(cin.readLine());
                int a=Integer.parseInt(st.nextToken())-1;
                int b=Integer.parseInt(st.nextToken())-1;
                map[a][b]=1;
                id[b]++;
            }
            PriorityQueue<Integer>q=new PriorityQueue<Integer>();
            for(int i=0;i<n;i++) {
                if(id[i]==0) {
                    q.add(i);
                }
            }
            int [] output=new int[n];
            int tag=0;
            while(!q.isEmpty()) {
                int cur=q.poll();
                output[tag++]=cur;
                for(int i=0;i<n;i++) {
                    if(map[cur][i]==1) {
                        id[i]--;
                        if(id[i]==0) {
                            q.add(i);
                        }
                    }
                }
            }
            if(tag==n) {
                for(int i=0;i<n;i++) {
                    out.print((output[i]+1)+" ");
                }
            }else {
                out.print(-1);
            }
            out.println();
        }
        out.close();
    }

}
