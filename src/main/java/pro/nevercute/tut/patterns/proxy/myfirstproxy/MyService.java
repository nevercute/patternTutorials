package pro.nevercute.tut.patterns.proxy.myfirstproxy;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyService extends Remote {
    public String getResponse() throws RemoteException;
    public String getRegards() throws RemoteException;
}
