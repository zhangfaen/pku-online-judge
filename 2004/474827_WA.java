import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		ArrayList[] asp=new ArrayList[21];
		HashMap hmsi=new HashMap();
		HashMap hmss=new HashMap();
		for(int i=0;i<21;i++)
			asp[i]=new ArrayList();
		
		int rmax=0;
		String smax="";
		while(cin.hasNext())
		{
			String s=cin.next();
			int length=s.length();
			asp[length].add(s);
			if(length==1)
			{
				hmsi.put(s,Integer.valueOf(1));
				hmss.put(s,s);
				rmax=1;
				smax=s;
			}
		}
		
		for(int i=2;i<21;i++)
		{
			if(asp[i].size()>0)
			{
			//	System.out.println(i+"##"+asp[i].size());
				if(asp[i-1].size()==0)
				{
				//	System.out.println((i-1)+"$$"+asp[i-1].size());
					for(int j=0;j<asp[i].size();j++)
					{
						hmsi.put(asp[i].get(j),Integer.valueOf(1));
						hmss.put(asp[i].get(j),asp[i].get(j));
						if(1>rmax)
						{
							rmax=1;
							smax=(String)asp[i].get(j);
						}
					}
				}
				else
				{
					for(int j=0;j<asp[i].size();j++)
					{
						int tmax=0;
						String ts="";
						for(int k=0;k<asp[i-1].size();k++)
						{
							if(isOk(asp[i].get(j),asp[i-1].get(k))&&tmax<((Integer)hmsi.get(asp[i-1].get(k))).intValue())
							{
								tmax=((Integer)hmsi.get(asp[i-1].get(k))).intValue();
								ts=(String)asp[i-1].get(k);
							}
							if(tmax>rmax)
							{
								rmax=tmax;
								smax=(String)asp[i].get(j);
							}
						}
						hmsi.put(asp[i].get(j),tmax+1);
						hmss.put(asp[i].get(j),(String)hmss.get(ts)+"#"+(String)asp[i].get(j));
					}
				}
				
			}
		}
	//	System.out.println(hmsi);
	//	System.out.println(hmss);
	//	System.out.println(rmax);
		String rrs=(String)hmss.get(smax);
		rrs=rrs.replaceAll("^null","");
		String [] rras=rrs.split("#");
		for(int i=0;i<rras.length;i++)
			System.out.println(rras[i]);
		
	}
	private static boolean isOk(Object obig,Object osmall)
	{
		String big=(String)obig;
		String small=(String)osmall;
		for(int i=0;i<small.length();i++)
		{
			char c=small.charAt(i);
			if(big.indexOf(c+"")<0)
				return false;
		}
		return true;
	}
	
}

