import java.util.*;
public class Main
{
	public static void main(String [] args)
	{
		Scanner cin=new Scanner(System.in);
		int T=cin.nextInt();
		while(T--!=0)
		{
			int n=cin.nextInt();
			int r=(int)(Math.log10(2*Math.PI*n)+n*Math.log10(n)-n*Math.log10(Math.E));
			System.out.println(r);
		}
	}

	
}
