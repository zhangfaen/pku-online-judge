#include <stdio.h>

#define MAXN 100020
#define ISCOVER(x) (x)
#define COLOR(x)   (1<<x)
#define INITCOLOR  2

int l,t,o;
int odder;
int a,b,c,temp;
unsigned color;

struct TreeNode {
	unsigned color;
	int left;
	int right;
};

TreeNode segtree[MAXN*4];

void initfill(int index,int a,int b)
{
	segtree[index].color = INITCOLOR;
	if(a==b)
	{
		segtree[index].left=segtree[index].right=a;
		return;
	}
	int mid = (a+b)/2;
	segtree[index].left = a;
	segtree[index].right = b;
	initfill(index*2,a,mid);
	initfill(index*2+1,mid+1,b);
}

void update(int index,int a,int b)
{
	if( color == segtree[index].color )
		return;
	if(a==segtree[index].left && b==segtree[index].right)
	{
		segtree[index].color=color;
	}else
	{
		if( ISCOVER(segtree[index].color) )
		{
			segtree[index*2].color = segtree[index].color;
			segtree[index*2+1].color = segtree[index].color;
		}
		segtree[index].color = 0;
		int mid = (segtree[index].left+segtree[index].right)/2;
		if(a<=mid)
		{
			if(b<mid)
				update(index*2,a,b);
			else
				update(index*2,a,mid);
		}
		if(b>mid){
			if(a>mid)
				update(index*2+1,a,b);
			else
				update(index*2+1,mid+1,b);
		}
	}
}

unsigned getcolor(int index,int a,int b)
{
	if( segtree[index].color )
	{
		return segtree[index].color;
	}
	unsigned result=0;
	int mid = (segtree[index].left+segtree[index].right)/2;
	if(a<=mid)
		result |= getcolor(index*2,a,mid);
	if(b>mid)
		result |= getcolor(index*2+1,mid+1,b);
	return result;
}

int getColorKindNum(unsigned color)
{
	int i;
	int result=0;
	for(i=1;i<=t;i++)
	{
		if( color & COLOR(i) )
			result++;
	}
	return result;
}

int main()
{
	int i;
	//freopen("test.txt","r",stdin);
	
	scanf("%d%d%d",&l,&t,&o);

	initfill(1,1,l);
	for(i=0;i<o;i++)
	{
		do {
			odder = getchar();
		} while( odder!='C' && odder!='P' );
		if(odder=='C')
		{
			scanf("%d%d%d",&a,&b,&c);
			color = COLOR(c);
			if(a>b)
			{
				temp = a;
				a = b;
				b = temp;
			}
			update(1,a,b);
		}else
		{
			scanf("%d%d",&a,&b);
			if(a>b)
			{
				temp = a;
				a = b;
				b = temp;
			}
			printf("%d\n",getColorKindNum( getcolor(1,a,b) ) );
		}
	}
	return 0;
}
