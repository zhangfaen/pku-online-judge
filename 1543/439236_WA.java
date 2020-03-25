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
		Object [] o=ts.toArray();
		Arrays.sort(o,new Comparator()
			{
				public int compare(Object a,Object b)
				{
					String c=(String)a;
					String d=(String)b;
					String t="";
					for(int i=7;i<c.length();i++)
						if(c.charAt(i)!=',')t+=c.charAt(i);
						else break;
					c=t;
					t="";
					for(int i=7;i<d.length();i++)
						if(d.charAt(i)!=',')t+=d.charAt(i);
						else break;
					d=t;
					int e=Integer.parseInt(c);
					int f=Integer.parseInt(d);
					if(e<f)return -1;
					if(e==f)return 0;
					return 1;
				}
			});
		for(int i=0;i<o.length;i++)
			System.out.println(o[i]);
	
		
	}
}