import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class Main {
	public static void main(String[] arg) throws FileNotFoundException {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		int d = in.nextInt();
		int sum = in.nextInt();
		while (a + b + c + d > 0) {
			if(a < 0 || b < 0 || c < 0 || d < 0){
				FileNotFoundException e = new FileNotFoundException();
				throw e;
			}
			int res = Integer.MAX_VALUE;
			int resa = 0, resb = 0, resc = 0, resd = 0;
			for (int i = 0; i <= Math.min(a, sum / 25); i++) {
				for (int j = 0; j <= Math.min(b, sum / 10); j++) {
					for (int m = 0; m <= Math.min(c, sum / 5); m++) {
						for (int n = 0; n <= Math.min(d, sum); n++) {
							if (25 * i + 10 * j + 5 * m + n == sum) {
								if (i + j + m + n <= res) {
									res = i + j + m + n;
									resa = i;
									resb = j;
									resc = m;
									resd = n;
								}
							}
						}
					}
				}
			}
			if (res == Integer.MAX_VALUE) {
				System.out.println("Cannot dispense the desired amount.");
			} else {
				System.out.println("Dispense " + resa + " quarters, " + resb
						+ " dimes, " + resc + " nickels, and " + resd
						+ " pennies.");
			}
			a = in.nextInt();
			b = in.nextInt();
			c = in.nextInt();
			d = in.nextInt();
			sum = in.nextInt();
		}
	}

}
