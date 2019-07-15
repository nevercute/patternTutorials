package pro.nevercute.tut.patterns.complex.duck;

public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        AbstractDuckFactory factory = new CountingDuckFactory();
        simulator.simulate(factory);
    }

    public void simulate(AbstractDuckFactory factory){
        Flock flock = new Flock();
        flock.add(factory.createMallardDuck());
        flock.add(factory.createRedheadDuck());
        flock.add(factory.createDuckCall());
        flock.add(factory.createRubberDuck());
        flock.add(factory.createDuckLikeGoose());

        Flock flockOfMallards = new Flock();
        flockOfMallards.add(factory.createMallardDuck());
        flockOfMallards.add(factory.createMallardDuck());
        flockOfMallards.add(factory.createMallardDuck());
        flockOfMallards.add(factory.createMallardDuck());

        Quackologist quackologist = new Quackologist();
        flock.registerObserver(quackologist);
        flockOfMallards.registerObserver(quackologist);

        System.out.println("Whole duck flock simulation");
        performQuack(flock);

        System.out.println("Mallart Duck simulator");
        performQuack(flockOfMallards);
        
        System.out.println("QuackCounter = "+QuackCounter.getQuackCount());
    }

    public void performQuack(Quackable duck){
        duck.quack();
    }
}
                                                            