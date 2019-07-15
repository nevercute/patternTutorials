package pro.nevercute.tut.patterns.strategy.duck;

public class MuteQuack implements QuackBehavior {
    @Override
    public void quack(Duck duck) {
        System.out.println(duck.getClass().getName() + " can't quack");
    }
}
