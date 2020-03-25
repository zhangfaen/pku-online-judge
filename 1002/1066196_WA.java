
import java.io.File;
import java.util.Scanner;
public class Main
{
	public static void main(String [] args) throws Exception
	{
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt();
		Node root=new Node();
		for(int i=0;i<n;i++)
		{
			String s=getf(cin.next());
			insert(s,s,root);
		}
		print(root);
	}
	public static void print(Node t)
	{
		if(t==null) return;
		if(t.num>1)
		{
			System.out.println(t.s.substring(0,3)+"-"+t.s.substring(3)+" "+t.num);
			return;
		}
		for(int i=0;i<t.childr.length;i++)
			print(t.childr[i]);
	}
	public static void insert(String sc,String s,Node t)
	{
		if(s.length()==0)
		{
			t.num++;
			t.s=sc;
			return;
		}
		char c=s.charAt(0);
		if(t.childr[c-'0']==null) t.childr[c-'0']=new Node();
		insert(sc,s.substring(1),t.childr[c-'0']);
	}
	public static String getf(String s)
	{
		String re="";
		for(int i=0;i<s.length();i++)
		{
			char c=s.charAt(i);
			if(Character.isDigit(c)) re+=c;
			else if(c=='A'||c=='B'||c=='C') re+='2';
			else if(c=='D'||c=='E'||c=='F') re+='3';
			else if(c=='G'||c=='H'||c=='I') re+='4';
			else if(c=='J'||c=='K'||c=='L') re+='5';
			else if(c=='M'||c=='N'||c=='O') re+='6';
			else if(c=='P'||c=='R'||c=='S') re+='7';
			else if(c=='T'||c=='U'||c=='V') re+='8';
			if(c=='W'||c=='X'||c=='Y') re+='9';
		}
		return re;
	}
}

class Node
{
	int num;
	String s;
	Node [] childr=new Node[10];
}
