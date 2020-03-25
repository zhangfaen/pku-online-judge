#include <iostream>
#include <string>
using namespace std;

void main()
{
	string a, b;
	cin >> a >> b;
	int m[26] = {0,}, n[26] = {0,};
	int i;


	

	for( i = 0; i < a.size(); i ++ )//以下正确
		m[a[i] - 'A'] ++;
	for( i = 0; i < b.size(); i ++ )
		n[b[i] - 'A'] ++;
	for( i = 0; i < 26; i ++ )
	{
		for( int j = 0; j < 26; j ++ )
		{
			if( m[i] == n[j] )
				break;
		}
		n[j] = 0;
		if( j == 26 )
		{
			cout << "NO" << endl;
			return;
		}
	}
	if( i == 26 )
		cout << "YES" << endl;
}