import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  static List<Integer> map[];
  
  public static void main(String[] args) throws IOException {
    BufferedReader cin=new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out=new PrintWriter(System.out);
    int n,r;
    String s=cin.readLine();
    StringTokenizer st=new StringTokenizer(s);
    n=Integer.parseInt(st.nextToken());
    r=Integer.parseInt(st.nextToken());
    map=new ArrayList[n+1];
    for(int i=0;i<=n;i++)
    {
      map[i]=new ArrayList<Integer>();
    }
    for(int i=0;i<r;i++)
    {
      s=cin.readLine();
      st=new StringTokenizer(s);
      int x=Integer.parseInt(st.nextToken());
      int y=Integer.parseInt(st.nextToken());
      int len=Integer.parseInt(st.nextToken());
      map[x].add(y);map[x].add(len);
      map[y].add(x);map[y].add(len);
    }
    List<Integer> q=new LinkedList<Integer>();
    int [] first=new int[n+1];
    int [] second=new int[n+1];
    int INF=Integer.MAX_VALUE/2;
    Arrays.fill(first,INF);
    Arrays.fill(second,INF);
    first[1]=0;
    q.add(1);
    while(!q.isEmpty())
    {
      int cur=q.remove(0);
      int cf=first[cur];
      int cs=second[cur];
      for(int i=0;i<map[cur].size();i+=2)
      {
        int next=map[cur].get(i);
        int len=map[cur].get(i+1);
        if(cf+len<first[next])
        {
          second[next]=first[next];
          first[next]=cf+len;
          q.add(next);
        }else if(cf+len>first[next]&&cf+len<second[next])
        {
          second[next]=cf+len;
          q.add(next);
        }
      }
    }
    System.out.println(second[n]);
  }

}
