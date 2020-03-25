import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	public static person[] ori;
	public static int n;
	public static double speed;
	public static void main(String[] args) throws Exception {
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(System.in);
		while(true){
			n = in.nextInt();
			if(n == 0)
				break;
			speed = in.nextDouble();
			ori = new person[n];
			for(int i = 0; i < n; i++){
				double x = in.nextDouble();
				double y = in.nextDouble();
				double s = in.nextDouble();
				double d = in.nextDouble();
				ori[i] = new person(x,y,s,d);
			}
			int[] per = new int[n];
			double res = Double.MAX_VALUE;
			for(int i = 0; i < n; i++)
				per[i] = i;
			do{
				res = Math.min(res, compute(per));
			}while(nextPermutation(per));
			System.out.println(Math.round(res));
		}
	}
	public static boolean nextPermutation(int[] a) {
		int i, j;
		for (i = a.length - 1; i > 0; i--) {
			if (a[i] > a[i - 1]) {
				break;
			}
		}
		i--;
		if (i == -1)
			return false;
		for (j = a.length - 1; j >= 0; j--) {
			if (a[j] > a[i])
				break;
		}
		int t = a[j];
		a[j] = a[i];
		a[i] = t;
		for (i = i + 1, j = a.length - 1; i < j; i++, j--) {
			t = a[i];
			a[i] = a[j];
			a[j] = t;
		}
		return true;
	}
	public static double compute(int[] per){
		person[] tmp = new person[n];
		for(int i = 0; i < n; i++){
			int index = per[i];
			tmp[i] = new person(ori[index].x, ori[index].y,ori[index].speed,ori[index].direct);
		}
		double res = 0.0;
		double total = 0.0;
		double curx=0,cury=0;
		for(int i = 0; i < n; i++){
			double a = tmp[i].speed * tmp[i].speed - speed * speed;
			double z = dis(curx, cury, tmp[i].x, tmp[i].y);
			double t = ((curx-tmp[i].x) * (curx-tmp[i].x) + (cury- tmp[i].y) * (cury- tmp[i].y));
			if(t == 0){
				double t2=dis(tmp[i].x, tmp[i].y, 0, 0) / tmp[i].speed;
				res = Math.max(res, total + t2);
				continue;
			}
			double tt = cos(tmp[i].x, tmp[i].y, curx, cury, tmp[i].direct);
			double b = 2.0 * tt * z * tmp[i].speed;
			double com = 0;
			com = Math.sqrt(b * b - 4.0 * a * t);
			double q1 = (b + com) / 2.0 / a;
			double q2 = (b - com) / 2.0 / a;
			if(q1 >= 0 && q2 >= 0){
				t = Math.min(q1, q2);
			}
			else if(q1 >= 0){
				t = q1;
			}
			else{
				t = q2;
			}
			total += t;			
			for(int j = i; j < n; j++){
				double r = tmp[j].speed * t;
				tmp[j].x += r * Math.cos(tmp[j].direct);
				tmp[j].y += r * Math.sin(tmp[j].direct);
			}
			double t2=dis(tmp[i].x, tmp[i].y, 0, 0) / tmp[i].speed;
			curx = tmp[i].x;
			cury = tmp[i].y;
			res = Math.max(res, total + t2);
		}
		return res;
	}
	public static double dis(double x1, double y1, double x2, double y2){
		return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
	}
	public static double cos(double x1, double y1, double x2, double y2, double d){
		double v1x = x2 - x1;
		double v1y = y2 - y1;
		double v2x = Math.cos(d);
		double v2y = Math.sin(d);
		return (v1x * v2x + v2y * v1y) / dis(x1, y1, x2, y2);
	}
}
class person{
	double x,y;
	double speed,direct;
	public person(double a, double b, double c , double d){
		x = a;
		y = b;
		speed = c;
		direct = d;
	}
}
