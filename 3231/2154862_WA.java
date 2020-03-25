import java.io.IOException;
import java.util.Scanner;

public class Main
{

    // static BufferedReader cin;

    public static void main(String[] args) throws IOException
    {
	// cin = new BufferedReader(new InputStreamReader(System.in));
	Scanner cin = new Scanner(System.in);
	int ts=0;
	while (true)
	{
	    ts++;
	    int n = cin.nextInt();
	    if (n == 0)
		break;
	    double t = cin.nextDouble();
	    double[] size = new double[n];
	    double[] is = new double[n];
	    double[] ms = new double[n];
	    double[] ft = new double[n];
	    for (int i = 0; i < n; i++)
	    {
		size[i] = cin.nextDouble();
		is[i] = cin.nextDouble();
		ms[i] = cin.nextDouble();
	    }
	    boolean [] fst=new boolean[n];
	    int left = n;
	    while (left-- > 0)
	    {
		int fi=-1;
		double nt=1e20;
		for(int i=0;i<n;i++)
		{
		    if(fst[i])continue;
		    double dt=size[i]/is[i];
		    if(dt<nt)
		    {
			nt=dt;
			fi=i;
		    }
		}
		for(int i=0;i<n;i++)
		{
		    if(fst[i])continue;
		    ft[i]+=nt;
		    size[i]-=nt*is[i];
		}
		fst[fi]=true;
		double lb=is[fi];
		while(lb>1e-8)
		{
		    int cnt=0;
		    for(int i=0;i<n;i++)
		    {
			if(fst[i])continue;
			if(is[i]<ms[i])
			    cnt++;
		    }
		    if(cnt==0)break;
		    double avg=lb/cnt;
		    lb=0;
		    for(int i=0;i<n;i++)
		    {
			if(fst[i])continue;
			if(is[i]<ms[i]&&is[i]+avg>=ms[i])
			{
			    is[i]=ms[i];
			    lb+=is[i]+avg-ms[i];
			}
		    }
		}
	    }
	    System.out.println("Case "+ts+":");
	    for(int i=0;i<n;i++)
	    {
		System.out.printf("NO%d:%.3fs\n",i+1,ft[i]);
	    }
	}
    }
}
