import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args) throws Exception
	{
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt();
		cin.nextLine();
		HashMap<String,String> nameParty=new HashMap<String,String>();
		HashMap<String,Integer> nameNum=new HashMap<String,Integer>();
		for(int i=0;i<n;i++)
		{
			String name=cin.nextLine();
			String party=cin.nextLine();
			nameParty.put(name,party);
			nameNum.put(name,0);
		}
		int m=cin.nextInt();
		cin.nextLine();
		for(int i=0;i<m;i++)
		{
			String name=cin.nextLine();
			if(nameNum.containsKey(name))
			{
				nameNum.put(name,nameNum.get(name)+1);
			}
		}
		Set<String> keySet=nameNum.keySet();
		int fmax=-1;
		int smax=-2;
		String winName="";
		for(Iterator it=keySet.iterator();it.hasNext();)
		{
			String name=(String)it.next();
			if(nameNum.get(name)>=fmax)
			{
				smax=fmax;
				fmax=nameNum.get(name);
				winName=name;
					
			}
		}
		if(smax==fmax)
		{
			System.out.println("tie");
		}
		else
		{
			System.out.println(nameParty.get(winName));
		}
	}
}