import java.text.DecimalFormat;
import java.util.*;

public class Main {
	
	public static class task
	{
		public double time,size,band,max;
	};
	
	public static void main(String[] args) {
		task []t=new task[101];
		int i,n,cas;
		for (i=0;i<101;i++) t[i]=new task(); 
		double band,x,y,z,p;
		Scanner cin=new Scanner(System.in);
		cas=1;
		while (cin.hasNextInt()){
			n=cin.nextInt();
			if (n==0) break;
			System.out.println("Case "+cas+":");
			cas++;
			band=cin.nextDouble();
			for (i=0;i<n;i++){
				t[i].size=cin.nextDouble();
				t[i].band=cin.nextDouble();
				t[i].max=cin.nextDouble();
				//System.out.println("size="+t[i].size+"band="+t[i].band);
				t[i].time=0;
			}
			while (true){
				z=1e20;
				for (i=0;i<n;i++)
					if (t[i].size>1e-9 && t[i].size/t[i].band<z){ 
						z=t[i].size/t[i].band;
						//System.out.println("z="+z);
					}
				if (z<1e-9 || z>1e10) break;
				y=0;x=0;
				for (i=0;i<n;i++)
				  if (t[i].size>1e-9){
					t[i].time+=z;
					t[i].size-=z*t[i].band;
					if (t[i].size<1e-9){ 
						y+=t[i].band;
						//System.out.println("task:"+i+" time:"+t[i].time);
					}else 
					if (t[i].band+1e-9<t[i].max) x++;
				}
				  
				while (y>1e-9 && x>1e-9){
					//System.out.println("y="+y+" x="+x);
					z=0;p=0;
					for (i=0;i<n;i++)
						if (t[i].size>1e-9 && t[i].band+1e-9<t[i].max){
							t[i].band+=y/x;
							if (t[i].band>t[i].max){
								z+=t[i].band-t[i].max;
								t[i].band=t[i].max;
							}else p++;
							//System.out.println("t["+i+"].band="+t[i].band);
						}
					y=z; x=p;
				}
			}
		for (i=0;i<n;i++){
			System.out.print("NO"+(i+1)+":");
			System.out.print(new DecimalFormat("0.000").format(t[i].time));
			System.out.println("s");
		}
		}
	}
}



































































