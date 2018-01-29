package cmmdc.iiop.s;
import javax.rmi.PortableRemoteObject;
import java.rmi.RemoteException;
import cmmdc.rmi.i.ICmmdc;

// Se extinde clasa PortableRemoteObject 
// si nu UnicastRemoteObject

public class CmmdcImpl extends PortableRemoteObject
                       implements ICmmdc{
  // Constructorul clasei
  public CmmdcImpl() throws RemoteException {}
     
  public long cmmdc(long a,long b){
  if (a==b)
     return a;
  else
     if (a<b)
           return cmmdc(a,b-a);
     else
         return cmmdc(a-b,b);
  }
  public  int[][] tablou(int n, int d)
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