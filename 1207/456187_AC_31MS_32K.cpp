#include <iostream.h>
void main()
{
	int a, b ,i ,num , max ,temp ;
cin >> a >> b ;
	while(cin)
{

	
	max = 0 ;
	cout << a << ' ' << b ;
	if ( a >b ) {temp = a ;a = b ;b = temp ;}
	for( i = a ; i<=b ; i++ )
	{
		temp = i ;
		num = 1 ;
		while(temp != 1 )
		{
			if ( temp % 2 == 0 ) temp/=2 ;
			else temp=temp*3+1 ;
			num++ ;
		}
		if ( num > max ) max = num ;
	}
	cout << ' ' << max << endl;
	cin >> a >> b ;
}
}
