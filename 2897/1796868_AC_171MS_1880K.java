import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner cin = new Scanner(System.in);
		int ts = cin.nextInt();
		while (ts-- > 0)
		{
			int n = cin.nextInt();
			int k = cin.nextInt();
			String re = "";
			int cj = 0;
			int cd = k;
			boolean [] vst=new boolean[100];
			boolean find=true;
			do
			{
				int next = cd * n + cj;
				if(next==k)
					break;
				cj = next / 10;
				next %= 10;
				cd = next;
				re = next + re;
				if(re.length()>1000)break;
			} while (true);
			if (re.length()>1000||re.length()>0&&re.charAt(0)=='0')
				System.out.println(0);
			else
				System.out.println(re + k);
		}
	}
}
