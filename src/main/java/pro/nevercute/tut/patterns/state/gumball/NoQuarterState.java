package pro.nevercute.tut.patterns.state.gumball;

public class NoQuarterState implements State {
    private transient  GumballMachine gumballMachine;
    public NoQuarterState(GumballMachine gumballMachine){
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You inserted a quarter");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter() {
        System.out.println("You haven't insert a quarter");
    }

    @Override
    public void turnCrank() {
        System.out.println("Yoy turned, bta there's no qaurter");
    }

    @Override
    public void dispense() {
        System.out.println("You need to pay first");
    }
}
