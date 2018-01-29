package cmmdc.socket.server.i;

import java.net.ServerSocket;
public interface IMyMServer{
  public ServerSocket getServerSocket(int port);
  public void myAction(ServerSocket serverSocket);
}  