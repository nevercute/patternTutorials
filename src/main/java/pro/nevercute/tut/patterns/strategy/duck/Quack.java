package pro.nevercute.tut.patterns.strategy.duck;

public class Quack implements QuackBehavior {
    @Override
    public void quack(Duck duck) {
        System.out.println(duck.getClass().getName() + " made some quacking");
    }
}