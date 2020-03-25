int main()
{
	long n;
	scanf("%ld",&n);
	char c1[n+1];
	char c2[n+1];
	char c=0;
	for(int i=0;i<n;i++)
	{
		scanf("%c",c1+i);
		scanf("%c",&c);
		scanf("%c",c2+i);
		scanf("%c",&c);
		
	}
	int jin=0;
	for(int i=n-1;i>=0;i++)
	{
		int tsum=jin+c1[i]+c2[i]-2*'0';
		if(tsum>=10)
			jin=tsum/10;
		c1[i]=tsum%10;
		
	}
	printf("%s",c1);
}