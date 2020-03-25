import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		HashMap<Character,Integer>hmc=new HashMap<Character,Integer>();
		hmc.put('A',2);hmc.put('B',2);hmc.put('C',2);hmc.put('D',3);hmc.put('E',3);hmc.put('F',3);
		hmc.put('H',4);hmc.put('I',4);hmc.put('G',4);hmc.put('J',5);hmc.put('K',5);hmc.put('L',5);
		hmc.put('M',6);hmc.put('N',6);hmc.put('O',6);hmc.put('P',7);hmc.put('R',7);hmc.put('S',7);
		hmc.put('T',8);hmc.put('U',8);hmc.put('V',8);hmc.put('W',9);hmc.put('X',9);hmc.put('Y',9);
		
		HashMap<String,Integer>hms=new HashMap<String,Integer>();
		int n=cin.nextInt();
		cin.nextLine();
		while(n--!=0)
		{
			String s=cin.nextLine();
			String t="";
			for(int i=0;i<s.length();i++)
			{
				if(Character.isDigit(s.charAt(i)))
					t+=s.charAt(i);
				else
					if(s.charAt(i)>='A'&&s.charAt(i)<='Z')
						t+=hmc.get(s.charAt(i));
			}
			t=t.substring(0,3)+"-"+t.substring(3,t.length());
			if(hms.containsKey(t))
			{
				hms.put(t,hms.get(t)+1);
			}
			else
				hms.put(t,1);
		}
		Set<String>ss=hms.keySet();
		LinkedList<String> ll=new LinkedList<String>();
		Iterator<String> it=ss.iterator();
		while(it.hasNext())
		{
			String s=it.next();
			if(hms.get(s)>1)
				ll.add(s);
			
		}
		Collections.sort(ll);
		for(int i=0;i<ll.size();i++)
		{
			System.out.println(ll.get(i)+" "+hms.get(ll.get(i)));
		}
	}
}