import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		Scanner cin=new Scanner(System.in);
		double dis=0;
		int speed=-1;
		int hour=0,min=0,sec=0;
		String s=cin.nextLine();
		String [] t=s.split(" |:");
		hour=Integer.parseInt(t[0]);
		min=Integer.parseInt(t[1]);
		sec=Integer.parseInt(t[2]);
		if(t.length==4)
		{
			speed=Integer.parseInt(t[3]);
		}
		else 
		{
			speed=0;
			System.out.println(s+" 0.00 km");
		}
		while(cin.hasNextLine())
		{
			s=cin.nextLine();
			t=s.split(" |:");
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
					System.out.print(s+" ");
					long tt=(long)(dis*1000);
					if(tt%10>=5)
						tt+=10; 
					tt/=10;
					dis=(double)tt/100.0;
					System.out.printf("%.2f km\n",dis);
				}
				
			
		}
	}
}