package pro.nevercute.tut.patterns.state.gumball;

import pro.nevercute.tut.patterns.proxy.remote.GumballMachineService;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GumballMachine extends UnicastRemoteObject implements GumballMachineService, Serializable {
    private State noQuarterState;
    private State hasQuarterState;
    private State soldState;
    private State soldOutState;
    private State winnerState;
    private String location;
    private State state = soldOutState;
    private int count;

    public GumballMachine(int count, String location) throws RemoteException {
        super(9997);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldOutState = new SoldOutState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);
        this.count = count;
        if(count > 0){
            state = noQuarterState;
        }
        this.location = location;
    }

    public void insertQuarter(){
        state.insertQuarter();
    }

    public void ejectQuarter(){
        state.ejectQuarter();
    }

    public void turnCrunk(){
        state.turnCrank();
        state.dispense();
    }

    void releaseBall(){
        System.out.println("A gumball comes rolling out the slot...");
        if(count != 0){
            count -= 1;
        }
    }

    void refill(int count){
        this.count = count;
        state = noQuarterState;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Gumball Machine has "+getCount()+" gumballs, quarter state = "+state;
    }

    public void setNoQuarterState(State noQuarterState) {
        this.noQuarterState = noQuarterState;
    }

    public void setHasQuarterState(State hasQuarterState) {
        this.hasQuarterState = hasQuarterState;
    }

    public void setSoldState(State soldState) {
        this.soldState = soldState;
    }

    public void setSoldOutState(State soldOutState) {
        this.soldOutState = soldOutState;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getWinnerState() {
        return winnerState;
    }

    public void setState(State state){
        this.state = state;
    }

    public State getState(){
        return this.state;
    }

    public String getLocation() {
        return location;
    }
}
