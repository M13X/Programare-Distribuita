package cmmdc.socket.server;

import java.net.ServerSocket;
import cmmdc.socket.server.impl.MyMServer;
import cmmdc.socket.server.i.IMyMServer;

public class AppServer{
  public static void main(String[] args){
    int port=7999;
    if(args.length>0)
      port=Integer.parseInt(args[0]);
    IMyMServer myMServer=new MyMServer();
    ServerSocket serverSocket=myMServer.getServerSocket(port);
    myMServer.myAction(serverSocket);
  }
}