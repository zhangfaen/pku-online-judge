import java.io.*;
import java.util.*;
import java.math.*;
public class Main
{
	public static void main(String [] args)throws Exception 
	{
		HashMap<Character,Integer>hmci=new HashMap<Character,Integer>();
		hmci.put('A',2);hmci.put('B',2);hmci.put('C',2);
		hmci.put('D',3);hmci.put('E',3);hmci.put('F',3);hmci.put('G',4);
		hmci.put('H',4);hmci.put('I',4);hmci.put('J',5);hmci.put('K',5);
		hmci.put('L',5);hmci.put('M',6);hmci.put('N',6);hmci.put('O',6);
		hmci.put('P',7);hmci.put('R',7);hmci.put('S',7);hmci.put('T',8);
		hmci.put('U',8);hmci.put('V',8);hmci.put('W',9);hmci.put('X',9);
		hmci.put('Y',9);
		int n;
		TreeMap<String,Integer>hsi=new TreeMap<String,Integer>();
	//	Scanner cin=new Scanner(new File("c:\\fafa.txt"));
		Scanner cin=new Scanner(System.in);
		n=cin.nextInt();
		while(n-->0)
		{
			String s=cin.next();
			String t="";
			for(int i=0;i<s.length();i++)
			{
				if(Character.isDigit(s.charAt(i)))
					t+=s.charAt(i);
				else
					if(s.charAt(i)!='-')
					{
						t+=hmci.get(s.charAt(i));
					}
			}
			t=t.substring(0,3)+'-'+t.substring(3);
			if(hsi.containsKey(t))
				hsi.put(t,hsi.get(t)+1);
			else
				hsi.put(t,1);

		}
		Set<String> t=hsi.keySet();
		Collection<Integer> c=hsi.values();
		Iterator its=t.iterator();
		Iterator itc=c.iterator();
		for(;itc.hasNext();)
		{
			Integer sum=(Integer)itc.next();
			if(sum>1)
				System.out.println(its.next()+" "+sum);
			else			
				its.next();					
		}
		
	}
}