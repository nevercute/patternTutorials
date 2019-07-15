package pro.nevercute.tut.patterns.decorator.starbuzz;

public class Decaf extends Beverage {
    public Decaf() {
        super("Decaf", 1.05f);
    }

    @Override
    float cost() {
        return getCost();
    }
}
