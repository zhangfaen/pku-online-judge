import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.text.NumberFormat;
public class Main
{

	public static void main(String [] args)throws Exception
	{
		double e=0;
		System.out.println("n e");
		System.out.println("- -----------");
		long f=1;
		for(int i=0;i<=9;i++)
		{
			if(i==0)f=1;
			else
				f*=i;
			e+=1.0/f;
			NumberFormat fom=NumberFormat.getInstance();
			fom.setMaximumFractionDigits(9);
			System.out.printf("%d ",i);
			System.out.println(fom.format(e));
		}
	}
}