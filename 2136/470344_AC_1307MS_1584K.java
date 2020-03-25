import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{	
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		int []p=new int[26];
		while(cin.hasNext())
		{
			String s=cin.next();
			for(int i=0;i<s.length();i++)
				if(s.charAt(i)>='A'&&s.charAt(i)<='Z')
					p[s.charAt(i)-'A']++;
		}
		int max=0;
		for(int i=0;i<26;i++)
			if(p[i]>max)
				max=p[i];
		String [] rs= new String[max+1];
		for(int i=0;i<max+1;i++)
			rs[i]="";
		for(int j=0;j<max;j++)
			for(int i=0;i<26;i++)
			{
				//if(p[i]>0)
			//	{
					if(p[i]>=max-j)
					{
						rs[j]+='*';
					}
					else
						rs[j]+=' ';
			//	}
			}
		for(int i=0;i<=max;i++)
		{
			rs[i]=rs[i].replaceAll(" *$","");
		}
		for(int i=0;i<26;i++)
		{
			//if(p[i]>0)
				rs[max]+=(char)('A'+i);
		}
		for(int i=0;i<=max;i++)
		{
			for(int j=0;j<rs[i].length();j++)
			{
				if(j==0)
				{
					System.out.print(rs[i].charAt(j));
				}
				else
				{
					System.out.print(" "+rs[i].charAt(j));
				}
			}
			System.out.println();	
		}
			
		
	} 

	
}
