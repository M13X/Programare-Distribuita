package cmmdc.rmi.s;

import cmmdc.rmi.i.ICmmdc;
import java.rmi.server.UnicastRemoteObject;
// Varianta cu apel rmiregistry direct
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
// Varianta JNDI
import javax.naming.Context;
import javax.naming.InitialContext;

public class CmmdcImpl  implements ICmmdc{

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
    public static void main(String args[]) {
      String host="localhost";
      int port=1099;
      if(args.length>0)
         port=Integer.parseInt(args[0]);
      try {
        CmmdcImpl obj=new CmmdcImpl();
        ICmmdc stub=(ICmmdc)UnicastRemoteObject.exportObject(obj,0);
        // Varianta cu apel rmiregistry direct
        /*
        Registry registry=LocateRegistry.getRegistry(host,port);
        registry.bind("CmmdcServer",stub);
        */
        // Varianta JNDI
        String sPort=Integer.valueOf(port).toString();
        System.setProperty(Context.INITIAL_CONTEXT_FACTORY,
          "com.sun.jndi.rmi.registry.RegistryContextFactory");
        System.setProperty(Context.PROVIDER_URL,"rmi://"+host+":"+sPort);
        Context ctx=new InitialContext();
        ctx.bind("CmmdcServer",stub);
        System.out.println("Server ready");
        System.out.println("Press CTRL+C to finish !");
      } 
      catch (Exception e) {
        //System.out.println("CmmdcImpl err: " + e.getMessage());
        e.printStackTrace();
      }
    }
} 
