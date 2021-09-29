package gestionBD;



import java.util.*;
 
public class connect
{
	public static  void main(String args[])
	{
		int start=0;
	
		int count=0;
		int count_max=42;
		connect_four one=new connect_four();
		
		one.display_board();
	
		do
		{
			System.out.println ("Vaya primero");
		
			Scanner in=new Scanner(System.in);
			int cow=in.nextInt();
			
			if(one.judge(cow, 1) == 1)
			{
				start=1;count++;
			}
			else
			{
				start=0;
			}
		}
		
		while(start==0);
		one.display_board();
		System.out.println();
		int color=2;
		do
		{
			//one.getcolor();
			
			 System.out.println ("El oponente juega ajedrez");
			Scanner in=new Scanner(System.in);
			//int raw=in.nextInt();
			int cow=in.nextInt();
			if(one.judge(cow,color)==0)
			{
				 System.out.println ("No se pudo jugar al ajedrez, vuelve a jugar");
			}
			else
			{
					count++;
					if(one.is_four(cow, color, 0, 1)==1)
					{
						if(color==1)
							 System.out.print("\t\t\t\tcircle");
						else
							 System.out.print ("\t\t\t\tfork");
						 System.out.print ("Win\n");
						one.display_board();
						System.out.println();
						return ;
					}
					if(color==2)color=1;
					else color=2;
			}
			one.display_board();
			
		}
		while(count<count_max);
		if(count==count_max)
			{
				 System.out.println ("\t \t \t \t \t and Bureau");
				one.display_board();
				System.out.println();
			}
		
	}
 
 
 
}
 
 
class  connect_four
{
	private int flag=0;				//
	 private int max_i = 6; // Línea máxima
	 private int max_j = 7; // Columna máxima
	 private int row; // valor de fila
	 private int cow; // Valor de columna
	 private int [] [] chessboard_status = new int [6] [7]; // Estado del tablero de ajedrez
	 private int [] a = new int [7]; // El valor de la fila de la columna
	 private int chess_color; // Color de piezas de ajedrez
	
	 public connect_four () // El constructor inicializa el tablero de ajedrez
	{
		flag=0;
		max_i=6;
		max_j=7;
		row=0;
		cow=0;
		for(int i=0;i<max_i;i++)
		{
			for(int j=0;j<max_j;j++)
			{
				a[j] = 5;
				chessboard_status[i][j]=0;
			}
		}
	}
	public int judge(int j,int color)
	{
		switch(j)
		{
		case 0: if (a[j]>= 0) {chessboard_status[a[j]][j]=color; a[j]--; break;} // Número bidimensional            
                                                                                                                                                                   // Almacenamiento grupal
						else return 0;	
			case 1:	 if(a[j]>=0) {chessboard_status[a[j]][j]=color;a[j]--;break;}
						else return 0;
			case 2:	 if(a[j]>=0) {chessboard_status[a[j]][j]=color;a[j]--;break;}
			 			else return 0;
			case 3:	 if(a[j]>=0) {chessboard_status[a[j]][j]=color;a[j]--;break;}
						else return 0;
			case 4:	 if(a[j]>=0) {chessboard_status[a[j]][j]=color;a[j]--;break;}
			 			else return 0;
			case 5:	 if(a[j]>=0) {chessboard_status[a[j]][j]=color;a[j]--;break;}
			 			else return 0;
			case 6:	 if(a[j]>=0) {chessboard_status[a[j]][j]=color;a[j]--;break;}
			 			else return 0;
			default: ;
		}
		return 1;
	}
	public int judge_status(int i,int j)
	{
		if(i>-1&&i<max_i&&j>-1&&j<max_j)
			if(chessboard_status[i][j]==0)
				return 0;
			else if(chessboard_status[i][j]==1)
				 return 1; // blanco
			else
				 return 2; // negro
		 else return -1; // El hipermarco de entrada de ubicación
	}
	public void getcolor()
	{
		if(flag==1)
			 System.out.print ("White Chess");
		else
			 System.out.print ("Black Chess");
		System.out.println("\n");
	}
	public void display_board()
	{
		char a=1;
		char b=0;
	
		
		System.out.print("  ");
			for(int j=0;j<max_j;j++)
			{
				System.out.print(j+" ");
			
		
			}
			System.out.println();
		
		for(int i=0;i<max_i;i++)
		{
			
			for(int j=0;j<max_j;j++)
			{
				if(j==0)
					System.out.print(i);
				switch(chessboard_status[i][j])
				{
				case 0: System.out.print(" *");break;
				case 1: System.out.print(" ○");break;
				case 2: System.out.print(" ×");break;
				}
			}
			System.out.println();
		}
		
	}
	public int is_four(int j,int color,int num,int direction)
	{
		int m=a[j]+1,n=j;
		do
		{
			switch(direction)
			{
			case 1: m=m+1;n=n;break;
			case 2:	m=m+1;n=n-1;break;
			case 3: m=m;n=n-1;break;
			case 4: m=m-1;n=n-1;break;
			case 5: m=m-1;n=n;break;
			case 6: m=m-1;n=n+1;break;
			case 7: m=m;n=n+1;break;
			case 8: m=m-1;n=n-1;break;
			default :break;
			
			}
			if(judge_status(m,n)==color)
			{
				num++;
				if(num==3)
				{
					return 1;
				}
			}
			else 
				{
					m=a[j]+1;
					n=j;
					num=0;
					direction++;
				}
		}while(direction!=9);
		if(num==3)	return 1;
		else return 0;
	}
}
