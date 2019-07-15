package pro.nevercute.tut.patterns.strategy.duck;

public class Squeak implements QuackBehavior {
    @Override
    public void quack(Duck duck) {
        System.out.println(duck.getClass().getName() + " squeaking");
    }
}
