#include <iostream>
#include <string>
using namespace std;
void change(char n[],int count[]);

char number[16][81];
 
int main(){
	char num[81];
	int count[10];
	int i,len;
	cin>>num;
	while(strcmp(num,"-1")!=0){
		for(i=0;i<10;i++) count[i]=0;
		len=strlen(num);
		for(i=0;i<len;i++) count[num[i]-'0']++;
		change(num, count);
		cin>>num;
	}
	return 0;
}

void change(char n[],int count[]){
	int i,j,k,t;
	int len=strlen(n);
	strcpy(number[0],n);
	for(i=1;i<16;i++){
		for(j=0,k=0;k<10;k++){
			if(count[k]>=10){
				number[i][j]=count[k]/10+'0';
				number[i][++j]=count[k]%10+'0';
				number[i][++j]=char (k+'0');
				j++;
			}
			else
				if(count[k]!=0){
					number[i][j]=count[k]+'0';
					number[i][++j]=(k+'0');
					j++;
				}
		}
		number[i][j]='\0';
		if(strcmp(number[0],number[1])==0){
			cout<<number[0]<<" is self-inventorying"<<endl;
			break;}
		else
			if(strcmp(number[i-1],number[i])==0){
				cout<<number[0]<<" is self-inventorying after "<<i-1<<" steps"<<endl;
				break;}
			else {
				for(t=0;t<i;t++) 
					if(strcmp(number[t],number[i])==0){
						cout<<number[0]<<" enters an inventory loop of length "<<i-t<<endl;
						break;				
					}
				if(t<i) break;
			}
		len=strlen(number[i]);
		for(t=0;t<10;t++) count[t]=0;
		for(t=0;t<len;t++) count[number[i][t]-'0']++;
	
	}
				
	if(i>=16)
		cout<<number[0]<<" can not be classified after 15 iterations"<<endl;
}
