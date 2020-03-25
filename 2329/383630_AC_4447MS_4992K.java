import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String args[]) throws Exception
	{
		Scanner cin=new Scanner(System.in);
		int N=cin.nextInt();
		int a[][]=new int[N][N];
		int b[][]=new int[N][N];
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				b[i][j]=a[i][j]=cin.nextInt();
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
			{
				if(a[i][j]==0)
				{
				for(int dis=1;dis<2*N-1;dis++)
					{
						int sum=0;
						for(int x=0;x<=dis;x++)
						{
							int p1=i+x;
							int p2=i-x;
							int q1=j+dis-x;
							int q2=j-dis+x;
							if(p1!=p2&&q1!=q2)
							{
							
								if(p1>=0&&p1<N&&q1>=0&&q1<N)
									if(a[p1][q1]!=0)
									{
										b[i][j]=a[p1][q1];
										sum++;
									}
								if(p2>=0&&p2<N&&q2>=0&&q2<N)
									if(a[p2][q2]!=0)
									{
										b[i][j]=a[p2][q2];
										sum++;
									}
								if(p1>=0&&p1<N&&q2>=0&&q2<N)
									if(a[p1][q2]!=0)
									{
										b[i][j]=a[p1][q2];
										sum++;
									}
								if(p2>=0&&p2<N&&q1>=0&&q1<N)
									if(a[p2][q1]!=0)
									{
										b[i][j]=a[p2][q1];
										sum++;
									}
							}
							if(p1!=p2&&q1==q2)
							{
								if(p1>=0&&p1<N&&q1>=0&&q1<N)
									if(a[p1][q1]!=0)
									{
										b[i][j]=a[p1][q1];
										sum++;
									}
								if(p2>=0&&p2<N&&q2>=0&&q2<N)
									if(a[p2][q2]!=0)
									{
										b[i][j]=a[p2][q2];
										sum++;
									}
							}
							if(p1==p2&&q1!=q2)
							{
								if(p1>=0&&p1<N&&q2>=0&&q2<N)
									if(a[p1][q2]!=0)
									{
										b[i][j]=a[p1][q2];
										sum++;
									}
								if(p2>=0&&p2<N&&q1>=0&&q1<N)
									if(a[p2][q1]!=0)
									{
										b[i][j]=a[p2][q1];
										sum++;
									}
							}
							if(p1==p2&&q1==q2)
							{
								if(p1>=0&&p1<N&&q2>=0&&q2<N)
									if(a[p1][q2]!=0)
									{
										b[i][j]=a[p1][q2];
										sum++;
									}
							}
						}
						if(sum==1)
							break;
						else
							if(sum>1)
							{
								b[i][j]=0;
								break;
							}
					}
				}
			}
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				System.out.print(b[i][j]+" ");
			}
			System.out.println();
		}
                    
	}

}