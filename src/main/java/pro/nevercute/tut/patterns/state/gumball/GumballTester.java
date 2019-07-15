package pro.nevercute.tut.patterns.state.gumball;

import pro.nevercute.tut.patterns.proxy.remote.GumballMachineService;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class GumballTester {
    public static void main(String[] args) {
        if(args.length < 2){
            System.out.println("2 args needed: <count> <location>");
            System.exit(1);
        }
        int count = 0;
        count = Integer.parseInt(args[0]);
        try{
            GumballMachineService gumballMachine = new GumballMachine(count, args[1]);
            UnicastRemoteObject.unexportObject(gumballMachine, true);
            Remote remote = UnicastRemoteObject.exportObject(gumballMachine,9997);
            Registry registry = LocateRegistry.createRegistry(9997);
            registry.bind("GumballMonitor", remote);
        }
        catch (RemoteException e){
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
