import java.io.*;
import java.util.*;
import java.math.*;

public class Main
{
	
	static BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter out = new PrintWriter(System.out);
	

	public static void main(String[] args) throws IOException
	{
		String s=cin.readLine();
		String [] sa=s.split(" ");
		double v=Double.parseDouble(sa[0]);
		double r=Double.parseDouble(sa[1]);
		double c=Double.parseDouble(sa[2]);
		int n=Integer.parseInt(sa[3]);
		for(int i=0;i<n;i++)
		{
			s=cin.readLine();
			double w=Double.parseDouble(s);
			double vr=v/Math.sqrt(r*r+1/(w*w*c*c))*r;
			System.out.printf("%.3f\n", vr);
		}
	}
	
}