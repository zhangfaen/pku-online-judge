import java.util.*;
import java.io.*;
public class Main2501
{
	public static void main(String [] args)throws Exception
	{
		Scanner cin=new Scanner(new FileInputStream("c:\\in.txt"));
		double dis=0;
		int speed=-1;
		int hour=0,min=0,sec=0;
		while(cin.hasNextLine())
		{
			String s=cin.nextLine();
			String [] t=s.split(" |:");
			if(speed==-1)
			{
				if(t.length==4)
				{
					hour=Integer.parseInt(t[0]);
					min=Integer.parseInt(t[1]);
					sec=Integer.parseInt(t[2]);
					speed=Integer.parseInt(t[3]);
				}
			}
			else
				if(t.length==4)
				{
					int n_hour=Integer.parseInt(t[0]);
					int n_min=Integer.parseInt(t[1]);
					int n_sec=Integer.parseInt(t[2]);
					long inter=(n_hour-hour)*3600+(n_min-min)*60+n_sec-sec;
					dis+=speed*(inter/3600.0);
					hour=n_hour;
					min=n_min;
					sec=n_sec;
					speed=Integer.parseInt(t[3]);
				}
				else
				{
					int n_hour=Integer.parseInt(t[0]);
					int n_min=Integer.parseInt(t[1]);
					int n_sec=Integer.parseInt(t[2]);
					long inter=(n_hour-hour)*3600+(n_min-min)*60+n_sec-sec;
					dis+=speed*(inter/3600.0);
					hour=n_hour;
					min=n_min;
					sec=n_sec;
					System.out.print(t[0]+":"+t[1]+":"+t[2]+" ");
					System.out.printf("%.2f km\n",dis);
				}
				
			
		}
	}
}