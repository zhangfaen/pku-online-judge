import java.util.*;
import java.io.*;
public class Main

{
	public static void main(String [] args)
	{
		Scanner cin=new Scanner(System.in);
		while(true)
		{
			int N=cin.nextInt();
			int M=cin.nextInt();
			int P=cin.nextInt();
			int C=cin.nextInt();
			if(N+M+P+C==0)
				break;
			int sum=0;
			System.out.println(0-(M-N-P));
		}
	}
}