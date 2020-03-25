import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main
{
	static String re="";
	static int min;
	static int [] q=new int[4];
	static int [] p={25,10,5,1};
	public static void main(String [] args) throws FileNotFoundException
	{
		Scanner cin=new Scanner(System.in);
		while(true)
		{
			for(int i=0;i<4;i++)
				q[i]=cin.nextInt();
			int call=cin.nextInt();
			if(q[0]+q[1]+q[2]+q[3]+call==0)
				break;
			re="";
			min=Integer.MAX_VALUE;
			f(0,0,call,"");
			if(min>10000)
			{
				System.out.println("Cannot dispense the desired amount.");
			}
			else
			{
				re=re.trim();
				String [] res=re.split(" ");
				System.out.printf("Dispense %s quarters, %s dimes, %s nickels, and %s pennies.\n",res[0],res[1],res[2],res[3]);
			}
			
		}
	}
	public static void f(int d,int num,int left,String s)
	{
		if(d==3)
		{
			if(left<=q[d]&&num+left<min)
			{
				min=num+left;
				re=s+" "+left;
			}
			return;
		}
		for(int i=0;i<=q[d];i++)
		{
			if(left>=i*p[d])
			{
				f(d+1,num+i,left-i*p[d],s+" "+i);
			}
			else
				break;
		}
	}
}
