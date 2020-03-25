//Bitonic TSP,&Acirc;ú&frac34;&shy;&micro;&auml;&micro;&Auml;DP&pound;&not;&para;&macr;&Igrave;&not;·&frac12;&sup3;&Igrave;&pound;&ordm;

//d[i]=min(i<=j<=n-1){Way(i...j)+d[j+1]+Way(j+1,i-1)}

import static java.lang.Math.*;
import java.util.*;

public class Main {
	static class Node {
		int x, y;

		double dis(Node b) {
			return sqrt(pow(x - b.x, 2) + pow(y - b.y, 2));
		}
	}

	public static void main(String[] args)  {
		Scanner cin = new Scanner(System.in);
		int n;
		double[][] w;
		Node[] go;
		double[] d;
		while (cin.hasNext()) {
			n = cin.nextInt();
			go = new Node[n + 1];
			w = new double[n + 1][n + 1];
			d = new double[n + 1];

			go[0] = go[1] = new Node();
			go[0].x = go[1].x = cin.nextInt();
			go[0].y = go[1].y = cin.nextInt();

			for (int i = 2; i <= n; i++) {
				go[i] = new Node();
				go[i].x = cin.nextInt();
				go[i].y = cin.nextInt();

				for (int j = 0; j < i; j++) {
					w[j][i] = go[i].dis(go[j]);
				}
			}

			d[n] = w[n - 1][n];
			double temp;
			for (int i = n - 1; i > 0; i--) {
				d[i] = -1;
				for (int j = i; j < n; j++) {
					temp = d[j + 1] + w[i - 1][j + 1];
					for (int k = i; k < j; k++) {
						temp += w[k][k + 1];
					}
					if (temp < d[i] || d[i] < 0) {
						d[i] = temp;
					}
				}
			}
			System.out.printf("%.2f\n",d[1]);
		}
	}
}
