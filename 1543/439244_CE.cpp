最经典的做法
Posted by cpp050100448706 at 2005-03-25 09:57:22.0 on Problem 1543 
--------------------------------------------------------------------------------

#include <iostream.h>
int a[81][4]={6,3,4,5
,12,6,8,10
,18,2,12,16
,18,9,12,15
,19,3,10,18
,20,7,14,17
,24,12,16,20
,25,4,17,22
,27,3,18,24
,28,18,19,21
,29,11,15,27
,30,15,20,25
,36,4,24,32
,36,18,24,30
,38,6,20,36
,40,14,28,34
,41,2,17,40
,41,6,32,33
,42,21,28,35
,44,16,23,41
,45,5,30,40
,46,3,36,37
,46,27,30,37
,48,24,32,40
,50,8,34,44
,53,29,34,44
,54,6,36,48
,54,12,19,53
,54,27,36,45
,56,36,38,42
,57,9,30,54
,58,15,42,49
,58,22,30,54
,60,21,42,51
,60,30,40,50
,63,7,42,56
,66,33,44,55
,67,22,51,54
,69,36,38,61
,70,7,54,57
,71,14,23,70
,72,8,48,64
,72,34,39,65
,72,36,48,60
,75,12,51,66
,75,38,43,66
,76,12,40,72
,76,31,33,72
,78,39,52,65
,80,28,56,68
,81,9,54,72
,81,25,48,74
,82,4,34,80
,82,12,64,66
,82,19,60,69
,84,28,53,75
,84,42,56,70
,84,54,57,63
,85,50,61,64
,87,20,54,79
,87,26,55,78
,87,33,45,81
,87,38,48,79
,88,21,43,84
,88,25,31,86
,88,32,46,82
,89,17,40,86
,90,10,60,80
,90,25,38,87
,90,45,60,75
,90,58,59,69
,92,6,72,74
,92,54,60,74
,93,32,54,85
,95,15,50,90
,96,19,53,90
,96,48,64,80
,97,45,69,79
,99,11,66,88
,100,16,68,88
,100,35,70,85};

void main()
{
	int s;
	cin>>s;
	for(int i=0;i<81;i++)
	if(s>=a[i][0])
	cout<<"Cube = "<<a[i][0]<<", Triple = ("<<a[i][1]<<","<<a[i][2]<<","<<a[i][3]<<")"<<endl;
}
 
