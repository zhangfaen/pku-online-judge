#include <stdio.h>
#include <math.h>
#define N 1000
#define MAX 100000.0

class village{
    public:
	int x;
	int y;
	long altitude;
};
class cost{
    public:
	double distance;
	double height;
};

int main()
{
	int decided[N];
	int undecided[N];
	village v[N];
	cost ** u;
	double currentdistance = 0.0;
	double currentcost = 0.0;
	double min, t1, t2, a, b;
	int i, j;
	int num, top, selected, t;
	
	u=new (cost*)[N];
	for(i=0;i<N;i++)
    u[i]=new cost[N];
	//freopen("c:\\in.txt","r",stdin);
	scanf("%d", &num);
	while(num)
	{
		for(i = 0; i < num; i++)
		{
			scanf("%d%d%I64d", &v[i].x, &v[i].y, &v[i].altitude);
		}
		for(i = 0; i < num; i++)
		{
			for(j = 0; j < num; j++)
			{
				u[i][j].distance = sqrt((double)((v[i].x - v[j].x) * (v[i].x - v[j].x) + (v[i].y - v[j].y) * (v[i].y - v[j].y)));
				if(v[i].altitude > v[j].altitude)
					u[i][j].height = (double)(v[i].altitude - v[j].altitude);
				else
					u[i][j].height = (double)(v[j].altitude - v[i].altitude);
			}
		}
		currentdistance = 0.0;
		currentcost = 0.0;
		top = 0;
		decided[top++] = 0;
		for(i = 0; i <= num - 1; i++)
		{
			undecided[i] = i + 1;
		}
		while(top <= num - 1)
		{
			min = MAX;
			for(i = 0; i < top; i++)
			{
				t = undecided[0];
				while(t < num)
				{
					t1 = currentcost + u[decided[i]][t].height;
					t2 = currentdistance + u[decided[i]][t].distance;
					if(t1 / t2 < min)
					{
						min = t1 / t2;
						a = t1;
						b = t2;
						selected = t;
					}
					t = undecided[t];
				}
			}
			currentdistance = b;
			currentcost = a;
			t = 0;
			while(undecided[t] != selected)
				t = undecided[t];
			undecided[t] = undecided[selected];
			decided[top++] = selected;
		}
		printf("%.3f\n", (double)(a / b));
		scanf("%d", &num);
	}
	int aaaa;
	scanf("%d",&aaaa);
	return 0;
}