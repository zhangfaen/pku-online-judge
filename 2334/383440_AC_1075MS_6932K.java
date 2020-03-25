import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader stdin = 
            new BufferedReader(
                new InputStreamReader(System.in));
		int num=Integer.parseInt(stdin.readLine());
		String[]strArray=new String[num];
		for(int i=0;i<num;i++)
			strArray[i]=stdin.readLine();
		int sum=0;
		sum+=strArray[0].length();
		for(int i=1;i<num;i++)
		{
			int max=findMax(strArray[i-1],strArray[i]);
			sum+=strArray[i].length()-max+1;
		}
		System.out.println(sum);
		
	}
	public static int findMax(String s,String t)
	{
		int max=0;
		for(int i=0;i<s.length()&&i<t.length();i++)
		{
			if(s.charAt(i)==t.charAt(i))
				max++;
			else break;
		}
		return max;
	}

}