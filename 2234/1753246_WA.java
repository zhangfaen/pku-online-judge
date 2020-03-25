import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader cin = new BufferedReader(
			new InputStreamReader(System.in));
		while (true)
		{
			String s=cin.readLine();
			if(s==null)
				break;
			String [] sa=s.split(" ");
			int [] p=new int[sa.length-1];
			for(int i=0;i<sa.length-1;i++)
				p[i]=Integer.parseInt(sa[i+1]);
			int xor=0;
			for(int d:p)
				xor^=d;
			if(xor==0)
				System.out.println("No");
			else
				System.out.println("Yes");
		}
	}
}
