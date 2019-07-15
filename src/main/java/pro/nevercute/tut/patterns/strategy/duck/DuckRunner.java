package pro.nevercute.tut.patterns.strategy.duck;

public class DuckRunner {
    public static void main(String[] args) {
        ModelDuck modelDuck = new ModelDuck();
        modelDuck.display();    
        modelDuck.swim();
        modelDuck.performFly();
        modelDuck.performQuack();
        System.out.println();
        modelDuck.setFlyBehavior(new FlyRocketImpl());
        modelDuck.performFly();
    }
}
