package pro.nevercute.tut.patterns.proxy.remote;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class GumballMonitor {
    private GumballMachineService gumballMachine;
    public GumballMonitor(GumballMachineService gumballMachine){
        this.gumballMachine = gumballMachine;
    }

    public static void main(String args[]){
        try{
            Registry registry = LocateRegistry.getRegistry(9997);
            GumballMachineService gumballMachine =  (GumballMachineService) registry.lookup("GumballMonitor");
            GumballMonitor monitor = new GumballMonitor(gumballMachine);
            monitor.report();
        } catch (AccessException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }

    public void report(){
        try{
            System.out.println("Gumball Machine at: "+gumballMachine.getLocation());
            System.out.println("Inventory : "+gumballMachine.getCount()+" gumballs.");
            System.out.println("Current state : "+gumballMachine.getState());
        }catch (RemoteException e){
            e.printStackTrace();
        }

    }
}
