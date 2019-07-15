package pro.nevercute.tut.patterns.strategy.duck;

public abstract class Duck {
    private FlyBehavior flyBehavior;
    private QuackBehavior quackBehavior;

    public Duck(FlyBehavior flyBehavior, QuackBehavior quackBehavior){
        this.flyBehavior = flyBehavior;
        this.quackBehavior = quackBehavior; 
    }

    public void swim(){
        System.out.println(this.getClass().getName() + " swimming");
    };
    public abstract void display();

    public void performFly(){
        flyBehavior.fly(this);
    }

    public void performQuack(){
        quackBehavior.quack(this);
    }

    public void setFlyBehavior(FlyBehavior flyBehavior){
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior){
        this.quackBehavior= quackBehavior;
    }
}
