package pro.nevercute.tut.patterns.proxy.remote;

import pro.nevercute.tut.patterns.state.gumball.State;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GumballMachineService extends Remote {
    public int getCount() throws RemoteException;
    public String getLocation() throws RemoteException;
    public State getState() throws RemoteException;
}
