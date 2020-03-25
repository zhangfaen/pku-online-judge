import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

  static class Snow {
    int[] v;

    public Snow(int[] p) {
      this.v = p;
    }

    @Override
    public boolean equals(Object o) {
      Snow s = (Snow) o;
      int[] u = s.v;
      for (int i = 0; i < v.length; i++) {
        boolean ok = true;
        for (int j = i, k = 0; k < v.length; j = (j + 1) % v.length, k++) {
          if (v[j] != u[k]) {
            ok = false;
            break;
          }
        }
        if (ok) return true;
        ok = true;
        for (int j = i, k = 0; k < v.length; j = (j - 1 + v.length) % v.length, k++) {
          if (v[j] != u[k]) {
            ok = false;
            break;
          }
        }
        if (ok) return true;
      }
      return false;
    }

    @Override
    public int hashCode() {
      int[] t = new int[v.length];
      for (int i = 0; i < v.length; i++)
        t[i] = v[i];
      Arrays.sort(t);
      int re = 0;
      int fac = 10;
      for (int i = 0; i < t.length; i++) {
        re += t[i] * fac;
        fac *= 10;
      }
      return re;
    }
  }

  public static void main(String[] args) throws IOException {

    BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;
    int n = Integer.parseInt(cin.readLine());
    Set<Snow> ss = new HashSet<Snow>();
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(cin.readLine());
      int[] p = new int[6];
      for (int j = 0; j < 6; j++)
        p[j] = Integer.parseInt(st.nextToken());
      Snow snow = new Snow(p);
      ss.add(snow);
    }
    if (ss.size() == n) {
      System.out.println("No two snowflakes are alike.");
    } else {
      System.out.println("Twin snowflakes found.");
    }
  }

}
