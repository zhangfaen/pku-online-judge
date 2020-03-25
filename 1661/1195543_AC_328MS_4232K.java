import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Main
{
	static int MAX;
	static int [][] p;
	static int [][] map;
	static Plat [] lp;
	static int n;
	static int veryMax=Integer.MAX_VALUE/2;
	public static void main(String[] args) throws Exception
	{
		Scanner cin = new Scanner(System.in);
		int cs=cin.nextInt();
		while(cs--!=0)
		{
			n=cin.nextInt();
			int sx=cin.nextInt(),sh=cin.nextInt();
			MAX=cin.nextInt();
			map=new int[n][2];
			p=new int [n][2];
			for(int i=0;i<n;i++)
				p[i][0]=p[i][1]=map[i][0]=map[i][1]=-1;
			lp=new Plat[n+1];
			for(int i=0;i<n;i++)
			{
				int xl=cin.nextInt(),xr=cin.nextInt(),h=cin.nextInt();
				lp[i]=new Plat(xl,xr,h);
			}
			lp[n]=new Plat(-30000,30000,0);
			Arrays.sort(lp);
			for(int i=0;i<n;i++)
			{
				for(int j=i+1;j<n+1;j++)
				{
					if(lp[i].h-lp[j].h>MAX)
						break;
					if(isLeftOk(lp[i],lp[j]))
					{
						map[i][0]=j;
						break;
					}
				}
				for(int j=i+1;j<n+1;j++)
				{
					if(lp[i].h-lp[j].h>MAX)
						break;
					if(isRightOk(lp[i],lp[j]))
					{
						map[i][1]=j;
						break;
					}
				}
			}
			int sum=0;
			int start=-1;
			for(int i=0;i<lp.length;i++)
			{
				if(sh>=lp[i].h&&sx<=lp[i].xr&&sx>=lp[i].xl)
				{
					sum+=sh-lp[i].h;
					start=i;
					break;
				}
			}
			if(start==n)
				System.out.println(sum);
			else
			{
				int a1=Math.abs(sx-lp[start].xl);
				int a2=Math.abs(sx-lp[start].xr);
				int m1=get(start,0)+a1;
				int m2=get(start,1)+a2;
				int re=Math.min(m1,m2);
				System.out.println(re+sum);
			}
				
		}
	}
	public static int get(int k,int lr)
	{
		if(k==n)
			return 0;
		if(p[k][lr]!=-1)
			return p[k][lr];
		if(map[k][lr]==n)
			return lp[k].h;
		if(lr==0&&map[k][lr]!=-1)
		{
			int a1=Math.abs(lp[k].xl-lp[map[k][0]].xl)+lp[k].h-lp[map[k][0]].h;
			int a2=Math.abs(lp[k].xl-lp[map[k][0]].xr)+lp[k].h-lp[map[k][0]].h;
			int t1=Math.min(a1+get(map[k][0],0),a2+get(map[k][0],1));
			return p[k][lr]=t1;
		}
		if(lr==1&&map[k][lr]!=-1)
		{
			int a1=Math.abs(lp[k].xr-lp[map[k][1]].xl)+lp[k].h-lp[map[k][1]].h;
			int a2=Math.abs(lp[k].xr-lp[map[k][1]].xr)+lp[k].h-lp[map[k][1]].h;
			int t2=Math.min(a1+get(map[k][1],0),a2+get(map[k][1],1));
			return p[k][lr]=t2;
		}
		return p[k][lr]=veryMax;
	}
	public static boolean isLeftOk(Plat p1,Plat p2)
	{
		if(p1.xl>=p2.xl&&p1.xl<=p2.xr&&p1.h-p2.h<=MAX&&p1.h>p2.h)
			return true;
		return false;
	}
	public static boolean isRightOk(Plat p1,Plat p2)
	{
		if(p1.xr>=p2.xl&&p1.xr<=p2.xr&&p1.h-p2.h<=MAX&&p1.h>p2.h)
			return true;
		return false;
	}
	
}
class Plat implements Comparable<Plat>
{
	int xl,xr,h;
	public Plat(int a,int b,int hh)
	{
		xl=a;xr=b;h=hh;
	}
	public int compareTo(Plat o)
	{
		if(h<o.h)
			return 1;
		else
		if(h>o.h)
			return -1;
		else
			return 0;
	}
	
}



