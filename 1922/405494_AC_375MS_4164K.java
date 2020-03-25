import java.util.*;
import java.io.*;
import java.math.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		while(true)
		{
			int n=cin.nextInt();
			if(n==0)break;
			int min=Integer.MAX_VALUE;
			while(n--!=0)
			{
				int speed=cin.nextInt();
				int time=cin.nextInt();
				if(time>=0)
				{
					int end=(int)(4.5/speed*36000);
					if(end%10>0)end+=10;
					end/=10;
					end+=time;
					if(end<min)min=end;
				}		
			}
			System.out.println(min);

		}
	}
}