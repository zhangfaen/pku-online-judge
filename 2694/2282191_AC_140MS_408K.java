import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Main
{

    static BufferedReader cin = null;
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception
    {
	cin = new BufferedReader(new InputStreamReader(System.in));
	String s = cin.readLine();
	int n = Integer.parseInt(s);
	while (n-- > 0)
	{
	    s = cin.readLine();
	    String[] sa = s.split(" ");
	    int[] rank = new int[5];
	    char[] suit = new char[5];
	    for (int i = 0; i < sa.length; i++)
	    {
		suit[i] = sa[i].charAt(0);
		char r = sa[i].charAt(1);
		rank[i] = get(r);
	    }
	    for (int i = 0; i < 5; i++)
		for (int j = i + 1; j < 5; j++)
		{
		    if (rank[i] > rank[j])
		    {
			int t = rank[i];
			rank[i] = rank[j];
			rank[j] = t;
			char c = suit[i];
			suit[i] = suit[j];
			suit[j] = c;
		    }
		}
	    int res=0;
	    if(straightFlush(rank, suit))
		res=1000;
	    else if(fourOfKind(rank, suit))
		res=750;
	    else if(fullHouse(rank))
		res=500;
	    else if(flush(suit))
		res=350;
	    else if(straight(rank))
		res=250;
	    else if(threeOfKind(rank))
		res=200;
	    else if(twoPair(rank))
		res=100;
	    else if(onePair(rank))
		res=50;
	    else res=0;
	    System.out.println(res);
	    
	}
    }
    
    public static boolean straight5(int [] rank)
    {
	boolean ok=true;
	for(int i=0;i<4;i++)
	    if(rank[i]+1!=rank[i+1])ok=false;
	if(ok)return true;
	ok=true;
	for(int i=1;i<4;i++)
	    if(rank[i]+1!=rank[i+1])ok=false;
	if(ok&&rank[4]==13&&rank[0]==1)return true;
	return false;
    }
    public static boolean checksame(char [] suit)
    {
	for(int i=0;i<5;i++)
	    if(suit[i]!=suit[0])return false;
	return true;
    }
    public static boolean straightFlush(int [] rank,char [] suit)
    {
	if(straight5(rank)&&checksame(suit))
	    return true;
	return false;
    }
    public static boolean fourOfKind(int [] rank,char [] suit)
    {
	Map<Integer,Integer> mii=makeMap(rank);
	if(mii.size()!=2)
	    return false;
	for(int key:mii.keySet())
	    if(mii.get(key)==4)return true;
	return false;
	    
    }
    public static boolean fullHouse(int [] rank)
    {
	Map<Integer,Integer> mii=makeMap(rank);
	if(mii.size()!=2)
	    return false;
	return true;
    }
    public static boolean flush(char [] suit)
    {
	if(checksame(suit))return true;
	return false;
    }
    public static boolean straight(int [] rank)
    {
	return straight5(rank);
    }
    public static boolean threeOfKind(int [] rank)
    {
	Map<Integer,Integer> mii=makeMap(rank);
	if(mii.size()!=3)
	    return false;
	for(int key:mii.keySet())
	    if(mii.get(key)==3)return true;
	return false;
    }
    public static boolean twoPair(int [] rank)
    {
	Map<Integer,Integer> mii=makeMap(rank);
	if(mii.size()!=3)
	    return false;
	int cnt=0;
	for(int key:mii.keySet())
	    if(mii.get(key)==2)cnt++;
	if(cnt==2)return true;
	return false;
    }
    public static boolean onePair(int [] rank)
    {
	Map<Integer,Integer> mii=makeMap(rank);
	if(mii.size()!=4)
	    return false;
	int cnt=0;
	for(int key:mii.keySet())
	    if(mii.get(key)==2)cnt++;
	if(cnt==1)return true;
	return false;
    }
    public static Map<Integer,Integer>makeMap(int [] rank)
    {
	Map<Integer,Integer>re=new HashMap<Integer,Integer>();
	for(int d:rank)
	{
	    if(re.containsKey(d)==false)
		re.put(d, 1);
	    else re.put(d, re.get(d)+1);
	}
	return re;
    }
    public static int get(char r)
    {
	if (r >= '2' && r <= '9')
	    return r - '0';
	if (r == 'A')
	    return 1;
	if(r=='X')
	    return 10;
	if (r == 'J')
	    return 11;
	if (r == 'Q')
	    return 12;
	if (r == 'K')
	    return 13;
	return -1;
    }
}
