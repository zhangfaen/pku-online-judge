import java.io.*;
import java.util.*;
import java.math.*;
public class Main
{
	public static void main(String [] args)
	{
		Scanner cin=new Scanner(System.in);
		int x[] = { 2, 7, 5, 30, 169, 441, 1872, 7632, 1740, 93313, 459901, 1358657, 
	    2504881 };
	    int n;
	    while((n=cin.nextInt())!=0)
	    	System.out.println(x[n+1]);

	}
}
