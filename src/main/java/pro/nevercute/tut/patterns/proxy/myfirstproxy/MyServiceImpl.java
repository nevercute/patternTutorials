package pro.nevercute.tut.patterns.proxy.myfirstproxy;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MyServiceImpl extends UnicastRemoteObject implements MyService{

    protected MyServiceImpl() throws RemoteException {
        super(9997);
    }

    @Override
    public String getResponse() throws RemoteException {
        return "Hello, I'm your service with RMI";
    }

    @Override
    public String getRegards() throws RemoteException {
        return "Regards from service";
    }

    public static void main(String[] args) {
        try{
            MyService service = new MyServiceImpl();
            UnicastRemoteObject.unexportObject(service, true);
            final Remote remote = UnicastRemoteObject.exportObject(service, 9997);
            final Registry registry = LocateRegistry.createRegistry(9997);
            registry.bind("RemoteHello", remote);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
