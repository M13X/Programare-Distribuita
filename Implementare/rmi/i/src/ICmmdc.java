package cmmdc.rmi.i;

public interface ICmmdc extends java.rmi.Remote {
    long cmmdc(long a,long b) throws java.rmi.RemoteException;
	 int[][] tablou(int n, int d) throws java.rmi.RemoteException;
}

    
