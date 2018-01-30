package cmmdc.iiop.c;
import cmmdc.rmi.i.ICmmdc;

import javax.rmi.PortableRemoteObject;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Scanner;

public class CmmdcClient {
  public static void  main( String args[] ) {
    String host="localhost";
    String port="1050";
    if (args.length>0)
       host=args[0];
    if (args.length>1)
       port=args[1];
    
    Scanner scanner=new Scanner(System.in);
    System.out.println("Numar linii :");
    //long m=Long.parseLong(scanner.next());
	int n = Integer.parseInt(scanner.next());
    System.out.println("Numar coloane :");
    //long n=Long.parseLong(scanner.next());    
	int d = Integer.parseInt(scanner.next());
    try {
      System.setProperty("java.naming.factory.initial","com.sun.jndi.cosnaming.CNCtxFactory");
      System.setProperty("java.naming.provider.url","iiop://"+host+":"+port);
      Context ctx = new InitialContext();
     
      // STEP 1: Get the Object reference from the Name Servctxe
      // using JNDI call.
      Object objref = ctx.lookup("CmmdcService");
     
      System.out.println("Client: Obtained a ref. to Cmmdc server.");
      // STEP 2: Narrow the object reference to the concrete type and
      // invoke the method.
      ICmmdc obj = (ICmmdc) PortableRemoteObject.narrow(objref,ICmmdc.class);
      //long x=obj.cmmdc(m,n);
	  int rez[][] = new int[n][d];
	  rez = obj.tablou(n,d);
	  for(int i=0;i<n;i++)
	  {
		for(int j=0;j<d;j++)
		{
			System.out.print(rez[i][j]); 
			System.out.print(" "); 
		}
		System.out.println(); 
	  }
      //System.out.println("Cmmdc="+x); 
    } 
    catch( Exception e ) {
      e.printStackTrace();
    }
  }
}


