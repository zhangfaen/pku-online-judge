import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;


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
            String[] template = new String[n];
            for (int i = 0; i < n; i++) {
                template[i] = cin.readLine();
            }
            int level = Integer.parseInt(cin.readLine());
            int size = n;
            char[][] ret = new char[size][size];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    ret[i][j] = template[i].charAt(j);
                }
            }
            while (--level > 0) {
                char[][] nret = new char[size * n][size * n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        int x = i * size, y = j * size;

                        for (int p = x; p < x + size; p++) {
                            for (int q = y; q < y + size; q++) {
                                if (template[i].charAt(j) == ' ') {
                                    nret[p][q] = ' ';
                                } else {
                                    nret[p][q] = ret[p - x][q - y];
                                }
                            }
                        }

                    }
                }
                ret = nret;
                size *= n;
            }
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    out.print(ret[i][j]);
                }
                out.println();
            }
        }
        out.close();
    }

}
