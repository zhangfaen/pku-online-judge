import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt();
		while(n--!=0)
		{
			TreeSet<String>tst=new TreeSet<String>();
			String s=cin.next();
			permutation(s.toCharArray(),0,s.length(),tst);
			Iterator it=tst.iterator();
			while(it.hasNext())
				System.out.println(it.next());
			
		}
	}
	private static void permutation(char a[], int m, int n,TreeSet<String> tst) {   // 排列算法  
		int i;  
		char t;  
		if (m<n-1) { 
			permutation(a, m+1, n,tst); 
			for (i=m+1;i<n;i++) { 
				t=a[m]; 
				a[m]=a[i]; 
				a[i]=t;
				permutation(a, m+1, n,tst); 
				t=a[m]; 
				a[m]=a[i];
				a[i]=t; 
			}
		}
		else { 
			String s=new String(a);
			tst.add(s);
		} 
	} 

	
}
