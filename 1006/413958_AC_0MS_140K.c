 #include <stdio.h>
 int main(void){
    int p, e, i, d;
    int c=1;
   long int triple = 0;
    scanf("%d%d%d%d", &p, &e, &i, &d);
    while(p!=-1){
       triple = (p*5544+e*14421+i*1288)%21252;
       triple-=d;
       if(triple <= 0)
 				triple+=21252;
       printf("Case %d: the next triple peak occurs in %ld days.\n", c++, triple);
       scanf("%d%d%d%d", &p, &e, &i, &d);
    }
 }
