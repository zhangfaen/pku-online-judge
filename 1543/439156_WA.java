import java.io.*;
import java.util.*;
public class Main
{

	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt();
		for(int u=2;u<=n;u++)
		for(int i=2;i<100;i++)
			for(int j=2;j<100;j++)
				for(int k=2;k<100;k++)
				{
					
					int t=i*i*i+j*j*j+k*k*k;
					
					if(t==u*u*u)
						System.out.println("Cube = "+u+", Triple = ("+i+","+j+","+k+")");
				}
		
	}
}