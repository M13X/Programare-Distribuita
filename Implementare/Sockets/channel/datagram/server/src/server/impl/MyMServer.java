package cmmdc.datagramchannel.s.impl;
import cmmdc.datagramchannel.i.IMyMServer;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.DatagramChannel;
import java.nio.ByteBuffer;
import java.io.IOException;

public class MyMServer implements IMyMServer{

  interface ServerDatagramChannelAction{
    void service(DatagramChannel datagramChannel);
  }

  static ServerDatagramChannelAction action=(DatagramChannel datagramChannel)->{
    try{
      //ByteBuffer bb = ByteBuffer.allocate(16);    
	  ByteBuffer bb = ByteBuffer.allocate(256);    
      //LongBuffer lb = bb.asLongBuffer();
      SocketAddress sa=datagramChannel.receive(bb);
      // Varianta 1
      //long m=bb.getLong(0);
      //long n=bb.getLong(8);
      int n = bb.getInt(0);
	  int d = bb.getInt(4);
	  // Varianta 2
      // long m=lb.get(0);
      // long n=lb.get(1);   
      App app=new App();
      //long r=app.cmmdcService.cmmdc(m,n);
      int rez[][] = new int[n][d]; 
	  rez = app.tablouService.tablou(n,d);
	  bb.clear();
	  int count=0;
	  for(int i =0;i<n;i++)
	  {
		for(int j=0;j<d;j++)
		{
			  // Varianta 1
			  bb.putInt(count*4,rez[i][j]);
			  // Varianta 2
			  // lb.put(r);
			  count++;
		}
	  }
	  datagramChannel.send(bb,sa); 
    }
    catch(Exception e){
      e.printStackTrace();
    }       
  };  
  
  public DatagramChannel getDatagramChannel(int port){
    DatagramChannel datagramChannel=null;
    InetSocketAddress isa=new InetSocketAddress(port);
    try{
      datagramChannel = DatagramChannel.open();     
      DatagramSocket datagramSocket=datagramChannel.socket();
      datagramSocket.bind(isa);
    }
    catch(IOException e){
      System.out.println("DatagramChannelError : "+e.getMessage());
      System.exit(0);
    }
    System.out.println("Server ready... "); 
    return datagramChannel;
  }
  
  public void myAction(DatagramChannel datagramChannel){
    while(true){
      action.service(datagramChannel);
    }
  }
}
