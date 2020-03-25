import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args)
	{
		Scanner cin=new Scanner(System.in);
		while(true)
		{
			int n=cin.nextInt();
			if(n==0)break;
			int num=0;
			String s=Integer.toBinaryString(n);
			StringBuffer sb=new StringBuffer("0"+s);
			int i;
			for(i=sb.length()-1;i>=0;i--)
				if(sb.charAt(i)=='0');
				else break;
			for(;i>=0;i--)
				if(sb.charAt(i)=='1')num++;
				else break;
			sb.setCharAt(i,'1');
			sb.setCharAt(i+1,'0');
			for(int j=i+1;j<sb.length();j++)
				sb.setCharAt(j,'0');
			for(int j=sb.length()-1;num>1;num--,j--)
				sb.setCharAt(j,'1');
			int tt=Integer.parseInt(sb.toString(),2);
			System.out.println(tt);
		}
	}
}