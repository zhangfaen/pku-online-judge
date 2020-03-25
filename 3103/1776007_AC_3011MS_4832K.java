import java.io.*;
import java.util.*;
import java.math.*;
import java.util.Scanner;
public class Main
{
	public static void main(String[] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		while(in.hasNextInt())
		{
			int x=in.nextInt(),y=in.nextInt(),z=in.nextInt(),n=in.nextInt();
			double fac=1.0*z/n;
			for(int i=1;i<=n;i++)
			{
				double lx=0,ly=0,lz=(i-1)*fac;
				double ux=x,uy=y,uz=i*fac;
				System.out.printf("%.8f %.8f %.8f %.8f %.8f %.8f\n", lx,ly,lz,ux,uy,uz);
			}
	
		}
	}
}
