import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args) throws Exception
	{
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt();
		while(n--!=0)
		{
			int m=cin.nextInt();
			int sum=0;
			for(int i=0;i<m;i++)
			{
				sum+=cin.nextInt();
				
			}
			sum++;
			sum-=m;
			System.out.println(sum);
		}
		
	}
}