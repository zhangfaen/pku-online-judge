import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		while(true)
		{
			int n=cin.nextInt();
			if(n==0)break;
			ArrayList<Card>cards=new ArrayList<Card>();
			while(n--!=0)
			{
				int a=cin.nextInt();
				int b=cin.nextInt();
				cards.add(new Card(a,b));
			}
			cards.add(new Card(-1,-1));
			Collections.sort(cards);
			int sum=0;
			for(int i=1;i<cards.size();i++)
			{
				if(cards.get(i).left>=cards.get(i-1).left&&cards.get(i).right>=cards.get(i-1).right)
					sum++;
			}
			System.out.println(sum);
			
		}
		System.out.println("*");

	}

}
class Card implements java.lang.Comparable
{
	public int left;
	public int right;
	public Card(int a,int b)
	{
		left=a;
		right=b;
	}
	public int compareTo(Object o)
	{
		Card t=(Card)o;
		if(left<t.left)
			return -1;
		if(left>t.left)
			return 1;
		if(right<t.right)
			return -1;
		if(right>t.right)
			return 1;
		return 0;
	}
}