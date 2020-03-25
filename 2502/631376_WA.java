import java.util.*;
import java.io.*;
import java.math.*;
public class Main
{
	public static void main(String [] args) throws Exception
	{
		Scanner cin=new Scanner(System.in);
		ArrayList<Stop> stops=new ArrayList<Stop>();
		int num=-2;
		int total=0;
		stops.add(new Stop(cin.nextInt(),cin.nextInt(),num++));
		stops.add(new Stop(cin.nextInt(),cin.nextInt(),num++));
		total+=2;
		while(cin.hasNextInt())
		{
			int x=cin.nextInt(),y=cin.nextInt();
			if(x==-1&&y==-1)
				num++;
			else
			{
				stops.add(new Stop(x,y,num));
				total++;
			}
		}
		
		double [][] map=new double[total][total];
		
		for(int i=0;i<total-1;i++)
		{
			for(int j=i+1;j<total;j++)
			{
				map[j][i]=map[i][j]=f(stops.get(i),stops.get(j));
				
			}
			
		}
	/*	for(int i=0;i<total;i++)
		{
			for(int j=0;j<total;j++)
				System.out.print(map[i][j]+"  ");
			System.out.println();
		}*/
			
		LinkedList<Integer> V=new LinkedList<Integer>();
		V.add(0);
		LinkedList<Integer> S=new LinkedList<Integer>();
		for(int i=1;i<total;i++)
			S.add(i);
		while(true)
		{
			double min=Double.MAX_VALUE;
			int min_num=-1;
			for(int i=0;i<V.size();i++)
			{
				for(int j=0;j<S.size();j++)
				{
					if(min>=map[0][V.get(i)]+map[V.get(i)][S.get(j)])
					{
						min=map[0][V.get(i)]+map[V.get(i)][S.get(j)];
						min_num=S.get(j);
					}
				}
			}
		//	System.out.println(min_num);
			if(min_num==1)
			{
				System.out.println(Math.round((min/1000/40)*60));
				break;
			}
			V.add(min_num);
			S.remove(new Integer(min_num));
			map[0][min_num]=min;

		}			
		
	}
	public static double f(Stop s,Stop t)
	{
		int x1, y1;
		int x2, y2;
		boolean isTheSame;
		x1=s.x;
		y1=s.y;
		x2=t.x;
		y2=t.y;
		isTheSame=(s.subway==t.subway?true:false);
		if(isTheSame)
		{
			return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
		}
		else
		{
			return 4*Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
		}
	}
	

}

class Stop
{
	int x;
	int y;
	int subway;
	public Stop(int x,int y,int subway)
	{
		this.x=x;
		this.y=y;
		this.subway=subway;
	}
}