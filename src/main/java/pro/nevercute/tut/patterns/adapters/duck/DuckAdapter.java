package pro.nevercute.tut.patterns.adapters.duck;

public class DuckAdapter implements Turkey {
    private Duck duck;

    public DuckAdapter(Duck duck){
        this.duck = duck;
    }

    @Override
    public void gobble() {
        duck.quack();
    }

    @Override
    public void fly() {
        duck.fly();
    }
}
