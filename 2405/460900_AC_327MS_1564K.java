import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		while(true)
		{
			int D,V;
			D=cin.nextInt();
			V=cin.nextInt();
			if(D+V==0)break;
			System.out.printf("%.3f\n",Math.pow((Math.PI*D*D*D-6*V)/Math.PI,1.0/3));
		}

	}
}

