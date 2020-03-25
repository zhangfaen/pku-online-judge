import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args)throws Exception
{
		Scanner cin=new Scanner(System.in);
		int testcase=cin.nextInt();
		for(int i=1;i<=testcase;i++)
		{
			int n=cin.nextInt();
			LinkedList<DataItem> ld=new LinkedList<DataItem>();
			while(n--!=0)
				ld.add(new DataItem(cin.next(),cin.next(),cin.nextInt()));			
			ArrayList<Person> result=new ArrayList<Person>();
			LinkedList<Person> queue=new LinkedList<Person>();
			queue.addLast(new Person("Ted",100));
			while(queue.size()>0)
			{
				Person fp=queue.removeFirst();
				result.add(fp);
				for(int j=0;j<ld.size();j++)
				{
					if(fp.name.equals(ld.get(j).fname))
					{
						queue.add(new Person(ld.get(j).cname,fp.age-ld.get(j).fage));
					}
				}
			}
			result.remove(0);
			Collections.sort(result);
			System.out.println("DATASET "+i);
			for(int j=0;j<result.size();j++)
				System.out.println(result.get(j));
		}
	}
	
}
class DataItem
{
	public String fname;
	public String cname;
	public int fage;
	public DataItem(String s,String t,int a)
	{
		fname=s;
		cname=t;
		fage=a;	
	}

}
class Person implements Comparable
{
	public String name;
	public int age;
	public Person(String s,int a)
	{
		name=s;
		age=a;
	}
	public String toString()
	{
		return name+" "+age;
	}
	public int compareTo(Object o)
	{
		Person t=(Person)o;
		if(age>t.age)
			return -1;
		if(age<t.age)
			return 1;
		return name.compareTo(t.name);
	}
}

