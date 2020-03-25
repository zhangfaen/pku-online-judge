import java.io.File;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		while (n-- != 0) {
			double x1, y1, x2, y2, x3, y3, x4, y4;
			x1 = cin.nextDouble();
			y1 = cin.nextDouble();
			x2 = cin.nextDouble();
			y2 = cin.nextDouble();
			x3 = cin.nextDouble();
			y3 = cin.nextDouble();
			x4 = cin.nextDouble();
			y4 = cin.nextDouble();
			if (y1 == y2 || y3 == y4) {
				System.out.println("0.00");
				continue;
			}
			double a1 = y2 - y1;
			double b1 = x1 - x2;
			double c1 = x1 * a1 + y1 * b1;
			double a2 = y4 - y3;
			double b2 = x3 - x4;
			double c2 = x3 * a2 + y3 * b2;
			double t = a1 * b2 - a2 * b1;
			if (t == 0) {
				System.out.println("0.00");
				continue;
			}
			double res = 0.0;
			double x = (b2 * c1 - b1 * c2) * 1.0 / t;
			double y = (a1 * c2 - a2 * c1) * 1.0 / t;
			// System.out.println("jiaodian"+x+" "+y);
			if (in(x, x1, x2, y, y1, y2) && in(x, x3, x4, y, y3, y4)) {
				x1 -= x;
				x2 -= x;
				x3 -= x;
				x4 -= x;
				y1 -= y;
				y2 -= y;
				y3 -= y;
				y4 -= y;
				double xn1, yn1, xn2, yn2;
				if (Math.max(y1, y2) <= 0 || Math.max(y3, y4) <= 0) {
					System.out.println("0.00");
					continue;
				}
				if (y1 > 0) {
					xn1 = x1;
					yn1 = y1;
				} else {
					xn1 = x2;
					yn1 = y2;
				}
				if (y3 > 0) {
					xn2 = x3;
					yn2 = y3;
				} else {
					xn2 = x4;
					yn2 = y4;
				}
				if (xn1 * xn2 > 0) {
					if (yn1 > yn2 && Math.abs(xn1) >= Math.abs(xn2)&&Math.abs(1.*yn1/xn1)>=Math.abs(1.*yn2/xn2)) {
						System.out.println("0.00");
						continue;
					}
					if (yn2 > yn1 && Math.abs(xn2) >= Math.abs(xn1)&&Math.abs(1.*yn2/xn2)>=Math.abs(1.*yn1/xn1)) {
						System.out.println("0.00");
						continue;
					}
				}
				if (xn1 == 0 || xn2 == 0) {
					if (xn1 == 0) {
						if (yn1 >= yn2) {
							res = 0.5 * Math.abs(xn2) * yn2;
						} else {
							res = 0.5 * Math.abs(xn2) * yn1 / yn2 * yn1;
						}
					} else {
						if (yn2 >= yn1) {
							res = 0.5 * Math.abs(xn1) * yn1;
						} else {
							res = 0.5 * Math.abs(xn1) * yn2 / yn1 * yn2;
						}
					}
					System.out.printf("%.2f\n", res);
					continue;
				}
				if (yn1 < yn2)
					res = Math.abs(xn2 * yn1 / yn2 - xn1) * yn1 * 0.5;
				else
					res = Math.abs(xn1 * yn2 / yn1 - xn2) * yn2 * 0.5;
				System.out.printf("%.2f\n", res);
			} else {
				System.out.println("0.00");
			}
		}
	}

	public static boolean in(double x, double x1, double x2, double y,
			double y1, double y2) {
		return x <= Math.max(x1, x2) && x >= Math.min(x1, x2)
				&& y >= Math.min(y1, y2) && y <= Math.max(y1, y2);
	}
}
