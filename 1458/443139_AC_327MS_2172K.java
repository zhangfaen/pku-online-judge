import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext())
		{
			String s=cin.next();
			String t=cin.next();
			s='1'+s;
			t='0'+t;
			int p[][]=new int[s.length()][t.length()];
			for(int i=1;i<s.length();i++)
				for(int j=1;j<t.length();j++)
				{
					if(s.charAt(i)==t.charAt(j))
						p[i][j]=1+p[i-1][j-1];
					else
						p[i][j]=Math.max(p[i][j-1],p[i-1][j]);
				}
			System.out.println(p[s.length()-1][t.length()-1]);
		}
	}

	
}
