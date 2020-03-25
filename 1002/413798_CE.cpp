#include<iostream.h>
#include<string.h>
#include<stdlib.h>
int compare(const void* a,const void* b)
{
	return strcmp((char*)a,(char*)b);
}


void main()
{
	int k;
	cin>>k;
	char (*tele)[100];
	tele=new char [k][100];
	char (*tele2)[16];
	tele2=new char [k][100];

	
	for(int i=0;i<k;i++)
	{
		cin>>tele[i];
		
		for(int j=0,n=0;n<7;j++)
		{
			if(tele[i][j]=='-')
				continue;
			if(tele[i][j]>57)
			{
				if(tele[i][j]<81)
					tele2[i][n]=char(int((tele[i][j]-'A'+1)/3.1)+50);
				else
					tele2[i][n]=char(int((tele[i][j]-'A')/3.1)+50);
				n++;
				continue;
			}

			tele2[i][n]=tele[i][j];
			n++;
		}
		tele2[i][7]='\0';
	}
	qsort(tele2,k,sizeof(tele2[0]),compare);
	
	int *num;
	num=new int [k];
	for(i=0;i<k;i++)
		num[i]=1;
	int j=1;
	for( i=0;i<k;j=1)
	{
		while(!(strcmp(tele2[i],tele2[i+j])))
		{
			num[i]++;
			j++;
		}
		i+=j;
	}
	int e=0;
	for(i=0;i<k;i++)
	{	
		if(num[i]!=1)
		{
			for(int m=0;m<3;m++)
				cout<<tele2[i][m];
				cout<<'-';
			for(m=3;m<7;m++)
				cout<<tele2[i][m];
			cout<<" "<<num[i]<<endl;
			e=1;
		}
	}
	
	if(!e)
		cout<<"No duplicates."<<endl;
	delete[]tele;
	delete[]tele2;
}
