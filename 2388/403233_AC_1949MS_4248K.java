import java.io.*;
import java.util.*;
import java.math.*;
public class Main
{
	public static void main(String args[]) throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		int N=cin.nextInt();
		int []a=new int[N];
		for(int i=0;i<N;i++)
			a[i]=cin.nextInt();
		Arrays.sort(a);
		System.out.println(a[N/2]);
	
	}
}
