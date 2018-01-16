import java.util.Scanner;

public class main
{

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int n=scan.nextInt();
		int d=scan.nextInt();
		int result[][] = tablou(n, d);
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<d;j++)
			{
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static int[][] tablou(int n, int d)
	{
		int P[][] = new int[n][d];
		int T[][] = new int[n][d];
		for(int j=0; j<d; j++)
		{
			P[0][j]=1;
			for(int k=0;k<=j;k++)
			{
				T[0][j]+=P[0][k];
			}
		}
		for(int i=1; i<n; i++)
		{
			for(int j=0; j<d; j++)
			{
				P[i][j]=T[i-1][j];
				for(int k=0;k<=j;k++)
				{
					T[i][j]+=P[i][k];
				}
			}
		}
		
		return T;
	}
}
