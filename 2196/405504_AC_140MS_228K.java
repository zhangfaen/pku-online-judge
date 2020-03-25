public class Main
{
	public static void main(String [] args)
	{
		for(int i=2992;i<10000;i++)
		{
			int a=fen(i,10);
			int b=fen(i,12);
			int c=fen(i,16);
			if(a==b&&a==c)
				System.out.println(i);
		}
	}
	public static int fen(int n,int base)
	{
		int sum=0;
		while(n>0)
		{
			sum+=n%base;
			n/=base;
		}
		return sum;
	}
}