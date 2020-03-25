import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		while(true)
		{
			int n=cin.nextInt();
			if(n==-1)break;
			int ptime=0;
			int qtime=0;
			int sum=0;
			while(n--!=0)
			{
				int speed=cin.nextInt();
				qtime=cin.nextInt();
				sum+=speed*(qtime-ptime);
				ptime=qtime;
			}
			System.out.println(sum+" miles");
		}
	}
}
