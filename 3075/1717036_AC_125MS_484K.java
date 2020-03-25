import java.io.*;
import java.util.*;
import java.math.*;
public class Main {

	static int pots=0,xs,ys;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		char [][] map=new char[3][3]; 
		while(true)
		{
			String s=in.readLine();
			if(s.equals("end"))
				break;
			xs=0;
			ys=0;
			pots = 0;
			for(int i=0;i<9;i++)
			{
				map[i/3][i%3]=s.charAt(i);
				if(s.charAt(i)=='X')
					xs++;
				if(s.charAt(i)=='O')
					ys++;
				if(s.charAt(i)=='.')
					pots++;
				
			}
			if(Math.abs(xs-ys)>1||xs<ys)
			{
				System.out.println("invalid");
				continue;
			}
			if(check(map))
			{
				System.out.println("valid");
				
			}
			else
			{
				System.out.println("invalid");
			}
		}
	}
	public static boolean check(char [][] map)
	{
		int xxs=0,oos=0;
		for(int i=0;i<3;i++)
		{
			String s="";
			String t="";
			for(int j=0;j<3;j++)
			{
				s+=map[i][j];
				t+=map[j][i];
			}
			if(s.equals("XXX")||t.equals("XXX"))
				xxs++;
			if(s.equals("OOO")||t.equals("OOO"))
				oos++;
	
		}
		String s="";
		String t="";
		for(int i=0;i<3;i++)
		{
			s+=map[i][i];
			t+=map[i][2-i];
		}
		if(s.equals("XXX")||t.equals("XXX"))
			xxs++;
		if(s.equals("OOO")||t.equals("OOO"))
			oos++;
		if(xxs+oos==0&&pots>0)
			return false;
		if(oos > 0 && xs > ys)
			return false;
		return xxs*oos==0;
	}
}


