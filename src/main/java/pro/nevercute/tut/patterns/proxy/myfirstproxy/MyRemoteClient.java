package pro.nevercute.tut.patterns.proxy.myfirstproxy;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MyRemoteClient {
    public static void main(String[] args) {
        new MyRemoteClient().go();
    }

    private void go() {
        try{
            Registry registry = LocateRegistry.getRegistry(9997);
            MyService service =  (MyService) registry.lookup("RemoteHello");
            System.out.println(service.getResponse());
            System.out.println(service.getRegards());
        }
        catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } 
    }
}
