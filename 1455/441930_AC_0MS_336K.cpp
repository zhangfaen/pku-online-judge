#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct Times
{
	long rTime;
	long lTime;
	Times()  { rTime = lTime =0; }
};

void main()
{
	int n;  cin >> n;
	vector<int> input(n);
	for (int i=0; i<input.size(); i++)
		cin >> input[i];
	int persons = *(max_element(input.begin(), input.end()));

	vector<Times> times(persons+1);
	times[2].lTime = 1;
	for (n=3; n<times.size(); n++)
	{
		int a = n/2, b = n-a;
		times[n].rTime = times[a].lTime+times[b].lTime;
		times[n].lTime = a*b+times[n].rTime;
	}
	for (i=0; i<input.size(); i++)
		cout << times[input[i]].rTime << endl;
}