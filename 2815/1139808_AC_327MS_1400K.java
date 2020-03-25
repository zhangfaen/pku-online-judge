import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Main
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner cin = new Scanner(System.in);
		while (true)
		{
			int target = cin.nextInt();
			String[] time = cin.next().split(":");
			if (target < 0)
				break;
			int totalsec = Integer.parseInt(time[0]) * 3600
				+ Integer.parseInt(time[1]) * 60 + Integer.parseInt(time[2]);
			totalsec = totalsec % 86400;
			double cangle = f(totalsec);
			int res = -1;
			int needsec = -1;
			if(cangle <= target){
				needsec = (int)((target - cangle) / (11 / 120.0));
				res = (needsec + totalsec) % 86400;
			}
			else{
				needsec = (int)((360.0 - cangle + target) / (11 / 120.0));
				res = (needsec + totalsec) % 86400;
			}
			System.out.println(get(res));
		}
	}
	public static String get(int sec){
		int h = sec / 3600;
		sec = sec % 3600;
		int m = sec / 60;
		sec = sec % 60;
		String hh = "";
		String mm = "";
		String ss = "";
		if(h < 10)
			hh = "" + '0' + h;
		else
			hh = "" + h;
		if(m < 10)
			mm = "" + '0' + m;
		else
			mm = "" + m;
		if(sec < 10)
			ss = "" + '0' + sec;
		else
			ss = "" + sec;
		return hh + ":" + mm + ":" + ss;
	}
	public static double f(int sec){
		sec = sec % 43200;
		double ha = sec / 120.0;
		sec = sec % 3600;
		double ma = sec / 10.0;
		if(ma >= ha)
			return ma - ha;
		else
			return 360.0 + ma - ha;
	}
}
