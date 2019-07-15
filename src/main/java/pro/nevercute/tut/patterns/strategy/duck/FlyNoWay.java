package pro.nevercute.tut.patterns.strategy.duck;

public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly(Duck duck) {
        System.out.println(duck.getClass().getName()+" can't flying");
    }
}
