package pro.nevercute.tut.patterns.strategy.duck;

public class ModelDuck extends Duck {
    public ModelDuck() {
        super(new FlyNoWay(), new Squeak());
    }

    @Override
    public void display() {
        System.out.println("I'm a model duck");
    }
}
