import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main1
{
	public static void main(String [] args) throws FileNotFoundException
	{
		Scanner cin=new Scanner(System.in);
		while(true)
		{
			int n=cin.nextInt();
			if(n<3)
				break;
			double [] x=new double[n];
			double [] y=new double[n];
			for(int i=0;i<n;i++)
			{
				x[i]=cin.nextDouble();
				y[i]=cin.nextDouble();
			}
			double V=cin.nextDouble();
			double area=0;
			for(int i=0;i<n;i++)
			{
				area+=x[i]*y[(i+1)%n];
				area-=x[(i+1)%n]*y[i];
			}
			area=Math.abs(area)/2;
			System.out.printf("BAR LENGTH: %.2f\n",V/area);
		}
	}
}
