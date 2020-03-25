import java.io.*;
import java.util.*;
public class Main
{
            public static void main(String args[]) throws Exception
            {
            	//	InputStream is=new FileInputStream("c:\\input.txt");
                    Scanner cin=new Scanner(System.in);
                   	int testcase=cin.nextInt();
                   	while(testcase--!=0)
                   	{
                   		int row=cin.nextInt(),col=cin.nextInt(),days=cin.nextInt();
                   		char[][]map=new char[row][col];
                   		for(int i=0;i<row;i++)
                   		{
                   			String s=cin.next();
                   			for(int j=0;j<col;j++)
                   			{
                   				map[i][j]=s.charAt(j);
                   			}
                   		}
                   		while(days--!=0)
                   		{
                   			char tmap[][]=new char[row][col];
                   			for(int i=0;i<row;i++)
                   				for(int j=0;j<col;j++)
                   					tmap[i][j]=map[i][j];
                   			for(int i=0;i<row;i++)
                   				for(int j=0;j<col;j++)
                   				{
                   					if(i-1>=0)
                   					{
                   						if(map[i][j]=='R'&&map[i-1][j]=='S')
                   						{
                   							tmap[i-1][j]='R';
                   					//		show(map,row,col);
                   						}
                   						if(map[i][j]=='S'&&map[i-1][j]=='P')
                   						{
                   							tmap[i-1][j]='S';
                   				//			show(map,row,col);
                   						}
                   						if(map[i][j]=='P'&&map[i-1][j]=='R')
                   						{
                   							tmap[i-1][j]='P';
                   					//		show(map,row,col);
                   						}
                   					}
                   					if(i+1<row)
                   					{
                   						if(map[i][j]=='R'&&map[i+1][j]=='S')
                   						{
                   							tmap[i+1][j]='R';
                   				//			show(map,row,col);
                   						}
                   						if(map[i][j]=='S'&&map[i+1][j]=='P')
                   						{
                   							tmap[i+1][j]='S';
                   					//		show(map,row,col);
                   						}
                   						if(map[i][j]=='P'&&map[i+1][j]=='R')
                   						{
                   							tmap[i+1][j]='P';
                   					//		show(map,row,col);
                   						}
                   					}
                   					if(j-1>=0)
                   					{
                   						if(map[i][j]=='R'&&map[i][j-1]=='S')
                   						{	
                   							tmap[i][j-1]='R';
                   					//		show(map,row,col);
                   						}
                   						if(map[i][j]=='S'&&map[i][j-1]=='P')
                   						{	
                   							tmap[i][j-1]='S';
                   					//		show(map,row,col);
                   						}
                   						if(map[i][j]=='P'&&map[i][j-1]=='R')
                   						{	
                   							tmap[i][j-1]='P';
                   					//		show(map,row,col);
                   						}
                   					}
                   					if(j+1<col)
                   					{
                   						if(map[i][j]=='R'&&map[i][j+1]=='S')
                   						{
                   							tmap[i][j+1]='R';
                   					//		show(map,row,col);
                   						} 
                   						if(map[i][j]=='S'&&map[i][j+1]=='P')
                   						{
                   							tmap[i][j+1]='S';
                   					//		show(map,row,col);
                   						}                   	
                   						if(map[i][j]=='P'&&map[i][j+1]=='R')
                   						{	
                   							tmap[i][j+1]='P';
                   						//	show(map,row,col);
                   						}
                   					}
                   				}
                   			map=tmap;
                  
                   			
                   		}
                   		show(map,row,col);
                   		
                   	}
          }
          public static void show(char[][]map,int row,int col)
          {
          		for(int i=0;i<row;i++)
          		{
          			for(int j=0;j<col;j++)
          				System.out.print(map[i][j]);
          			System.out.println();
          		}
          		System.out.println();
          }
}