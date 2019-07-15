package pro.nevercute.tut.patterns.adapters.duck;

public class MallardDuck implements Duck {
    @Override
    public void quack() {
        System.out.println("Mallard Duck quack");
    }

    @Override
    public void fly() {
        System.out.println("Mallard Duck fly");
    }
}
