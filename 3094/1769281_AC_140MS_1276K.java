import java.util.Scanner;


public class Main
{

	public static void main(String[] args)
	{
		Scanner cin= new Scanner(System.in);
		while(true)
		{
			String s=cin.nextLine();
			if(s.equals("#"))
				break;
			int re=0;
			for(int i=0;i<s.length();i++)
			{
				char c=s.charAt(i);
				if(c==' ')
					continue;
				re+=(i+1)*(c-'A'+1);
			}
			System.out.println(re);
		}
	}
}
