import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		while(true)
		{
			String s=cin.next();
			if(s.equals("THEEND"))break;
			String t=cin.next();
			int col=s.length();
			int row=t.length()/s.length();
			char p[][]=new char[row][col];
			int from=0;
			for(char c='A';c<='Z';c++)
			{
				for(int j=0;j<s.length();j++)
				{
					if(s.charAt(j)==c)
					{
						for(int k=0;k<row;k++)
						{
							p[k][j]=t.charAt(from++);
						}
					}
				}
				
			}
			for(int i=0;i<row;i++)
				for(int j=0;j<col;j++)
					System.out.print(p[i][j]);
			System.out.println();
		}
	}	
}