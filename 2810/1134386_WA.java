import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Main
{
	public static void main(String [] args) throws FileNotFoundException
	{
		Scanner cin=new Scanner(System.in);
		List<String> re=new LinkedList<String>(); 
		while(true)
		{
			String line;
			while(true)
			{
				line=cin.nextLine();
				while(line.charAt(0)==' ')
					line=line.substring(1);
				if(line.length()>0)
					break;
			}
			double A,R;
			String U,V;
			int index=-1;
			index=line.indexOf(' ');
			A=get(line.substring(0,index));
			line=line.substring(index+1);
			
			index=line.indexOf(' ');
			U=line.substring(0,index);
			line=line.substring(index+1);
			
			index=line.indexOf(' ');
			R=get(line.substring(0,index));
			V=line.substring(index+1);
			
			if(A<0)
				break;
			char c='%';

			if((int)((A/R)*100)<1)
			{
				re.add(V);
			}
			else
			{
				System.out.printf("%s %.1f %s %d%c",V,(double)((int)(A*10))/10,U,(int)((A/R)*100),c);
				System.out.println();
			}
			
			
		}
		if(re.size()>0)
			System.out.println("Provides no significant amount of:");
		for(int i=0;i<re.size();i++)
			System.out.println(re.get(i));
	}
	public static double get(String t)
	{
		if(t.charAt(t.length()-1)=='.')
			t=t.substring(0,t.length()-1);
		if(t.charAt(0)=='.')
			t='0'+t;
		return Double.parseDouble(t);
	}
}
