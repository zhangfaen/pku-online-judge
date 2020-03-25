#include <iostream.h>
#include <ctype.h>
#include <math.h>

void main()
{
	char ch;
	double sum=0,cur;
	int ans;
	while(cin.peek()!='#')
	{
		while(cin.peek()!='0')
		{
			while(!isdigit(cin.peek()))
				cin.get(ch);
			cin>>cur>>ch;
			if(cur>=0)
			{
				switch (ch)
				{
				case 'F': sum+=cur*2;break;
				case 'B': sum+=ceil(cur*1.5);break;
				case 'Y': sum+=cur>500?cur:500;
				}
			}
			cin.ignore();
		}
		ans=(int)ceil(sum);
		cout<<ans<<endl;
		cin.ignore(2);sum=0;

	}
}
