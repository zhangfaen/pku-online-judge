import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
  static int n;
  static List<Integer>[] map;
  static int time = -1;
  static int[] st;
  static int[] et;
  static int[] tree;
  static int[] state;
  static int left, right;

  public static void main(String[] args) throws Exception {
    try {
      BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter out = new PrintWriter(System.out);
      String s = cin.readLine();
      n = Integer.parseInt(s);
      map = new ArrayList[n];
      for (int i = 0; i < n; i++)
        map[i] = new ArrayList<Integer>();
      StringTokenizer stk = null;
      for (int i = 1; i < n; i++) {
        stk = new StringTokenizer(cin.readLine());
        int a = Integer.parseInt(stk.nextToken()) - 1;
        int b = Integer.parseInt(stk.nextToken()) - 1;
        map[a].add(b);
        map[b].add(a);
      }
      st = new int[n];
      et = new int[n];
      state = new int[n];
      tree = new int[100 * n];

      dfs(0, -1);
      left = 0;
      right = time;

      for (int i = 0; i < n; i++) {
        state[i] = 1;
        update(1, left, right, st[i], 1);
      }


      s = cin.readLine();
      int m = Integer.parseInt(s);
      for (int i = 0; i < m; i++) {
        stk = new StringTokenizer(cin.readLine());
        String op = stk.nextToken();
        int target = Integer.parseInt(stk.nextToken()) - 1;
        if (op.equals("C")) {
          int fac = 0;
          if (state[target] == 1) {
            fac = -1;
            state[target] = 0;
          } else {
            fac = 1;
            state[target] = 1;
          }
          update(1, left, right, st[target], fac);
        } else {
          int res = get(1, left, right, st[target], et[target]);
          out.println(res);
        }
      }
      out.flush();
    } catch (Throwable e) {
    }
  }

  public static void update(int cn, int cl, int cr, int target, int fac) {
    if (cl == cr) {
      tree[cn] += fac;
      return;
    }
    tree[cn] += fac;
    int mid = (cl + cr) / 2;
    if (target <= mid) {
      update(cn * 2, cl, mid, target, fac);
    } else {
      update(cn * 2 + 1, mid + 1, cr, target, fac);
    }
  }

  public static int get(int cn, int cl, int cr, int tl, int tr) {
    if (cl == tl && cr == tr) {
      return tree[cn];
    }
    int mid = (cl + cr) / 2;
    int re = 0;
    if (tr <= mid)
      re = get(cn * 2, cl, mid, tl, tr);
    else if (tl > mid)
      re = get(cn * 2 + 1, mid + 1, cr, tl, tr);
    else {
      re = get(cn * 2, cl, mid, tl, mid)
          + get(cn * 2 + 1, mid + 1, cr, mid + 1, tr);
    }
    return re;
  }

  public static void dfs(int cur, int pre) {
    st[cur] = ++time;
    for (int next : map[cur]) {
      if (next == pre) continue;
      dfs(next, cur);
    }
    et[cur] = time;
  }
}
