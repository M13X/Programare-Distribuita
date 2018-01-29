package cmmdc.socket.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class CmmdcClient {
  public static void main(String[] args) throws IOException {

    String host="localhost";
    int port=7999;
    if (args.length>0)
       host=args[0];
    if (args.length>1)
       port=Integer.parseInt(args[1]);
    Scanner scanner=new Scanner(System.in);
    System.out.println("n=");
    //long m=scanner.nextLong();
    //String m = scanner.nextLine();
	int n = scanner.nextInt();
    System.out.println("d=");
    //long n=scanner.nextLong();
    //double n = scanner.nextDouble();
	int d = scanner.nextInt();
    try(Socket cmmdcSocket = new Socket(host, port); 
      DataInputStream in=new DataInputStream(cmmdcSocket.getInputStream());
      DataOutputStream out=new DataOutputStream(cmmdcSocket.getOutputStream())){
        out.writeInt(n);
        out.writeInt(d);
        for(int i = 0;i<n;i++)
		{
			for(int j=0;j<d;j++)
			{
				int r=in.readInt();
				System.out.print(r);
				System.out.print(" ");
			}
			System.out.println();
		}

    } 
    catch(Exception e){
       System.err.println("Client comunication error : "+e.getMessage());
    }
  }
}


