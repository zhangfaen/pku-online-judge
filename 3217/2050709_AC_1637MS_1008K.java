import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class Main
{
	static class Person
	{
		public int id;
		public int sex;
		Person father, mother;
		public Person(int id, int sex)
		{
			this.id = id;
			this.sex=sex;
		}
		public List<Person> sons = new ArrayList<Person>();
		public List<Person> dauts = new ArrayList<Person>();
		public boolean equals(Object o)
		{
			Person n = (Person) o;
			return id == n.id;
		}
		public int hashCode()
		{
			return id;
		}
		public String toString()
		{
			return ""+id+" sex:"+sex;
		}
	}
	static Map<Integer, Person> all = new HashMap<Integer, Person>();
	static Map<Integer, String> childs = new HashMap<Integer, String>();
	public static void main(String[] args) throws Exception
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String s = cin.readLine();
		String[] sa = s.split(" ");
		int x = Integer.parseInt(sa[0]);
		int y = Integer.parseInt(sa[1]);
		while (true)
		{
			s = cin.readLine();
			if (s == null)
				break;
			s = s.trim();
			sa = s.split(" ");
			Person p = new Person(Integer.parseInt(sa[0]), Integer.parseInt(sa[sa.length - 1]));
			all.put(Integer.parseInt(sa[0]), p);
			if (sa.length > 2)
			{
				String t = s.substring(s.indexOf(' ') + 1, s.lastIndexOf(' '));
				childs.put(Integer.parseInt(sa[0]), t);
			}
		}
		for (Integer id : all.keySet())
		{
			String t = childs.get(id);
			if(t==null)continue;
			String[] ta = t.trim().split(" ");
			Person p = all.get(id);
			for (int i = 0; i < ta.length; i++)
			{
				Person cp = all.get(Integer.parseInt(ta[i]));
				if (p.sex == 0)
				{
					cp.father = p;
					if (cp.sex == 0)
						p.sons.add(cp);
					else
						p.dauts.add(cp);
				} else
				{
					cp.mother = p;
					if (cp.sex == 0)
						p.sons.add(cp);
					else
						p.dauts.add(cp);
				}
			}
		}
		Person xp = all.get(x);
		Person yp = all.get(y);
		if (xp.sex == yp.sex)
		{
			out.println("same");
		} else
		{
			Set<Person> xf = get3(xp, 1);
			Set<Person> yf = get3(yp, 1);
			for (Person p : xf)
			{
				if (yf.contains(p))
				{
					out.println("close");
					out.flush();
					return;
				}
			}
			out.println("marriage");
		}
		out.flush();
	}
	public static Set<Person> get3(Person p, int d)
	{
		Set<Person> re = new HashSet<Person>();
		if (d == 4)
			return re;
		re.add(p);
		if (p.father != null)
			re.addAll(get3(p.father, d + 1));
		if (p.mother != null)
			re.addAll(get3(p.mother, d + 1));
		return re;
	}
}