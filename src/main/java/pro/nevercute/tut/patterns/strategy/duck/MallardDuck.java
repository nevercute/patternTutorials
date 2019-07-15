package pro.nevercute.tut.patterns.strategy.duck;

public class MallardDuck extends Duck {
    public MallardDuck() {
        super(new FlyWithWings(), new Quack());
    }

    @Override
    public void display() {
        System.out.println(this.getClass().getName() + " appears on display, wow!");
    }
}
