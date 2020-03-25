import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Main
{

    static BufferedReader cin;
    static class E implements Comparable<E>
    {
	int x,y;
	int length;
	public E(int x, int y, int length)
	{
	    super();
	    this.x = x;
	    this.y = y;
	    this.length = length;
	}
	public int compareTo(E o)
	{
	    return length-o.length;
	}
	
    }
    public static void main(String[] args) throws IOException
    {
	cin = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	String s=cin.readLine();
	String [] sa=s.split(" ");
	int N=Integer.parseInt(sa[0]);
	int M=Integer.parseInt(sa[1]);
	E [] es=new E[M];
	for(int i=0;i<M;i++)
	{
	    s=cin.readLine();
	    sa=s.split(" ");
	    int x=Integer.parseInt(sa[0])-1;
	    int y=Integer.parseInt(sa[1])-1;
	    int len=Integer.parseInt(sa[2]);
	    es[i]=new E(x,y,len);
	}
	Arrays.sort(es);
	p=new int[N];
	rank=new int[N];
	Arrays.fill(p, -1);
	int left=N;
	for(int i=0;i<M;i++)
	{
	    int x=es[i].x;
	    int y=es[i].y;
	    int xf=find(x);
	    int yf=find(y);
	    if(xf!=yf)
	    {
		union(x,y);
		left--;
		if(left==1)
		{
		    out.println(es[i].length);
		    break;
		}
	    }
	}
	out.close();
    }
    static int [] p;
    static int [] rank;
    static int find(int x)
    {
	if(p[x]==-1)
	    return x;
	int xf=find(p[x]);
	p[x]=xf;
	return xf;
    }
    static void union(int x,int y)
    {
	int xf=find(x);
	int yf=find(y);
	if(rank[xf]<rank[yf])
	{
	    p[xf]=yf;
	    rank[yf]+=rank[xf];
	}
	else
	{
	    p[yf]=xf;
	    rank[xf]+=rank[yf];
	}
    }
    

}
