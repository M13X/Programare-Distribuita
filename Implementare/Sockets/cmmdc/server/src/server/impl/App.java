package cmmdc.socket.server.impl;
import java.util.function.BiFunction;

public class App{
  static public long cmmdc(long a,long b){
    BiFunction<Long,Long,Long> f=(m,n)->{ 
      long r,c;
      do{
        c=n;
        r=m % n;
        m=n;
        n=r;
      }
      while(r!=0);
      return Long.valueOf(c);
    };
    return f.apply(a,b).longValue();
  }  

  static public double transformare(String din, double deg){
    double rez = 0;
    if(din.equals("C2F"))	rez = 1.8 + deg + 32;
    if(din.equals("F2C"))	rez = (deg-32)/1.8;
    return rez;
  }
  	static public  int[][] tablou(int n, int d)
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
