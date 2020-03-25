import java.util.Scanner;


public class Main
{
	static int [][][] memo=new int[105][13][32]; 
	static int [] canl={1,1,1};
	public static void main(String [] args)
	{
		Scanner cin=new Scanner(System.in);
		int ts=cin.nextInt();
		while(ts-->0)
		{
			int year=cin.nextInt();
			int mon=cin.nextInt();
			int date=cin.nextInt();
			for(int i=0;i<105;i++)
				for(int j=0;j<13;j++)
					for(int k=0;k<32;k++)
						memo[i][j][k]=0;
			memo[101][11][4]=-1;
			year-=1900;
			for(int i=101;i>=year;i-=10)
				dp(i,1,1);
			int d=dp(year,mon,date);
			//if(year)
			if(d==1)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
	public static int dp(int year,int mon,int date)
	{
		if(memo[year][mon][date]!=0)
			return memo[year][mon][date];
		nextDate(year,mon,date);
		if(canl[0]<101||canl[0]==101&&canl[1]<11||canl[0]==101&&canl[1]==11&&canl[2]<=4)
		{
			int d=dp(canl[0],canl[1],canl[2]);
			if(d==-1)
				return memo[year][mon][date]=1;
		}
		if(nextMon(year,mon,date))
		{
			if(canl[0]<101||canl[0]==101&&canl[1]<11||canl[0]==101&&canl[1]==11&&canl[2]<=4)
			{
				int d=dp(canl[0],canl[1],canl[2]);
				if(d==-1)
					return memo[year][mon][date]=1;
			}
		}
		return -1;
		
	}
	public static void nextDate(int year,int mon,int date)
	{
		if(date<=27)
		{
			canl[0]=year;canl[1]=mon;canl[2]=date+1;
		}
		else
		{
			if(isLeap(year)&&mon==2)
			{
				canl[0]=year;canl[1]=mon+1;canl[2]=1;
			}
			else
			{
				if(chkMD(mon,date+1))
				{
					canl[0]=year;canl[1]=mon;canl[2]=date+1;
				}
				else
				{
					canl[0]=year;canl[1]=mon+1;canl[2]=1;
					if(mon+1==13)
					{
						canl[0]++;
						canl[1]=1;
					}
				}
			}
		}
	}
	
	public static boolean nextMon(int year,int mon,int date)
	{
		if(mon==12)
		{
			canl[0]=year+1;canl[1]=1;canl[2]=date;
			return true;
		}
		else
		{
			if(chkMD(mon+1,date)==false)
				return false;
			else
			{
				canl[0]=year;canl[1]=mon+1;canl[2]=date;
				return true;
			}
		}
	}
	public static boolean chkMD(int mon,int date)
	{
		if(mon==1||mon==3||mon==5||mon==7||mon==8||mon==10||mon==12)
			if(date<=31)return true;
			else return false;
		if(mon==4||mon==6||mon==9||mon==11)
			if(date<=30)return true;
			else return false;
		if(mon==2)
			if(date<=29)return true;
			else return false;
		return false;
	}
	public static boolean isLeap(int year)
	{
		year+=1900;
		if(year%400==0)
			return true;
		if(year%100==0)
			return false;
		return year%4==0;
	}
}
