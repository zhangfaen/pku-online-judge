import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		StringBuffer ss=new StringBuffer(cin.next());
		StringBuffer tt=new StringBuffer(cin.next());
		for(int i=0;i<26;i++)
		{
			StringBuffer s=new StringBuffer(ss.toString());
			StringBuffer t=tt;
			for(int j=0;j<t.length();j++)
			{
				char c=t.charAt(j)+i>'Z'?(char)(t.charAt(j)+i-26):(char)(t.charAt(j)+i);
				int index=-1;
				if((index=s.indexOf(""+c))>=0)
					s.deleteCharAt(index);
			}
			if(s.length()==0)
			{
				System.out.println("YES");
				return;
			}
		}
		
		System.out.println("NO");
	
			
	}
	

	
}
