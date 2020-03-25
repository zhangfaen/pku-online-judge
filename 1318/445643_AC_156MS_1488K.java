import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		HashSet<String>hs=new HashSet<String>();
		while(true)
		{
			String s=cin.next();
			if(s.equals("XXXXXX"))break;
			hs.add(s);
			
		}
		while(true)
		{
			String t=cin.next();
			if(t.equals("XXXXXX"))break;
			TreeSet<String>tst=new TreeSet<String>();
			permutation(t.toCharArray(),0,t.length(),tst,hs);
			if(tst.size()==0)
				System.out.println("NOT A VALID WORD");
			Iterator it=tst.iterator();
			while(it.hasNext())
				System.out.println(it.next());
			System.out.println("******");
			
		}
	}
	private static void permutation(char a[], int m, int n,TreeSet<String> tst,HashSet<String> hs) {   // 排列算法  
		int i;  
		char t;  
		if (m<n-1) { 
			permutation(a, m+1, n,tst,hs); 
			for (i=m+1;i<n;i++) { 
				t=a[m]; 
				a[m]=a[i]; 
				a[i]=t;
				permutation(a, m+1, n,tst,hs); 
				t=a[m]; 
				a[m]=a[i];
				a[i]=t; 
			}
		}
		else { 
			String s=new String(a);
			if(hs.contains(s))
				tst.add(s);
		} 
	} 

	
}
