import java.io.*;
import java.util.*;
public class Main
{

	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		TreeSet<String>ts=new TreeSet<String>();
		int n=cin.nextInt();
		for(int u=2;u<=n;u++)
		for(int i=2;i<100;i++)
			for(int j=2;j<100;j++)
				for(int k=2;k<100;k++)
				{
					
					int t=i*i*i+j*j*j+k*k*k;
					
					if(t==u*u*u)
					{
						int a[]=new int[3];
						a[1]=i;a[0]=j;a[2]=k;
						Arrays.sort(a);
						ts.add("Cube = "+u+", Triple = ("+a[0]+","+a[1]+","+a[2]+")");
						
					}
						
				}
		Iterator<String>it=ts.iterator();
		while(it.hasNext())
			System.out.println(it.next());
		
	}
}