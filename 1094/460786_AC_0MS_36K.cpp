#include<iostream.h>
#include<fstream.h>
int relation[27][27];
int zimu[27];
char xulie[27];
void print(int,int);
void chushi(int);
int main()
{
	ifstream in;
	in.open("gao.txt");
	int a,b;
	int i;
	int j;
	char first,second,third;
	int ff,th;
	while(1)
	{
		
		cin>>a>>b;//a zimu,six given relations unknow true of false;
		if(a==0&&b==0)
			break;
		int num=0;//should be C(2,a) when completed totally;
		chushi(a);
for(i=1;i<=b;i++)
{
	cin>>first>>second>>third;
	ff=int(first)-int('A')+1;
	th=int(third)-int('A')+1;
	if(relation[ff][th]==1)
	{cout<<"Inconsistency found after "<<i<<" relations."<<endl;
	goto la;}
	if(relation[ff][th]==0)
	{
	relation[ff][th]=-1;
	relation[th][ff]=1;
	num++;
	}
	for(j=1;j<=a;j++)
	{
		if(j!=ff&&j!=th)
		{
			if(!(relation[j][ff]==0&&relation[j][th]==0))
			{
				if(relation[j][ff]!=0&&relation[j][th]!=0)
				{
					if(relation[j][ff]==-1&&relation[j][th]==-1)
					{}
					else if(relation[j][ff]==1&&relation[j][th]==1)
					{}
					else if(relation[j][ff]==1&&relation[j][th]==-1)
					{}
					else
					{
						cout<<"Inconsistency found after "<<i<<" relations."<<endl;
						goto la;
					}
				}
				else if(relation[j][ff]==0)
				{if(relation[j][th]==1)
				{
                 relation[j][ff]=1;
				 relation[ff][j]=-1;
				 num++;
				}
			 
				}
				else//relation[j][th]=0
				{
					if(relation[j][ff]==-1)
					{
						relation[j][th]=-1;
						relation[th][j]=1;
						num++;
					}
				}
				
			}
		}
	}
if(num==a*(a-1)/2)
{
	print(i,a);
	goto la;
}
}
if(num<a*(a-1)/2)
{
	cout<<"Sorted sequence cannot be determined."<<endl;
}
la: ;
	int k;
	char g,lao,feng;
	for(k=i+1;k<=b;k++)
		cin>>g>>lao>>feng;
	}
	return 0;
}

void print(int h,int a)
{
cout<<"Sorted sequence determined after "<<h<<" relations: ";
int i,j;
for(i=1;i<=a;i++)
{
	zimu[i]=0;
}

for(i=1;i<=a;i++)
for(j=1;j<=a;j++)
{
	if(j!=i)
	{
 if(relation[i][j]==1)
	 zimu[i]++;
	}
}
for(i=1;i<=a;i++)
{
xulie[zimu[i]+1]=char(i+int('A')-1);

}
for(i=1;i<=a;i++)
{
cout<<xulie[i];
}
cout<<"."<<endl;
}
void chushi(int a)
{
	int i;
	int j;
	for(i=1;i<=a;i++)
		for(j=1;j<=a;j++)
		{
			relation[i][j]=0;
		}
}
