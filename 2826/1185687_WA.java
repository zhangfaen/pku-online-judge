import java.io.File;
import java.util.Scanner;
public class Main
{
	
	public static void main(String [] args)throws Exception
	{
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt();
		while(n--!=0)
		{
			double x1,y1,x2,y2,x3,y3,x4,y4;
			x1=cin.nextDouble();
			y1=cin.nextDouble();
			x2=cin.nextDouble();
			y2=cin.nextDouble();
			x3=cin.nextDouble();
			y3=cin.nextDouble();
			x4=cin.nextDouble();
			y4=cin.nextDouble();
			if(y1 == y2 || y3 == y4){
				System.out.println("0.00");
				continue;
			}
			double a1 = y2 - y1;
			double b1 = x1 - x2;
			double c1 = 0 - x1 * a1 - y1 * b1;
			double a2 = y4 - y3;
			double b2 = x3 - x4;
			double c2 = 0 - x3 * a2 - y3 * b2;
			double t = a1 * b2 - a2 * b1;
			if(t == 0){
				System.out.println("0.00");
				continue;
			}
			double res = 0.0;
			double x = (b1 * c2 - b2 * c1) * 1.0 / t;
			double y = (a2 * c1 - a1 * c2) * 1.0 / t;
			//System.out.println("jiaodian"+x+"  "+y);
			if(in(x,x1,x2) && in(y,y1,y2) && in(x,x3,x4) && in(y, y3, y4)){
				x1-=x;x2-=x;x3-=x;x4-=x;y1-=y;y2-=y;y3-=y;y4-=y;
				double xn1,yn1,xn2,yn2;
				if(Math.max(y1,y2) <= 0 || Math.max(y3,y4) <= 0){
					System.out.println("0.00");
					continue;
				}
				if(y1>0)
				{
					xn1=x1;
					yn1=y1;
				}
				else
				{
					xn1=x2;
					yn1=y2;
				}
				if(y3>0)
				{
					xn2=x3;
					yn2=y3;
				}
				else
				{
					xn2=x4;
					yn2=y4;
				}
				if(xn1*xn2>0)
				{
					if(yn1>yn2&&Math.abs(xn1)>=Math.abs(xn2))
					{
						System.out.println("0.00");
						continue;
					}
					if(yn2>yn1&&Math.abs(xn2)>=Math.abs(xn1))
					{
						System.out.println("0.00");
						continue;
					}
				}
				if(xn1 == 0 || xn2 == 0){
					double wot = Math.max(xn1,xn2);
					res = 0.5 * wot * Math.min(yn1,yn2);
					System.out.printf("%.2f\n", res);
					continue;
				}
				if(yn1<yn2)
					res=Math.abs(xn2*yn1/yn2-xn1)*yn1*0.5;
				else
					res=Math.abs(xn1*yn2/yn1-xn2)*yn2*0.5;
				System.out.printf("%.2f\n",res);
			}
			else{
				System.out.println("0.00");
				continue;
			}
		}
	}
	public static boolean in(double x, double a, double b){
		double t1 = Math.max(a,b);
		double t2 = Math.min(a,b);
		if(x <= t1 && x >= t2)
			return true;
		return false;
	}
}

