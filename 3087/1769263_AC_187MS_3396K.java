import java.util.Scanner;


public class Main
{

	public static void main(String[] args)
	{
		Scanner cin= new Scanner(System.in);
		int ts=cin.nextInt();
		for(int tsi=1;tsi<=ts;tsi++)
		{
			int n=cin.nextInt();
			String s1=cin.next();
			String s2=cin.next();
			String t=cin.next();
			String m1=s1,m2=s2;
			int re=0;
			boolean find=true;
			do
			{
				re++;
				String sf="";
				for(int i=0;i<n;i++)
				{
					sf+=s2.charAt(i)+""+s1.charAt(i);
				}
				if(sf.equals(t))
					break;
				s1=sf.substring(0,n);
				s2=sf.substring(n);
				if(s1.equals(m1)&&s2.equals(m2))
				{
					find=false;
					break;
				}
			}while(true);
			System.out.printf("%d %d\n", tsi,find==false?-1:re);
		}
	}
}
