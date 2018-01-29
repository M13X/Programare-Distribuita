package cmmdc.datagramchannel.i;
import java.nio.channels.DatagramChannel;
public interface IMyMServer{
  public DatagramChannel getDatagramChannel(int port);
  public void myAction(DatagramChannel datagramChannel);
}  