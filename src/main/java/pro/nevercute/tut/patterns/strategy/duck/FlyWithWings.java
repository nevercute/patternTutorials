package pro.nevercute.tut.patterns.strategy.duck;

public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly(Duck duck) {
        System.out.println(duck.getClass().getName() + " flying with wings");
    }
}
