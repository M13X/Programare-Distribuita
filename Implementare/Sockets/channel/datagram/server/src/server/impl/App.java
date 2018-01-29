package cmmdc.datagramchannel.s.impl;
public class App{
  public interface CmmdcService {
    long cmmdc(long m, long n);
  }
    public interface TabouService {
    int[][] tablou(int n, int d);
  }

  public static CmmdcService cmmdcService=(long m, long n) -> 
    { 
      long r,c;
      do{
         c=n;
         r=m%n;
         m=n;
         n=r;
         }
      while(r!=0);
      return c;
    };   
	public static TabouService tablouService=(int n, int d) ->
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
	};
}
