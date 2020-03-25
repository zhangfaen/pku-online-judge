import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		System.out.println("INTERSECTING LINES OUTPUT");
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt();
		while(n--!=0)
		{
			int x1,y1,x2,y2,x3,y3,x4,y4;
			x1=cin.nextInt();y1=cin.nextInt();
			x2=cin.nextInt();y2=cin.nextInt();
			x3=cin.nextInt();y3=cin.nextInt();
			x4=cin.nextInt();y4=cin.nextInt();
			int a1,b1,c1,a2,b2,c2;
			a1=y2-y1;b1=x1-x2;c1=y1*(x2-x1)-x1*(y2-y1);
			a2=y4-y3;b2=x3-x4;c2=y3*(x4-x3)-x3*(y4-y3);
			int tys=c2*a1-c1*a2;
			int tyx=b1*a2-b2*a1;
			int txs=c2*b1-c1*b2;
			int txx=b2*a1-b1*a2;
			if(tys==0&&tyx==0)
				System.out.println("LINE");
			else
				if(tyx==0)
					System.out.println("NONE");
				else
					System.out.printf("POINT %.2f %.2f\n",(double)txs/txx,(double)tys/tyx);
		}
		System.out.println("END OF OUTPUT");
	
	}

}