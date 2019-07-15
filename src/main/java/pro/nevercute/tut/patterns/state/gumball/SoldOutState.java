package pro.nevercute.tut.patterns.state.gumball;

public class SoldOutState implements State {
    private transient  GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("There's no gumball in machine. You haven't insert a quarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("There's no quarter was inserted");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned, but there's no gumball");
    }

    @Override
    public void dispense() {
        System.out.println("There's no gumball dispensed");
    }
}
