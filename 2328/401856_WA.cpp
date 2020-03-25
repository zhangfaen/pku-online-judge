#include<string.h>
#include<stdio.h>
#include<iostream.h>
void main(){
int num;
char judge[9];
cin>>num;
gets(judge);
int max=10,min=1;
while(1)
	{
	if(strcmp(judge,"too high")==0)
		{
		if(max>=num)max=num-1;
		}
	
		else if(strcmp(judge,"too low")==0)
			{
			if(min<=num)min=num+1;
			}
			else if(strcmp(judge,"right on")==0)
				{
				if(num>=min&&num<=max)cout<<"Stan may be honest"<<endl;
				else cout<<"Stan is dishonest"<<endl;
				min=1;
				max=10;
				}
	cin>>num;
	if(num==0)break;
	gets(judge);
	
	}

}
