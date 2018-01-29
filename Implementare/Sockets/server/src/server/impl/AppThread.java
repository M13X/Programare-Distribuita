package cmmdc.socket.server.impl;

import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.function.Function;

public class AppThread{
  // Firul de executie lansat de server
  Function<Socket,Thread> service=socket->{
    return new Thread(()->{
      try(DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream())){  
        //long m=0,n=0,r;
		int n,d;
		n = in.readInt();
		d = in.readInt();
		//double r2;
        //String a;
        //int b;
        //m=in.readLong();
        //n=in.readLong();
        //a = in.readUTF();
	//b = in.readInt();
        //r=App.cmmdc(m,n);
        //r2 = App.transformare(a,b);
		int[][] rez = new int[n][d];
		rez = App.tablou(n,d);
		for(int i = 0;i<n;i++)
		{
			for(int j=0;j<d;j++)
			{
				out.writeInt(rez[i][j]);
			}
		}
		
        socket.close();
      }
      catch(IOException e){
         e.printStackTrace();
      }  
    });
  };
}
