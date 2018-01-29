package cmmdc.rmi.c;
import cmmdc.rmi.i.ICmmdc;
import java.util.Scanner;
// Varianta cu apel rmiregistry direct
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
// Varianta JNDI
import javax.naming.Context;
import javax.naming.InitialContext;

public class CmmdcClient {
  public static void main(String args[]) {
    String host="localhost";
    int port=1099;
    if(args.length>0)
      host=args[0];
    if (args.length>1)
      port=Integer.parseInt(args[1]);
    Scanner scanner=new Scanner(System.in);
    System.out.println("Nr linii :");
    //long m=Long.parseLong(scanner.next());
	int n = scanner.nextInt();
    System.out.println("Nr coloane :");
    //long n=Long.parseLong(scanner.next());
	int d = scanner.nextInt();
    //long x=0;
    int rez[][] = new int[n][d];
	try {
      // Varianta cu apel rmiregistry direct
      /*
      Registry registry=LocateRegistry.getRegistry(host,port);
      ICmmdc obj=(ICmmdc)registry.lookup("CmmdcServer");
      */
      // Varianta JNDI
      String sPort=Integer.valueOf(port).toString();
      System.setProperty(Context.INITIAL_CONTEXT_FACTORY,
        "com.sun.jndi.rmi.registry.RegistryContextFactory");
      System.setProperty(Context.PROVIDER_URL,"rmi://"+host+":"+sPort);
      Context ctx=new InitialContext();
      ICmmdc obj=(ICmmdc)ctx.lookup("CmmdcServer");
      
      //x=obj.cmmdc(m,n);
      rez = obj.tablou(n,d);
	  //System.out.println("Cmmdc="+x);
	 for(int i = 0;i<n;i++)
	{
		for(int j=0;j<d;j++)
		{
			System.out.print(rez[i][j]);
			System.out.print(" ");
		}
		System.out.println();
	}
	}
    catch (Exception e) {
      System.out.println("CmmdcClient exception: "+e.getMessage());
    }
  }
}
